package com.todo.demo.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.persistence.TaskRepository;
import com.todo.demo.persistence.entities.Task;

import jakarta.persistence.EntityNotFoundException;


// TODO: get task by projects , get task by status, get task by type 
@Service
public class TaskService {



    @Autowired
    private TaskRepository taskrepository;




    public Task getTask (UUID id_task){
    Task foundTask = taskrepository.getTask(id_task)
        .orElseThrow(() -> new EntityNotFoundException("Task with ID " + id_task + " does not exist"));

        return foundTask;
    }


    public Task updateTask (UUID id_task, Task task){

        Task foundTask = getTask(id_task);

        foundTask.setId(id_task);

        return taskrepository.createTask(foundTask);

    }







    public Boolean deleteTask(UUID id_task){
            Task task_found = taskrepository.getTask(id_task)
            .orElseThrow(() -> new EntityNotFoundException("Document with ID "+id_task+"does not exist"));
    if (task_found.equals(null)) {
        try {
            taskrepository.delete(id_task);
            return true;
        } catch (Exception e) {
            return false;
        }
    } else {
        return false;
    }
}





    }



    
    



  

    

