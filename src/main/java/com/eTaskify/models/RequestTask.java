package com.eTaskify.models;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Valid
public class RequestTask {
    private String name;
    private String title;
    private String description;
    private LocalDate deadline;
    private List<Long> idUsers;

    public RequestTask() {
    }

    public String getName() {
        return name;
    }

    public RequestTask setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RequestTask setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RequestTask setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public RequestTask setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public List<Long> getIdUsers() {
        return idUsers;
    }

    public RequestTask setIdUsers(List<Long> idUsers) {
        this.idUsers = idUsers;
        return this;
    }
}
