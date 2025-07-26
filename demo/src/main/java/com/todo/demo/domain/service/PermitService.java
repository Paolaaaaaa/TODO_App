package com.todo.demo.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.PermitsRepository;
import com.todo.demo.persistence.entities.PeopleProyectPermits;
import com.todo.demo.persistence.entities.enums.Permit;

import jakarta.persistence.EntityNotFoundException;

public class PermitService {


    //TODO: create a permit , update permits, delte permits, get permits



    private PermitsRepository permitsRepository;

public List<PeopleProyectPermits> getPermitsByProyect(UUID id_project) {
    List<PeopleProyectPermits> permitsFound = permitsRepository.getPermitsByProject(id_project);

    if (permitsFound.isEmpty()) {
        throw new EntityNotFoundException("The project with ID " + id_project + " was not found or has no permits.");
    }

    return permitsFound;
}


public List<PeopleProyectPermits> getPermitsByPeople(UUID id_person){
    List<PeopleProyectPermits> permitsFound =permitsRepository.getPermitsByPerson(id_person);
    if(permitsFound.isEmpty()){
                throw new EntityNotFoundException("The projects related to user " + id_person + " was not found or has no permits.");

    }
    return permitsFound;
}

public PeopleProyectPermits createPermit(UUID idProject, UUID idPerson, Permit permit) {
    Optional<PeopleProyectPermits> existingPermit = permitsRepository.getPermit(idProject, idPerson);

    if (existingPermit.isPresent()) {
        throw new IllegalStateException("The permit already exists. Consider updating it instead.");
    }

    return permitsRepository.createPermit(idPerson, idProject, permit);
}


public Optional<PeopleProyectPermits> updatePermit(UUID idProject, UUID idPerson, Permit permit) {
    Optional<PeopleProyectPermits> existingPermit = permitsRepository.getPermit(idProject, idPerson);

    if (existingPermit.isEmpty()) {
        throw new IllegalStateException("The permit does not exist. Consider creating it instead.");
    }


    PeopleProyectPermits updated = permitsRepository.createPermit(idPerson, idProject,permit); // O usa tu método create si hace esto

    return Optional.of(updated);
}




public boolean deletePermit(UUID idProject, UUID idPerson) {
    Optional<PeopleProyectPermits> existingPermit = permitsRepository.getPermit(idProject, idPerson);

    if (existingPermit.isPresent()) {
        try {
            permitsRepository.delete(idPerson, idProject);
            return true;
        } catch (Exception e) {
            return false;
        }
    } else {
        return false;
    }
}


    
}
