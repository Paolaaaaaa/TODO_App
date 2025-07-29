package com.todo.demo.persistence.crud;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.demo.persistence.entities.Notification;

public interface NotificationCrudRepository extends CrudRepository<Notification,UUID>{

}
