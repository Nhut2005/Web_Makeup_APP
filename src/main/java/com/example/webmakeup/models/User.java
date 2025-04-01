package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String username;
    private String password;

    // Add this constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and Setter methods for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Default constructor (if necessary)
    public User() {
    }
}