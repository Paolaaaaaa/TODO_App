package com.todo.demo.domain.service.validator;

import com.todo.demo.persistence.entities.Notification;

public class NotificationValidator {
    
 public static void validate(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("The notification can't be null");
        }

        if (notification.getDescription() == null || notification.getDescription().isBlank()) {
            throw new IllegalArgumentException("The description of the notification is required");
        }

        if (notification.getPeopleNotified() == null || notification.getPeopleNotified().isEmpty()) {
            throw new IllegalArgumentException("At least one person must be notified");
        }

        if (notification.getTask() == null || notification.getTask().getId() == null) {
            throw new IllegalArgumentException("The notification must be associated with a valid Task");
        }
    }
    
}
