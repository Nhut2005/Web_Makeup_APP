package com.example.webmakeup.services;

import com.example.webmakeup.models.Revenue;
import com.example.webmakeup.repositories.RevenueRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;

    public RevenueServiceImpl(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @Override
    public Revenue createRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @Override
    public List<Revenue> getAllRevenue() {
        return revenueRepository.findAll();
    }

    @Override
    public Revenue getRevenueById(Long id) {
        return revenueRepository.findById(id).orElse(null);
    }

    @Override
    public List<Revenue> getRevenueByBranchId(Long branchId) {
        return revenueRepository.findByBranchId(branchId);
    }

    @Override
    public List<Revenue> getRevenueByDateRange(LocalDate start, LocalDate end) {
        return revenueRepository.findByDateBetween(start, end);
    }
}
