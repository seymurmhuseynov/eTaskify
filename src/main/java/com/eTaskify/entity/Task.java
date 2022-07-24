package com.eTaskify.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDate deadline;
    private int status;
    private long closedForUser;
    private LocalDateTime closedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public Task setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Task setStatus(int status) {
        this.status = status;
        return this;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Task setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public long getClosedForUser() {
        return closedForUser;
    }

    public Task setClosedForUser(long closedForUser) {
        this.closedForUser = closedForUser;
        return this;
    }

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public Task setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Task setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", status=" + status +
                ", closedForUser=" + closedForUser +
                ", closedDate=" + closedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
