package com.example.webmakeup.models;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_manager")
public class BranchManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long branchId;

    public BranchManager() {
    }

    public BranchManager(String name, Long branchId) {
        this.name = name;
        this.branchId = branchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}