package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {
    List<Revenue> findByBranchId(Long branchId);
    List<Revenue> findByDateBetween(LocalDate startDate, LocalDate endDate);
}