package com.example.webmakeup.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@RequestMapping("/api/branch")
public class BranchManagerController {

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Dummy login logic
        if (!username.isEmpty() && !password.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("user", username);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }
    }

    // Get Profile
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        Map<String, String> profile = new HashMap<>();
        profile.put("name", "Nguyễn Văn A");
        profile.put("email", "nguyenvana@example.com");
        profile.put("phone", "0987654321");
        profile.put("position", "Quản lý chi nhánh");
        return ResponseEntity.ok(profile);
    }

    // Get Revenue (Dummy Data)
    @GetMapping("/revenue")
    public ResponseEntity<?> getRevenue() {
        List<Map<String, Object>> revenueList = new ArrayList<>();
        revenueList.add(Map.of("month", "Tháng 1", "amount", 75000000, "customers", 120, "growth", "+12%"));
        revenueList.add(Map.of("month", "Tháng 2", "amount", 82500000, "customers", 135, "growth", "+10%"));
        revenueList.add(Map.of("month", "Tháng 3", "amount", 90000000, "customers", 150, "growth", "+9%"));
        revenueList.add(Map.of("month", "Tháng 4", "amount", 99000000, "customers", 165, "growth", "+10%"));
        return ResponseEntity.ok(revenueList);
    }

    // Get Artists
    @GetMapping("/artists")
    public ResponseEntity<?> getArtists() {
        List<Map<String, String>> artists = List.of(
            Map.of("id", "001", "name", "Trần Thị B", "specialty", "Trang điểm cô dâu", "experience", "5 năm", "schedule", "Thứ 2 - Thứ 6"),
            Map.of("id", "002", "name", "Lê Văn C", "specialty", "Trang điểm nghệ thuật", "experience", "3 năm", "schedule", "Thứ 3 - Thứ 7"),
            Map.of("id", "003", "name", "Phạm Thị D", "specialty", "Trang điểm chuyên nghiệp", "experience", "7 năm", "schedule", "Thứ 2 - Chủ nhật")
        );
        return ResponseEntity.ok(artists);
    }

    // Get Services
    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        List<Map<String, String>> services = List.of(
            Map.of("id", "SV001", "name", "Trang điểm cô dâu", "desc", "Trang điểm đầy đủ cho cô dâu", "price", "2,500,000 đ", "duration", "2 giờ"),
            Map.of("id", "SV002", "name", "Trang điểm dự tiệc", "desc", "Trang điểm nhẹ nhàng cho dự tiệc", "price", "1,200,000 đ", "duration", "1 giờ"),
            Map.of("id", "SV003", "name", "Trang điểm chụp ảnh", "desc", "Trang điểm chuyên nghiệp cho chụp ảnh", "price", "1,800,000 đ", "duration", "1.5 giờ"),
            Map.of("id", "SV004", "name", "Trang điểm cá nhân", "desc", "Trang điểm hàng ngày", "price", "800,000 đ", "duration", "45 phút")
        );
        return ResponseEntity.ok(services);
    }

    // Get Feedbacks
    @GetMapping("/feedback")
    public ResponseEntity<?> getFeedback() {
        List<Map<String, String>> feedbacks = List.of(
            Map.of("customer", "Nguyễn Thị E", "date", "15/04/2023", "rating", "★★★★☆", "comment", "Dịch vụ rất tốt, nhân viên nhiệt tình..."),
            Map.of("customer", "Trần Văn F", "date", "10/04/2023", "rating", "★★★☆☆", "comment", "Chất lượng trang điểm tốt nhưng thời gian chờ..."),
            Map.of("customer", "Lê Thị G", "date", "05/04/2023", "rating", "★★★★★", "comment", "Tuyệt vời! Tôi rất hài lòng...")
        );
        return ResponseEntity.ok(feedbacks);
    }
}
