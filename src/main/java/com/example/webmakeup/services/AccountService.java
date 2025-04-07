package com.example.webmakeup.services;

import com.example.webmakeup.models.Account;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account updateAccount(Long id, Account account);
    void deleteAccount(Long id);
    Account getAccountById(Long id);
    List<Account> getAllAccounts();
    List<Account> getAccountsByBranch(Long branchId);
    List<Account> getAccountsByRole(Account.Role role);
}