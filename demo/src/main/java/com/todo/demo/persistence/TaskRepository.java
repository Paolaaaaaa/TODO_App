package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.todo.demo.persistence.crud.TaskCrudRepository;
import com.todo.demo.persistence.entities.Task;
import com.todo.demo.persistence.entities.enums.ActionType;
import com.todo.demo.persistence.entities.enums.Status;
import com.todo.demo.persistence.entities.enums.TaskType;


@Repository
public class TaskRepository {
    

    private TaskCrudRepository taskRespository;

public List<Task> getAll() {
    return taskRespository.findAllByOrderByCreationDateAsc();
}
    public List<Task> getByTaskTypeAndPerson (UUID id_person, TaskType taskType){
        return taskRespository.findByTaskTypeAndPersonId(taskType, id_person);
    }


    public List<Task> getByActionTypeAndIdPerson( UUID id_person, ActionType actionType){
        return taskRespository.findByActionTypeAndPersonId(actionType, id_person);
    }


    public List<Task> getByStatusAndIdPerson(UUID id_person, Status status){
        return taskRespository.findByStatusAndPersonId(status, id_person);
    }

    public List<Task> getByParentIdAndIdPerson (UUID id_parent,UUID id_person){
        return taskRespository.findByParentIdAndPersonId(id_parent, id_person);
    }

    public Optional<Task> getTask(UUID id_task){
        return taskRespository.findById(id_task);


    }

    

    public Task createTask (Task task){
        return taskRespository.save(task);
    }

    public Task updateTask (Task task){
        return taskRespository.save(task);
    }


    public void delere (UUID id_task){
        taskRespository.deleteById(id_task);
    }

    




}
