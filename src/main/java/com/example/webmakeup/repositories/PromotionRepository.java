package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByActiveTrue();
    List<Promotion> findByStartDateBeforeAndEndDateAfter(LocalDate now1, LocalDate now2);
}
