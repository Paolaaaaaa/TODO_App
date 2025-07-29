package com.todo.demo.domain.service.jwt;

import java.util.UUID;

import com.todo.demo.JwtSecurity.JwtUtil;
import com.todo.demo.domain.dto.AuthResponseDTO;
import com.todo.demo.domain.dto.LoginDTO;
import com.todo.demo.domain.service.validator.PersonValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.todo.demo.domain.dto.PersonDTO;
import com.todo.demo.persistence.PersonRepository;
import com.todo.demo.persistence.entities.Person;

import javax.management.RuntimeErrorException;


@Service
public class AuthService {

    private  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEconder;

    @Autowired
    private JwtUtil jwtUtil;


    public AuthResponseDTO registerUserWithToken(PersonDTO person){

        Person user = new Person();
        user.setId(UUID.randomUUID());
        user.setCellphone(person.getCellphone());
        user.setDescription(person.getDescription());
        user.setEmail(person.getEmail());
        user.setPassword(encoder.encode(person.getPassword()));
        user.setName(person.getName());

        PersonValidator.validate(user);
        Person createdUser=personRepository.createPerson(user);
        String token = jwtUtil.generateTocken(user.getEmail());
        return new AuthResponseDTO(token, createdUser.getId(), createdUser.getEmail());
        

    }

    public String login(LoginDTO person) {
        Person user = personRepository.getPersonsByEmail(person.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Invalid user"));

        if (!passwordEconder.matches(person.getPassword(), user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return jwtUtil.generateTocken(user.getEmail());
    }


    
}