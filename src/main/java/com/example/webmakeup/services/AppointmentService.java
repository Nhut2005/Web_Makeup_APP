package com.example.webmakeup.services;


import com.example.webmakeup.models.Appointment;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByCustomerId(Long customerId);
    List<Appointment> getAppointmentsByArtistId(Long artistId);
    List<Appointment> getAppointmentsByStatus(String status);
    List<Appointment> getAppointmentsByTimeRange(LocalDateTime start, LocalDateTime end);
    Appointment updateAppointmentStatus(Long appointmentId, String status);
}
