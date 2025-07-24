package com.todo.demo.persistence.entities;


import com.todo.demo.persistence.entities.enums.Permit;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="proyectPermit")
public class PeopleProyectPermits {



    @EmbeddedId
    private PeopleProyectPK id;


    private Permit permitLvel;

    /**
     * @return PeopleProyectPK return the id
     */
    public PeopleProyectPK getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(PeopleProyectPK id) {
        this.id = id;
    }

    /**
     * @return Permit return the permitLvel
     */
    public Permit getPermitLvel() {
        return permitLvel;
    }

    /**
     * @param permitLvel the permitLvel to set
     */
    public void setPermitLvel(Permit permitLvel) {
        this.permitLvel = permitLvel;
    }

}