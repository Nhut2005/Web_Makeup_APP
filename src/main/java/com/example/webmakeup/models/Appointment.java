package com.example.webmakeup.models;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Khách hàng đặt lịch

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;   // Nghệ sĩ trang điểm được chọn

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceModel service;  // Dịch vụ được chọn

    private LocalDateTime appointmentTime;  // Thời gian đặt lịch
    private String status;  // Trạng thái (Chờ xác nhận, Đã xác nhận, Đã hoàn thành)

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ServiceModel  getService() {
        return service;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
