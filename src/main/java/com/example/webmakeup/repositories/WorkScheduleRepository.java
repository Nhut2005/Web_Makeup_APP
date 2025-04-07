package com.example.webmakeup.repositories;


import com.example.webmakeup.models.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findByArtistId(Long artistId);
    List<WorkSchedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<WorkSchedule> findByIsAvailableTrue();
}