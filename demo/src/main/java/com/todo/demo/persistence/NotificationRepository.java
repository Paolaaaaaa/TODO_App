package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.demo.domain.repository.INotificationRepository;
import com.todo.demo.persistence.crud.NotificationCrudRepository;
import com.todo.demo.persistence.entities.Notification;

@Repository
public class NotificationRepository implements INotificationRepository{
    
    
    @Autowired
    private NotificationCrudRepository notificationRespository;






    public Optional<Notification> getById (UUID id){
        return notificationRespository.findById(id);
    }
    public Notification create(Notification notification){
        return notificationRespository.save(notification);
    }


    public Notification update(Notification notification, UUID id){

        notification.setId(id);
        return notificationRespository.save(notification);
    }

    public void delete(UUID id){
         notificationRespository.findById(id);
    }
    
}
