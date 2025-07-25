package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.demo.domain.repository.ITaskRepository;
import com.todo.demo.persistence.crud.TaskCrudRepository;
import com.todo.demo.persistence.entities.Task;
import com.todo.demo.persistence.entities.enums.ActionType;
import com.todo.demo.persistence.entities.enums.Status;
import com.todo.demo.persistence.entities.enums.TaskType;


@Repository
public class TaskRepository implements ITaskRepository {
    
    @Autowired
    private TaskCrudRepository taskRespository;

public List<Task> getAll() {
    return taskRespository.findAllByOrderByCreationDateAsc();
}
    public List<Task> getByTaskTypeAndPersonAndProject (UUID id_person, TaskType taskType, UUID id_project){
        return taskRespository.findByTaskTypeAndPersonIdAndProject(taskType, id_person,id_project);
    }


    public List<Task> getByActionTypeAndIdPersonAndProject( UUID id_person, ActionType actionType, UUID id_project){
        return taskRespository.findByActionTypeAndPersonIdAndProject(actionType, id_person,id_project);
    }


    public List<Task> getByStatusAndIdPersonAndProject(UUID id_person, Status status,UUID id_project){
        return taskRespository.findByStatusAndPersonIdAndProject(status, id_person, id_project);
    }

    public List<Task> getByParentIdAndIdPersonAndProject (UUID id_parent,UUID id_person, UUID id_project){
        return taskRespository.findByParentIdAndPersonIdAndProject(id_parent, id_person, id_project);
    }

    public Optional<Task> getTask(UUID id_task){
        return taskRespository.findById(id_task);


    }



    public List<Task> getAllbyPersonAndProject( UUID id_person,UUID id_project) {
        return taskRespository.findByPersonIdAndProjectId(id_person,id_project);
    }

    

    public Task createTask (Task task){
        return taskRespository.save(task);
    }

    public Task updateTask (Task task, UUID id){
        task.setId(id);
        return taskRespository.save(task);
    }


    public void delete (UUID id_task){
        taskRespository.deleteById(id_task);
    }

    




}
