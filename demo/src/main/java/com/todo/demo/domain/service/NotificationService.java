package com.todo.demo.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.domain.service.validator.NotificationValidator;
import com.todo.demo.persistence.NotificationRepository;
import com.todo.demo.persistence.TaskRepository;
import com.todo.demo.persistence.entities.Notification;
import com.todo.demo.persistence.entities.Task;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotificationService {
    

    //TODO: Connect with email


    @Autowired
    private NotificationRepository notificationRepository;



    @Autowired
    private TaskRepository taskRepository;
    /**
     * get notification by id
     * @param id_notification
     * @param id_person
     * @return
     */

    public Notification geNotificationbyId(UUID id_notification){
            Notification notificationFound = notificationRepository.getById(id_notification)
        .orElseThrow(() -> new EntityNotFoundException("Notification with ID " + id_notification + " does not exist"));

        return notificationFound;
    }




    /**
     * create a notification
     * @param newNotification
     * @return
     */


    public Notification createNotification(Notification newNotification){

 

        NotificationValidator.validate(newNotification);

    
        UUID id_task = newNotification.getTask().getId();
        Task task = taskRepository.getTask(id_task)
            .orElseThrow(() -> new EntityNotFoundException("Task with " + id_task + " does not exist"));

        newNotification.setTask(task);

        //TODO:Integrate with email to send notification to everyone

        return notificationRepository.create(newNotification);


    }



    /**
     * deletes notifications from database
     * 
     * @param id_nofitication
     * @return
     */

    public UUID deleteNotification(UUID id_nofitication){

 


    
        Notification notificationFound = notificationRepository.getById(id_nofitication)
            .orElseThrow(() -> new EntityNotFoundException("Notification with " + id_nofitication + " does not exist"));



        notificationRepository.delete(notificationFound.getId());;

        return notificationFound.getId();


    }


    







    }






