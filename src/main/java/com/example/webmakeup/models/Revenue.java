package com.example.webmakeup.models;


import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "revenues")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalRevenue;

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "branch_id")
    private Long branchId;

    // Constructors, getters, setters
    public Revenue() {}

    public Revenue(Double totalRevenue, LocalDate date, Long branchId) {
        this.totalRevenue = totalRevenue;
        this.date = date;
        this.branchId = branchId;
    }


}

