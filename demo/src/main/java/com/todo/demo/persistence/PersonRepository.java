package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.todo.demo.persistence.crud.PersonCrudRespository;
import com.todo.demo.persistence.entities.Person;

@Repository
public class PersonRepository {
    

    private PersonCrudRespository personCrudRespository;



    public List<Person> getPersons (){
        return (List<Person>) personCrudRespository.findAll();
    }
    public Optional<Person> getPerson(UUID id_person){
        return personCrudRespository.findById(id_person);
    }


    public List<Person> getPersonsByEmail(String email){
        return personCrudRespository.findByEmail(email);
    }

    public List<Person> getPersonsByCellphone(String cellphone){
        return personCrudRespository.findByCellphone(cellphone);
    }


    public List<Person> getPersonsByName(String name){
        return personCrudRespository.findByName(name);
    }
    public Person createPerson(Person person){
        return personCrudRespository.save(person);

    }


    public Person updatPerson (UUID id_person, Person person){
        person.setId(id_person);
        return personCrudRespository.save(person);
    }

    public void delete (UUID id_person){
         personCrudRespository.deleteById(id_person);
    }



}
