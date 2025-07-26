package com.todo.demo.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.demo.domain.dto.ProyectDTO;
import com.todo.demo.domain.service.validator.ProyectValidator;
import com.todo.demo.persistence.ProyectRepository;
import com.todo.demo.persistence.entities.PeopleProyectPermits;
import com.todo.demo.persistence.entities.Proyect;
import com.todo.demo.persistence.entities.enums.Permit;

public class ProyectService {


    @Autowired
    private ProyectRepository proyectRepository;

    @Autowired
    private PermitService permitService;


    /**
     * create a proyect
     * @param proyect
     * @return
     */

    public Proyect createProyect(ProyectDTO proyectDTO){
        ProyectValidator.validate(proyectDTO);

        Proyect newProyect = new Proyect();
        newProyect.setId(UUID.randomUUID());
        newProyect.setTitle(proyectDTO.getTitle());
        newProyect.setDescription(proyectDTO.getDescription());
        newProyect.setPrivacyLevel(proyectDTO.getPrivacyLevel());
        Proyect createProyect = proyectRepository.createProyect(newProyect);
        permitService.createPermit(createProyect.getId(), proyectDTO.getCreatorId(), Permit.ADMIN);
        
        return newProyect;


    }



    /**
     * Obtiene el detalle de los proyectos con el id de una persona
     * @param id_person
     * @return
     */

    public List<Proyect> getPersonsProyects(UUID id_person){


        List<Proyect> personsProyects = new ArrayList<>();

        List<PeopleProyectPermits> found_permits=permitService.getPermitsByPeople(id_person);
        for (PeopleProyectPermits permit : found_permits) {
            
          UUID projectId = permit.getId().getIdProyect();
        proyectRepository.getById(projectId).ifPresent(personsProyects::add);
            
        }
        
        return personsProyects;
    }


    /**
     * get proyect details
     * @param id_project
     * @return
     */
    public Optional<Proyect> getProyect (UUID id_project){
        return proyectRepository.getById(id_project);
    }
    

    /**
     * actualización de proyectos
     * @param id_proyect
     * @param proyect
     * @return
     */
    public Proyect updateProyect (UUID id_proyect, Proyect proyect){

        Optional<Proyect> foundProyect = getProyect(id_proyect);

        if (! foundProyect.isPresent() ){
            throw new IllegalArgumentException("There is no project with set id");

        }


        proyect.setId(id_proyect);
        
        return proyectRepository.updateProyect(proyect, id_proyect);
    }
}
