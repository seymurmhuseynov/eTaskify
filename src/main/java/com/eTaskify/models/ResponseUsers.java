package com.eTaskify.models;

public class ResponseUsers {
    private long id;
    private String name;
    private String surname;
    private String email;

    public ResponseUsers() {
    }

    public long getId() {
        return id;
    }

    public ResponseUsers setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseUsers setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ResponseUsers setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResponseUsers setEmail(String email) {
        this.email = email;
        return this;
    }
}
