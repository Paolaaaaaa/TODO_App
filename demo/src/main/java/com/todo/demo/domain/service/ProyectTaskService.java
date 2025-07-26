package com.todo.demo.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.ProyectRepository;
import com.todo.demo.persistence.TaskRepository;
import com.todo.demo.persistence.entities.Proyect;
import com.todo.demo.persistence.entities.Task;

import jakarta.persistence.EntityNotFoundException;

public class ProyectTaskService {



    private TaskRepository taskRepository;

    private ProyectRepository proyectRepository;

    public List<Task> geTasksByProjectId (UUID id_project){
        return taskRepository.getByIdProject(id_project);
    }


    public List<Task> geTasksByPersonAndProject(UUID id_person, UUID id_project){
        return taskRepository.getAllbyPersonAndProject(id_person, id_project);
        
    }

    public Task createTaskInProyect(Task task, UUID id_project){
  Optional<Proyect> proyectfound = proyectRepository.getById(id_project);

    if (proyectfound.isEmpty()) {
        throw new EntityNotFoundException("The project with ID " + id_project + " was not found");
    }

    task.setProyect(proyectfound.get());
    return taskRepository.createTask(task);

    }


    
}
