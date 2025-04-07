package com.example.webmakeup.services;

import com.example.webmakeup.models.Revenue;

import java.time.LocalDate;
import java.util.List;

public interface RevenueService {
    Revenue createRevenue(Revenue revenue);
    List<Revenue> getAllRevenue();
    Revenue getRevenueById(Long id);
    List<Revenue> getRevenueByBranchId(Long branchId);
    List<Revenue> getRevenueByDateRange(LocalDate start, LocalDate end);
}