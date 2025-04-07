package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findByName(String name);
    Optional<Branch> findByEmail(String email);
    List<Branch> findByAddressContaining(String address);
    Optional<Branch> findByPhoneNumber(String phoneNumber);
    List<Branch> findByNameContainingIgnoreCase(String keyword);
}

