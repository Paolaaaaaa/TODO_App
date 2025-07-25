package com.todo.demo.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.todo.demo.persistence.entities.Document;

 public  interface IDocumentRepository {
         Optional<Document> getById (UUID id_document);
     Document create( Document document);

         Document update(UUID id_document, Document document);
     void delete (UUID id_document);

}
