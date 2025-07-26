package com.todo.demo.domain.service.validator;

import com.todo.demo.persistence.entities.Task;

public class TaskValidator {




    public static void validate(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        if (task.getCost() == null || task.getCost()>=0) {
            throw new IllegalArgumentException("Ivalid, the cost should be greater or equal to 0");
        }

        if (task.getDescription() == null || task.getDescription().isBlank()) {
            throw new IllegalArgumentException("Every person should have a description");
        }

        
    }
    
}
