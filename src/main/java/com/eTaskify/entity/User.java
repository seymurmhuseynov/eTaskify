package com.eTaskify.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @NotBlank
    @NotNull(message = "name not be null")
    private String name;
    @NotBlank
    @NotNull(message = "surname not be null")
    private String surname;
    @NotBlank
    @NotNull(message = "email not be null")
    @Column(nullable = false, unique = true)
    private String email;
    @Size(min = 6)
    @Column(name = "`password`", nullable = false)
    private String password;

    @Column(name = "`type`")
    private int type;

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id")
    private Organization organization;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public User setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public int getType() {
        return type;
    }

    public User setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", organization=" + organization +
                ", roles=" + roles +
                '}';
    }
}