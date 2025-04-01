package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "branch")
    private List<UserBooking> bookings;

    // Constructors, getters and setters
}