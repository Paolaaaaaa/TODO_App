package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.PeopleProyectPK;
import com.todo.demo.persistence.entities.PeopleProyectPermits;

public interface PermitsCrudRepository extends CrudRepository<PeopleProyectPermits,PeopleProyectPK> {
    List<PeopleProyectPermits> findById_IdPerson(UUID idPerson);

    List<PeopleProyectPermits> findById_IdProyect(UUID idProyect);

}