package com.todo.demo.persistence.entities;

import java.util.List;
import java.util.UUID;

import com.todo.demo.persistence.entities.enums.PrivacyLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proyect {

    @Id

    @GeneratedValue
    private UUID id;

    private String title; 
    private String description;
    private PrivacyLevel privacyLevel;


    @OneToMany(mappedBy = "proyect")
    private List<Task> tasks;

 
    



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
     * @return PrivacyLevel return the privacyLevel
     */
    public PrivacyLevel getPrivacyLevel() {
        return privacyLevel;
    }

    /**
     * @param privacyLevel the privacyLevel to set
     */
    public void setPrivacyLevel(PrivacyLevel privacyLevel) {
        this.privacyLevel = privacyLevel;
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

}
