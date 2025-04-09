package com.example.webmakeup.models;

import jakarta.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String weekdayHours;
    private String weekendHours;

    // Constructor mặc định (bắt buộc với JPA)
    public Branch() {}

    // Constructor đầy đủ thông tin
    public Branch(String name, String address, String phoneNumber, String email, String weekdayHours, String weekendHours) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.weekdayHours = weekdayHours;
        this.weekendHours = weekendHours;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeekdayHours() {
        return weekdayHours;
    }

    public void setWeekdayHours(String weekdayHours) {
        this.weekdayHours = weekdayHours;
    }

    public String getWeekendHours() {
        return weekendHours;
    }

    public void setWeekendHours(String weekendHours) {
        this.weekendHours = weekendHours;
    }
}
