package com.todo.demo.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.persistence.DocumentRepository;
import com.todo.demo.persistence.TaskRepository;
import com.todo.demo.persistence.entities.Document;
import com.todo.demo.persistence.entities.Task;

import jakarta.persistence.EntityNotFoundException;


//TODO: Connect to GIt 
@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TaskRepository taskRepository;



    /**
     * Get metadata and document.
     * @param id_document
     * @return
     */


    public Document getDocument (UUID id_document){
    Document documentFound = documentRepository.getById(id_document)
        .orElseThrow(() -> new EntityNotFoundException("Document with ID " + id_document + " does not exist"));


    

        //TODO: Get document from github

        return documentFound;
    }

  /**
   * 
   * @param id_document
   * @return
   */

    public Document getDocumentMetaData (UUID id_document){
        Document documentFound = documentRepository.getById(id_document)
        .orElseThrow(() -> new EntityNotFoundException("Document with ID " + id_document + " does not exist"));


        return documentFound;

    }


    
/**
 * creates the reference in database and creates the file in github
 * @param newDocument
 * @return
 */

public Document create(Document newDocument) {
    if (newDocument == null) {
        throw new IllegalArgumentException("The document can't be nulll value");
    }

    if (newDocument.getUrl() == null || newDocument.getUrl().isBlank()) {
        throw new IllegalArgumentException("The URL for the document is required");
    }

    if (newDocument.getNombre() == null || newDocument.getNombre().isBlank()) {
        throw new IllegalArgumentException("The name of the document is required");
    }

    if (newDocument.getTask() == null || newDocument.getTask().getId() == null) {
        throw new IllegalArgumentException("The document should be associated to a Task");
    }

    //TODO: Connect to github to use github as a file system

    UUID id_task = newDocument.getTask().getId();
    Task task = taskRepository.getTask(id_task)
        .orElseThrow(() -> new EntityNotFoundException("Task with " + id_task + " does not exist"));

    newDocument.setTask(task);

    return documentRepository.create(newDocument);
}




/**
 * 
 * @param documentUpdate
 * @param documentId
 * @return
 * 
 * The update is only able to change name or description
 */

public Document update(Document documentUpdate, UUID documentId) {
    Document documentFound = documentRepository.getById(documentId)
        .orElseThrow(() -> new EntityNotFoundException("Document with ID " + documentId + " does not exist"));

    if (!documentFound.getTask().getId().equals(documentUpdate.getTask().getId())) {
        throw new IllegalArgumentException("The task of a document cannot be changed");
    }

    if (documentUpdate.getUrl().equals(documentFound.getUrl())) {
        throw new IllegalArgumentException("The Url of a document cannot be changed");
    }

    documentFound.setNombre(documentUpdate.getNombre());
    documentFound.setDescription(documentUpdate.getDescription());

    return documentRepository.create(documentFound); 
}





/**
 * The delete service should delete the file in github repository and validates if the document exist
 * @param id_document
 * @return
 */



public UUID delete (UUID id_document){


    Document document_found = documentRepository.getById(id_document)
            .orElseThrow(() -> new EntityNotFoundException("Document with ID "+id_document+"does not exist"));

    //TODO: Delete on github 


    documentRepository.delete(document_found.getId());
    return document_found.getId();

}



}
