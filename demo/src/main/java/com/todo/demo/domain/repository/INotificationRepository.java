package com.todo.demo.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.entities.Notification;

public interface INotificationRepository {


         Optional<Notification> getById (UUID id);
     Notification create(Notification notification);
     Notification update(Notification notification, UUID id);
     void delete(UUID id);

}
