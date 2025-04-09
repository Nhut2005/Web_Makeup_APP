package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime time;

    private String artist;
    private String service;

    public Booking() {}

    public Booking(LocalDate date, LocalTime time, String artist, String service) {
        this.date = date;
        this.time = time;
        this.artist = artist;
        this.service = service;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }

    public void setTime(LocalTime time) { this.time = time; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public String getService() { return service; }

    public void setService(String service) { this.service = service; }
}
