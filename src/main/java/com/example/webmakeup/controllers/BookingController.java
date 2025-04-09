package com.example.webmakeup.controllers;

import com.example.webmakeup.models.Booking;
import com.example.webmakeup.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*") // Cho phép gọi từ frontend
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        // Kiểm tra trùng lịch
        boolean isExist = bookingRepository
            .findByDateAndTimeAndArtist(booking.getDate(), booking.getTime(), booking.getArtist())
            .isPresent();

        if (isExist) {
            throw new RuntimeException("Lịch đã được đặt cho nghệ sĩ này.");
        }

        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
