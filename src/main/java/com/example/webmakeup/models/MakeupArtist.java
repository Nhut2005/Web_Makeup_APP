package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "makeup_artists")
public class MakeupArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "artist")
    private List<UserBooking> bookings;

    // Constructors, getters and setters
}