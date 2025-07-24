package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.todo.demo.persistence.entities.Task;
import com.todo.demo.persistence.entities.enums.ActionType;
import com.todo.demo.persistence.entities.enums.Status;
import com.todo.demo.persistence.entities.enums.TaskType;

public interface TaskCrudRepository extends CrudRepository<Task,UUID>{


    
List<Task> findAllByOrderByCreationDateAsc();


   @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.taskType = :taskType AND p.id = :personId")
    List<Task> findByTaskTypeAndPersonId(@Param("taskType") TaskType taskType, @Param("personId") UUID personId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.actionType = :actionType AND p.id = :personId")
    List<Task> findByActionTypeAndPersonId(@Param("actionType") ActionType actionType, @Param("personId") UUID personId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.status = :status AND p.id = :personId")
    List<Task> findByStatusAndPersonId(@Param("status") Status status, @Param("personId") UUID personId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.parent.id = :parentId AND p.id = :personId")
    List<Task> findByParentIdAndPersonId(@Param("parentId") UUID parentId, @Param("personId") UUID personId);





}
