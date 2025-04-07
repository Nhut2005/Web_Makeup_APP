package com.example.webmakeup.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., ROLE_OWNER, ROLE_MANAGER

    // Constructors, getters, setters
    public Role() {}

    public Role(String name) {
        this.name = name;
    }
    public String getRole() {
        return name;
    }

    public void setRole(String role) {
        this.name = role;
    }


}