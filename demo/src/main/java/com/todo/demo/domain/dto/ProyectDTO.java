package com.todo.demo.domain.dto;



import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;

import com.todo.demo.persistence.entities.enums.PrivacyLevel;

public class ProyectDTO {

    @NotNull
    private UUID creatorId;

    private String title;

    private String description;

    private PrivacyLevel privacyLevel;

    

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
     * @return UUID return the creatorId
     */
    public UUID getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }

}