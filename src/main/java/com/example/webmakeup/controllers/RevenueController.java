package com.example.webmakeup.controllers;

import com.example.webmakeup.models.Revenue;
import com.example.webmakeup.services.RevenueService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping
    public Revenue createRevenue(@RequestBody Revenue revenue) {
        return revenueService.createRevenue(revenue);
    }

    @GetMapping
    public List<Revenue> getAllRevenue() {
        return revenueService.getAllRevenue();
    }

    @GetMapping("/{id}")
    public Revenue getRevenueById(@PathVariable Long id) {
        return revenueService.getRevenueById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<Revenue> getByBranch(@PathVariable Long branchId) {
        return revenueService.getRevenueByBranchId(branchId);
    }

    @GetMapping("/range")
    public List<Revenue> getByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return revenueService.getRevenueByDateRange(start, end);
    }
}

