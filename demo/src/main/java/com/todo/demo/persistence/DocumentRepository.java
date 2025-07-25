package com.todo.demo.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.todo.demo.persistence.crud.DocumentCrudRepository;
import com.todo.demo.persistence.entities.Document;

@Repository
public class DocumentRepository {
    
    private DocumentCrudRepository documentCrudRepository;



    public Optional<Document> getById (UUID id_document){
        return documentCrudRepository.findById(id_document);
    }

    public Document create( Document document){
        return documentCrudRepository.save(document);
    }

    public Document update(UUID id_document, Document document){

        document.setId(id_document);
        return documentCrudRepository.save(document);

    }


    public void delete (UUID id_document){
        documentCrudRepository.deleteById(id_document);
    }



}
