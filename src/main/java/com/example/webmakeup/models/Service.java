package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int durationMinutes;

    @OneToMany(mappedBy = "service")
    private List<UserBooking> bookings;

    // Constructors, getters and setters
}