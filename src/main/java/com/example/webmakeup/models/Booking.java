package com.example.webmakeup.models;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long branchId;
    private Long makeupArtistId;

    public Booking() {
    }

    public Booking(Long customerId, Long branchId, Long makeupArtistId) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.makeupArtistId = makeupArtistId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getMakeupArtistId() {
        return makeupArtistId;
    }

    public void setMakeupArtistId(Long makeupArtistId) {
        this.makeupArtistId = makeupArtistId;
    }
}

