package com.example.webmakeup.services;


import com.example.webmakeup.models.Reservation;
import com.example.webmakeup.repositories.ReservationRepository;
import com.example.webmakeup.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = getReservationById(id);
        existingReservation.setStatus(reservation.getStatus());
        existingReservation.setReservationDateTime(reservation.getReservationDateTime());
        existingReservation.setService(reservation.getService());
        existingReservation.setCustomer(reservation.getCustomer());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public void cancelReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservation.setStatus("Cancelled");
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(Long customerId) {
        return reservationRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Reservation> getReservationsByStatus(String status) {
        return reservationRepository.findByStatus(status);
    }

    @Override
    public List<Reservation> getReservationsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return reservationRepository.findByReservationDateTimeBetween(start, end);
    }
}

