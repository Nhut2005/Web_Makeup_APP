package com.example.webmakeup.repositories;

import com.example.webmakeup.models.UserBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<UserBooking, Long> {
    List<UserBooking> findByStatus(String status);
    List<UserBooking> findByUserId(Long userId);
}