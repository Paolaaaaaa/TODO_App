package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.demo.domain.repository.IPermitRepository;
import com.todo.demo.persistence.crud.PermitsCrudRepository;
import com.todo.demo.persistence.entities.PeopleProyectPK;
import com.todo.demo.persistence.entities.PeopleProyectPermits;
import com.todo.demo.persistence.entities.enums.Permit;


@Repository
public class PermitsRepository implements IPermitRepository {






@Autowired
private PermitsCrudRepository permitsRepository; 




public List<PeopleProyectPermits> getPermitsByProject ( UUID idProject){
    return permitsRepository.findById_IdProyect(idProject);
}

public List<PeopleProyectPermits> getPermitsByPerson ( UUID idProject){
    return permitsRepository.findById_IdPerson(idProject);
}


public Optional<PeopleProyectPermits> getPermit ( UUID idProject, UUID idPerson){

        PeopleProyectPK pk = new PeopleProyectPK(idPerson, idProject);

    return permitsRepository.findById(pk);
}

public PeopleProyectPermits createPermit (UUID idPerson, UUID idProject, Permit newPermit){
    PeopleProyectPK pk = new PeopleProyectPK(idPerson, idProject);
    
    PeopleProyectPermits NewPermit = new PeopleProyectPermits(pk, newPermit);
    return permitsRepository.save(NewPermit);
}


public PeopleProyectPermits update(UUID idPerson, UUID idProject, Permit newPermit){
    PeopleProyectPK pk = new PeopleProyectPK(idPerson, idProject);
    PeopleProyectPermits NewPermit = new PeopleProyectPermits(pk, newPermit);
    return permitsRepository.save(NewPermit);
}


  public void delete(UUID idPerson, UUID idProject) {
        PeopleProyectPK pk = new PeopleProyectPK(idPerson, idProject);
        permitsRepository.deleteById(pk);
    }
    
}
