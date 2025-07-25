package com.todo.demo.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.entities.Person;

public interface IPersonRepository {
    

         List<Person> getPersons ();
     Optional<Person> getPerson(UUID id_person);
     List<Person> getPersonsByEmail(String email);
     List<Person> getPersonsByCellphone(String cellphone);
     List<Person> getPersonsByName(String name);
     Person createPerson(Person person);
     Person updatPerson (UUID id_person, Person person);
     void delete (UUID id_person);

}
