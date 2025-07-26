package com.todo.demo.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.demo.persistence.PersonRepository;
import com.todo.demo.persistence.entities.Person;


public class PersonService {


    @Autowired
    private PersonRepository personRepository;


    //TODO: create a person, update data, delete person, get person


    /**
     * Obtain Person detail
     * @param id_person
     * @return
     */

    public Optional<Person> getPerson(UUID id_person){
        return personRepository.getPerson(id_person);
    }

    /**
     * get details of a list of perople
     * @param listPersons
     * @return
     */

public List<Person> getPersons(UUID[] listPersons) {
    List<Person> peopleDetails = new ArrayList<>();

    for (UUID id : listPersons) {
        personRepository.getPerson(id).ifPresent(peopleDetails::add);
    }

    return peopleDetails;
}

/**
 * create a new person
 * @param newPerson
 * @return
 */


public Person createPerson ( Person newPerson){




    newPerson.setCreatioDate(LocalDate.now());
    

    return personRepository.createPerson(newPerson);
}





}
