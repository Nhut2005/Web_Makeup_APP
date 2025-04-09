package com.example.webmakeup.services;

import com.example.webmakeup.models.Appointment;
import com.example.webmakeup.repositories.AppointmentRepository;
// Removed unused import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        // Kiểm tra lịch làm việc của nghệ sĩ có trùng không
        List<Appointment> existingAppointments = appointmentRepository.findByArtistId(appointment.getArtist().getId());
        for (Appointment existingAppointment : existingAppointments) {
            if (existingAppointment.getAppointmentTime().equals(appointment.getAppointmentTime())) {
                throw new RuntimeException("Nghệ sĩ không khả dụng vào thời gian này.");
            }
        }
        // Lưu thông tin đặt lịch
        appointment.setStatus("Chờ xác nhận");
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByCustomerId(Long customerId) {
        return appointmentRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Appointment> getAppointmentsByArtistId(Long artistId) {
        return appointmentRepository.findByArtistId(artistId);
    }

    @Override
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    @Override
    public List<Appointment> getAppointmentsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAppointmentTimeBetween(start, end);
    }

    @Override
    public Appointment updateAppointmentStatus(Long appointmentId, String status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn."));
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }
}

