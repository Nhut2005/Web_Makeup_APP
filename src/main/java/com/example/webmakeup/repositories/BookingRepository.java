package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByDateAndTimeAndArtist(LocalDate date, LocalTime time, String artist);
}
