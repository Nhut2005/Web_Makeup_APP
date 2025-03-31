package com.example.webmakeup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webmakeup.models.BranchManager;
import java.util.List;

@Repository
public interface BranchManagerRepository extends JpaRepository<BranchManager, Long> {
    List<BranchManager> findByBranchId(Long branchId);
}
