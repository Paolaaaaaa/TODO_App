package com.todo.demo.persistence.crud;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Document;

public interface DocumentCrudRepository extends CrudRepository<Document,UUID>{

    

}
