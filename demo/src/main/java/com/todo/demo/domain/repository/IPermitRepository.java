package com.todo.demo.domain.repository;

import java.util.List;
import java.util.UUID;

import com.todo.demo.persistence.entities.PeopleProyectPermits;
import com.todo.demo.persistence.entities.enums.Permit;

public interface IPermitRepository {

     List<PeopleProyectPermits> getPermitsByProject ( UUID idProject);
 List<PeopleProyectPermits> getPermitsByPerson ( UUID idProject);
 PeopleProyectPermits createPermit (UUID idPerson, UUID idProject, Permit newPermit);

 PeopleProyectPermits update(UUID idPerson, UUID idProject, Permit newPermit);
   void delete(UUID idPerson, UUID idProject) ;

}
