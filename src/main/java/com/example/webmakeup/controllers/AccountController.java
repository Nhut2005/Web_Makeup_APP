package com.example.webmakeup.controllers;

import com.example.webmakeup.models.Account;
import com.example.webmakeup.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "accounts/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("roles", Account.Role.values());
        return "accounts/add";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute Account account) {
        accountService.createAccount(account);
        return "redirect:/admin/accounts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        model.addAttribute("roles", Account.Role.values());
        return "accounts/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAccount(@PathVariable Long id, @ModelAttribute Account account) {
        accountService.updateAccount(id, account);
        return "redirect:/admin/accounts";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/admin/accounts";
    }
}