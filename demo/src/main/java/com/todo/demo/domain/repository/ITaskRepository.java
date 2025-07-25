package com.todo.demo.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.entities.Task;
import com.todo.demo.persistence.entities.enums.ActionType;
import com.todo.demo.persistence.entities.enums.Status;
import com.todo.demo.persistence.entities.enums.TaskType;

public interface ITaskRepository {


    List<Task> getByTaskTypeAndPersonAndProject (UUID id_person, TaskType taskType, UUID id_project);
     List<Task> getByActionTypeAndIdPersonAndProject( UUID id_person, ActionType actionType, UUID id_project);

List<Task> getByStatusAndIdPersonAndProject(UUID id_person, Status status,UUID id_project);


 List<Task> getByParentIdAndIdPersonAndProject (UUID id_parent,UUID id_person, UUID id_project);
 Optional<Task> getTask(UUID id_task);
     List<Task> getAllbyPersonAndProject( UUID id_person,UUID id_project) ;
     Task createTask (Task task);
     Task updateTask (Task task, UUID id);
     void delete (UUID id_task);

}
