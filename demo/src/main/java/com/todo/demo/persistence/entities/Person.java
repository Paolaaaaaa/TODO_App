package com.todo.demo.persistence.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Person {


    @Id
    private UUID id;
    private String name;
    private String description;
    private String email;
    private String cellphone;
    private LocalDate creatioDate;

    private String password;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @ManyToMany
    @JoinTable( name =  "person_tasks", joinColumns = @JoinColumn(name ="person_id"),
    inverseJoinColumns = @JoinColumn(name="task_id"))
    private List<Task> tasks;


    @ManyToMany
    @JoinTable(
        name="notification_Person",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name="notification_id")
    )
    private List<Notification> notifications = new ArrayList<>();


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return LocalDate return the creatioDate
     */
    public LocalDate getCreatioDate() {
        return creatioDate;
    }

    /**
     * @param creatioDate the creatioDate to set
     */
    public void setCreatioDate(LocalDate creatioDate) {
        this.creatioDate = creatioDate;
    }


    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


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

}
