package com.todo.demo.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.PeopleProyectPK;
import com.todo.demo.persistence.entities.PeopleProyectPermits;

public interface PermitsCrudRepository extends CrudRepository<PeopleProyectPermits,PeopleProyectPK> {
    
}