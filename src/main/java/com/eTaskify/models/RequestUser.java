package com.eTaskify.models;

import javax.validation.Valid;

@Valid
public class RequestUser {
    private String name;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public RequestUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RequestUser setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RequestUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
