package com.eTaskify.models;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Valid
public class RequestSignUp {
    private String organizationName;
    private String phoneNumber;
    private String address;
    private String name;
    private String surname;
    private String email;
    @Min(6)
    private String password;

    public RequestSignUp() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public RequestSignUp setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RequestSignUp setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RequestSignUp setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public RequestSignUp setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RequestSignUp setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RequestSignUp setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequestSignUp setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "RequestSignUp{" +
                "organizationName='" + organizationName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
