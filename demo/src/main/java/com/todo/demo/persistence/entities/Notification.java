package com.todo.demo.persistence.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {

     @Id
   
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    
    @ManyToOne
    @JoinColumn(name = "task_id", insertable = false, updatable = false )
    private Task task;

    @ManyToMany
    private List<Person> peopleNotified = new ArrayList<>();




    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return LocalDateTime return the creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return Task return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * @return List<Person> return the peopleNotified
     */
    public List<Person> getPeopleNotified() {
        return peopleNotified;
    }

    /**
     * @param peopleNotified the peopleNotified to set
     */
    public void setPeopleNotified(List<Person> peopleNotified) {
        this.peopleNotified = peopleNotified;
    }

}
