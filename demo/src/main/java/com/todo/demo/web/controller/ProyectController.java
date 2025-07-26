package com.todo.demo.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.domain.dto.ProyectDTO;
import com.todo.demo.domain.service.ProyectService;
import com.todo.demo.persistence.entities.Proyect;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/proyect")
public class ProyectController {


    @Autowired
    private ProyectService proyectService;


    /**
     * Creates a new proyect without tasks and with a privacy level
     * @param proyectDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<Proyect> createProyect( @RequestBody ProyectDTO proyectDTO) {

        Proyect createdProyect = proyectService.createProyect(proyectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProyect);
    }




    /**
     * get detail of a specific user
     * @param idUser
     * @return
     */


    @GetMapping("/{idUser}")
    public List<Proyect> getProyects(@PathVariable UUID idUser) {
            return proyectService.getPersonsProyects(idUser);
        }
    
    



}
