package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Person;
import org.springframework.data.repository.query.Param;

public interface PersonCrudRespository extends CrudRepository<Person,UUID>{

    @Query("SELECT p FROM Person p WHERE p.email = :email")
    Optional<Person> findByEmail(@Param("email") String email);

    List<Person> findByCellphone(String cellphone);
    List<Person> findByName(String name);

}
