package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_bookings")  
public class UserBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private MakeupArtist artist;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    
    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private LocalTime bookingTime;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();


    @Column(nullable = false)
    private String bookingType;


    @Column(nullable = false)
    private String locationType;


    @Column(length = 500)
    private String homeAddress;

    @Column(length = 100)
    private String homeLocationNotes;


    @Column(nullable = false)
    private double totalPrice;

    @Column
    private String paymentMethod;

    @Column
    private String transactionId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.PENDING;

    @Column(length = 500)
    private String cancellationReason;

    // Constructors
    public UserBooking() {
        
    }


    public enum BookingStatus {
        PENDING,   
        CONFIRMED, 
        COMPLETED, 
        CANCELLED, 
        NO_SHOW    
    }

    // Getter và setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean isAtHome() {
        return "HOME".equalsIgnoreCase(locationType);
    }

    public boolean isSpecificTimeBooking() {
        return "SPECIFIC_TIME".equalsIgnoreCase(bookingType);
    }

    public void cancel(String reason) {
        this.status = BookingStatus.CANCELLED;
        this.cancellationReason = reason;
        this.updatedAt = LocalDateTime.now();
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }


    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}