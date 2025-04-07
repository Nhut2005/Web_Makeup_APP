package com.example.webmakeup.services.impl;

import com.example.webmakeup.models.Account;
import com.example.webmakeup.repositories.AccountRepository;
import com.example.webmakeup.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setFullName(accountDetails.getFullName());
        account.setEmail(accountDetails.getEmail());
        account.setPhone(accountDetails.getPhone());
        account.setRole(accountDetails.getRole());
        account.setBranch(accountDetails.getBranch());

        if (accountDetails.getPassword() != null && !accountDetails.getPassword().isEmpty()) {
            account.setPassword(passwordEncoder.encode(accountDetails.getPassword()));
        }

        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountsByBranch(Long branchId) {
        return accountRepository.findByBranchId(branchId);
    }

    @Override
    public List<Account> getAccountsByRole(Account.Role role) {
        return accountRepository.findByRole(role);
    }
}