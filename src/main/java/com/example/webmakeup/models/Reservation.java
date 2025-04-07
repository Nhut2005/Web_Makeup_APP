package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Khách hàng đặt chỗ

    @lombok.Getter
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceModel service;   // Dịch vụ mà khách hàng đặt

    private LocalDateTime reservationDateTime; // Thời gian đặt chỗ
    private String status;                       // Trạng thái đặt chỗ (chờ xác nhận, đã xác nhận, đã hoàn thành, v.v.)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
