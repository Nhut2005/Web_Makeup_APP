package com.example.webmakeup.repositories;
import com.example.webmakeup.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long customerId); // Tìm kiếm theo khách hàng
    List<Reservation> findByReservationDateTimeBetween(LocalDateTime start, LocalDateTime end); // Tìm kiếm theo khoảng thời gian
    List<Reservation> findByStatus(String status); // Tìm kiếm theo trạng thái
}

