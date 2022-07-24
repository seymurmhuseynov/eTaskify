package com.eTaskify.entity;

import javax.persistence.*;

@Entity
@Table(name = "task_assign")
public class TaskAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id")
    private Task task;

    public TaskAssign() {
    }

    public long getId() {
        return id;
    }

    public TaskAssign setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public TaskAssign setUser(User user) {
        this.user = user;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public TaskAssign setTask(Task task) {
        this.task = task;
        return this;
    }
}
