package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Proyect;
import com.todo.demo.persistence.entities.enums.PrivacyLevel;

public interface ProyectCrudRepository extends CrudRepository<Proyect,UUID> {
    List<Proyect> findByPrivacyLevel(PrivacyLevel privacyLevel);

   

}
