package com.example.webmakeup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webmakeup.models.Receptionist;
import java.util.List;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
    List<Receptionist> findByBranchId(Long branchId);
}

