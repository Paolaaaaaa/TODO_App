package com.todo.demo.domain.service.validator;

import com.todo.demo.domain.dto.ProyectDTO;

public class ProyectValidator {
    
 public static void validate(ProyectDTO newProyect) {
        if (newProyect == null) {
            throw new IllegalArgumentException("The proyect can't be null");
        }

        if (newProyect.getDescription() == null || newProyect.getDescription().isBlank()) {
            throw new IllegalArgumentException("The description of the notification is required");
        }

        if (newProyect.getPrivacyLevel() == null ) {
            throw new IllegalArgumentException("Proyect should have a privacy level");
        }

        if (newProyect.getTitle() == null || newProyect.getTitle() == null) {
            throw new IllegalArgumentException("The notification must be associated with a valid Task");
        }
    }
    

}
