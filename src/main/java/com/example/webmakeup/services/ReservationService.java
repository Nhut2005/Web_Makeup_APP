package com.example.webmakeup.services;

import com.example.webmakeup.models.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    Reservation updateReservation(Long id, Reservation reservation);
    void cancelReservation(Long id);
    List<Reservation> getReservationsByCustomerId(Long customerId);
    List<Reservation> getReservationsByStatus(String status);
    List<Reservation> getReservationsByTimeRange(LocalDateTime start, LocalDateTime end);
}
