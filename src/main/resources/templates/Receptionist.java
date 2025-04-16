package com.example.makeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Receptionist {

    @GetMapping("/letan")
    public String Orders() {
        return "recep"; 
    }

    @GetMapping("/letan/booking")
    public String LetanBooking() {
        return "booking_letan"; 
    }

    @GetMapping("/letan/recep")
    public String LetanRecep() {
        return "manager_letan"; 
    }

    @GetMapping("/letan/add")
    public String recepAdd() {
        return "booking_customer"; 
    }

    @GetMapping("/letan/service")
    public String recepService() {
        return "booking_service"; 
    }

    @GetMapping("/letan/payment")
    public String recepPayment() {
        return "booking_payment"; 
    }





}
