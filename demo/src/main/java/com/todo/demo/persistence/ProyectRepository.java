package com.todo.demo.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.demo.domain.repository.IProyectRepository;
import com.todo.demo.persistence.crud.ProyectCrudRepository;
import com.todo.demo.persistence.entities.Proyect;
import com.todo.demo.persistence.entities.enums.PrivacyLevel;

@Repository
public class ProyectRepository implements IProyectRepository{

    @Autowired
    private ProyectCrudRepository proyectRepository;

    public List<Proyect> getProyectsByPrivacyLevel(PrivacyLevel privacyLevel)
    {
        return proyectRepository.findByPrivacyLevel(privacyLevel);
    }

    public Optional<Proyect> getById (UUID id_project){
        return proyectRepository.findById(id_project);
    }

       public List<Proyect> getAll (){
        return (List<Proyect>) proyectRepository.findAll();
    }


    public Proyect createProyect(Proyect proyect){
        return proyectRepository.save(proyect);
    }
        public Proyect updateProyect(Proyect proyect, UUID id_project){
            proyect.setId(id_project);
        return proyectRepository.save(proyect);
    }


    public void delete(UUID id_proyect){
         proyectRepository.deleteById(id_proyect);
    }








    
}
