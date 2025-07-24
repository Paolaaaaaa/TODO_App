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

}
