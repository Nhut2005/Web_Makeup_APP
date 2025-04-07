package com.example.webmakeup.controllers;


import com.example.webmakeup.models.Appointment;
import com.example.webmakeup.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/customer/{customerId}")
    public List<Appointment> getAppointmentsByCustomerId(@PathVariable Long customerId) {
        return appointmentService.getAppointmentsByCustomerId(customerId);
    }

    @GetMapping("/artist/{artistId}")
    public List<Appointment> getAppointmentsByArtistId(@PathVariable Long artistId) {
        return appointmentService.getAppointmentsByArtistId(artistId);
    }

    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status) {
        return appointmentService.getAppointmentsByStatus(status);
    }

    @PutMapping("/{appointmentId}/status")
    public Appointment updateAppointmentStatus(@PathVariable Long appointmentId, @RequestParam String status) {
        return appointmentService.updateAppointmentStatus(appointmentId, status);
    }
}
