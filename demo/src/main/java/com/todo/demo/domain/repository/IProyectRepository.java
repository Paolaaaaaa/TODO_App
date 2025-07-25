package com.todo.demo.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.entities.Proyect;
import com.todo.demo.persistence.entities.enums.PrivacyLevel;

public interface IProyectRepository {


         List<Proyect> getProyectsByPrivacyLevel(PrivacyLevel privacyLevel);
     Optional<Proyect> getById (UUID id_project);
        List<Proyect> getAll ();
     Proyect createProyect(Proyect proyect);
         Proyect updateProyect(Proyect proyect, UUID id_project);
     void delete(UUID id_proyect);

    
} 