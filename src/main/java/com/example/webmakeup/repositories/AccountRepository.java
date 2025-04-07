package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    List<Account> findByBranchId(Long branchId);
    List<Account> findByRole(Account.Role role);
}