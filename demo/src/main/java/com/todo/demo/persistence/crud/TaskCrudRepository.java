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



@Query("SELECT t FROM Task t  WHERE  t.project.id = :projectId ORDER BY t.creationDate")
List<Task> findByProjectId(
    @Param("projectId") UUID projectId);



@Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE p.id = :personId AND t.project.id = :projectId ORDER BY t.creationDate")
List<Task> findByPersonIdAndProjectId(
    @Param("personId") UUID personId, 
    @Param("projectId") UUID projectId);



   @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.taskType = :taskType AND p.id = :personId AND t.project.id = :projectId ORDER BY t.creationDate" )
    List<Task> findByTaskTypeAndPersonIdAndProject(
        @Param("taskType") TaskType taskType, 
        @Param("personId") UUID personId,
        @Param("projectId") UUID projectId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.actionType = :actionType AND p.id = :personId AND t.project.id = :projectId ORDER BY t.creationDate ")
    List<Task> findByActionTypeAndPersonIdAndProject(
        @Param("actionType") ActionType actionType, 
        @Param("personId") UUID personId,
        @Param("projectId") UUID projectId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.status = :status AND p.id = :personId AND t.project.id = :projectId ORDER BY t.creationDate")
    List<Task> findByStatusAndPersonIdAndProject(
        @Param("status") Status status, 
        @Param("personId") UUID personId, 
        @Param("projectId") UUID projectId);

    @Query("SELECT t FROM Task t JOIN t.assignedPersons p WHERE t.parent.id = :parentId AND p.id = :personId AND t.project.id = :projectId ORDER BY t.creationDate")
    List<Task> findByParentIdAndPersonIdAndProject(
        @Param("parentId") UUID parentId, 
        @Param("personId") UUID personId,
        @Param("projectId") UUID projectId);






}
