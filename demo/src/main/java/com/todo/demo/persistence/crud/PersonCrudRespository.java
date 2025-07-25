package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Person;

public interface PersonCrudRespository extends CrudRepository<Person,UUID>{
    
    List<Person> findByEmail(String email);
    List<Person> findByCellphone(String cellphone);
    List<Person> findByName(String name);

}
