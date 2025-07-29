package com.todo.demo.persistence.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.todo.demo.persistence.entities.enums.ActionType;
import com.todo.demo.persistence.entities.enums.Status;
import com.todo.demo.persistence.entities.enums.TaskType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {


    @Id
    private UUID id;

    @Column(length = 100)
    private String description;

    private Status status;

    private TaskType taskType;

    private ActionType actionType;

    private Integer hoursNeeded;

    private LocalDateTime creationDate;

    private LocalDateTime finalizationDateTime;


    @ManyToMany( mappedBy = "tasks")
    private List<Person> assignesPersons;


    private Integer cost;
    private Integer currency;



    @ManyToOne
    @JoinColumn(name = "id_Proyect", insertable = false, updatable = false)
    private Proyect proyect;


    @ManyToOne
    @JoinColumn(name= "parentTask_id", insertable = false, updatable = false)
    private Task parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> subtask = new ArrayList<>();


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();















    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Status return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return TaskType return the taskType
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * @param taskType the taskType to set
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * @return ActionType return the actionType
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    /**
     * @return Integer return the hoursNeeded
     */
    public Integer getHoursNeeded() {
        return hoursNeeded;
    }

    /**
     * @param hoursNeeded the hoursNeeded to set
     */
    public void setHoursNeeded(Integer hoursNeeded) {
        this.hoursNeeded = hoursNeeded;
    }

    /**
     * @return LocalDateTime return the creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return List<Person> return the assignesPersons
     */
    public List<Person> getAssignesPersons() {
        return assignesPersons;
    }

    /**
     * @param assignesPersons the assignesPersons to set
     */
    public void setAssignesPersons(List<Person> assignesPersons) {
        this.assignesPersons = assignesPersons;
    }

    /**
     * @return Integer return the cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * @return Integer return the currency
     */
    public Integer getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    /**
     * @return Proyect return the proyect
     */
    public Proyect getProyect() {
        return proyect;
    }

    /**
     * @param proyectfound the proyect to set
     */
    public void setProyect(Proyect proyectfound) {
        this.proyect = proyectfound;
    }

    /**
     * @return Task return the parent
     */
    public Task getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Task parent) {
        this.parent = parent;
    }

    /**
     * @return List<Task> return the subtask
     */
    public List<Task> getSubtask() {
        return subtask;
    }

    /**
     * @param subtask the subtask to set
     */
    public void setSubtask(List<Task> subtask) {
        this.subtask = subtask;
    }

    /**
     * @return List<Document> return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


    /**
     * @return List<Notification> return the notifications
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * @param notifications the notifications to set
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}

