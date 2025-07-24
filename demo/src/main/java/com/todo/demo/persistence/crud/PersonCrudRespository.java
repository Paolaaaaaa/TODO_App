package com.todo.demo.persistence.crud;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Person;

public interface PersonCrudRespository extends CrudRepository<Person,UUID>{
    
}
