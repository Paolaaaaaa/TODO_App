package com.todo.demo.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.demo.persistence.NotificationRepository;
import com.todo.demo.persistence.PersonRepository;
import com.todo.demo.persistence.entities.Notification;
import com.todo.demo.persistence.entities.Person;

import jakarta.persistence.EntityNotFoundException;

public class PersonNotificationService {



    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private PersonRepository personRepository;


//    public List<Notification> getNotificationsByPersonId (UUID id_person){
//
//        Person personFound = personRepository.getPerson(id_person)
//        .orElseThrow(() -> new EntityNotFoundException("Person with ID " + id_person + " does not exist"));
//
//
//        List<Notification> notifications = notificationRepository.getByPersonId(personFound.getId());
//
//        return notifications;
//
//    }


   
    


}
