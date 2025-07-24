package com.todo.demo.persistence.crud;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Proyect;

public interface ProyectCrudRepository extends CrudRepository<Proyect,UUID> {
    

}
