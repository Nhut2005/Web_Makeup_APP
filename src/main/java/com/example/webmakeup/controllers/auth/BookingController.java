package com.example.webmakeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    @GetMapping("/booking")
    public String showBookingPage() {
        return "booking"; // Trả về file booking.html trong /templates/
    }
}
