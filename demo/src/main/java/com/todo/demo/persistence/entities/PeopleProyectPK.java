package com.todo.demo.persistence.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class PeopleProyectPK implements Serializable{

    private UUID idPerson;
    private UUID idProyect;






    /**
     * @return UUID return the idPerson
     */
    public UUID getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return UUID return the idProyect
     */
    public UUID getIdProyect() {
        return idProyect;
    }

    /**
     * @param idProyect the idProyect to set
     */
    public void setIdProyect(UUID idProyect) {
        this.idProyect = idProyect;
    }

}
