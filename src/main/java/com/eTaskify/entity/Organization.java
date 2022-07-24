package com.eTaskify.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @NotNull(message = "name number not be null")
    private String name;
    @NotBlank
    @NotNull(message = "phone number not be null")
    private String phoneNumber;
    @NotBlank
    @NotNull(message = "address number not be null")
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization", cascade = CascadeType.ALL)
    private List<User> users=new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Organization() {
    }

    public long getId() {
        return id;
    }

    public Organization setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Organization setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Organization setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Organization setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Organization setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
