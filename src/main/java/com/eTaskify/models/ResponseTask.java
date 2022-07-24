package com.eTaskify.models;

import javax.validation.Valid;
import java.time.LocalDate;

@Valid
public class ResponseTask {
    private long id;
    private String name;
    private String title;
    private String description;
    private String status;
    private LocalDate deadline;

    public ResponseTask() {
    }

    public long getId() {
        return id;
    }

    public ResponseTask setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseTask setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ResponseTask setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ResponseTask setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public ResponseTask setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResponseTask setStatus(String status) {
        this.status = status;
        return this;
    }
}
