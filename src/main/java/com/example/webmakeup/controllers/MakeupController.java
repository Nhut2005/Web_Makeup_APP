package com.example.webmakeup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MakeupController {

    // Dữ liệu giả lập cho người dùng
    private final Map<String, Object> currentUser = new HashMap<>() {{
        put("name", "Phạm Thị D");
        put("bio", "Chuyên gia trang điểm chuyên nghiệp");
        put("email", "D.makeup@example.com");
        put("phone", "0987654321");
        put("address", "Hồ Chí Minh, Việt Nam");
        put("experience", "7 năm");
    }};

    // Dữ liệu lịch hẹn
    private final List<Map<String, Object>> bookings = new ArrayList<>(List.of(
        Map.of(
            "id", 1,
            "client", "Nguyễn Thị E",
            "date", "10/05/2025",
            "time", "09:00 - 11:00",
            "service", "Trang điểm cô dâu",
            "status", "confirmed"
        ),
        Map.of(
            "id", 2,
            "client", "Trần Văn F",
            "date", "10/05/2025",
            "time", "14:00 - 15:30",
            "service", "Trang điểm dự tiệc",
            "status", "pending"
        ),
        Map.of(
            "id", 3,
            "client", "Lê Thị G",
            "date", "12/05/2025",
            "time", "10:00 - 11:30",
            "service", "Trang điểm chụp ảnh",
            "status", "confirmed"
        )
    ));

    // Dữ liệu thông báo
    private final List<Map<String, Object>> notifications = new ArrayList<>(List.of(
        Map.of("id", 1, "message", "Lịch hẹn với Nguyễn Thị E đã được xác nhận.", "time", "10 phút trước", "read", false),
        Map.of("id", 2, "message", "Lịch hẹn với Lê Thị G đã được xác nhận.", "time", "2 giờ trước", "read", false),
        Map.of("id", 3, "message", "Nhắc nhở: Lịch hẹn với Trần Văn F đang chờ xác nhận.", "time", "1 ngày trước", "read", true)
    ));

    // API: Đăng nhập (giả lập)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (!username.isBlank() && !password.isBlank()) {
            return ResponseEntity.ok("Đăng nhập thành công");
        }
        return ResponseEntity.badRequest().body("Tên đăng nhập hoặc mật khẩu không đúng");
    }

    // API: Lấy thông tin hồ sơ
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getProfile() {
        return ResponseEntity.ok(currentUser);
    }

    // API: Cập nhật hồ sơ
    @PostMapping("/profile")
    public ResponseEntity<Map<String, Object>> updateProfile(@RequestBody Map<String, Object> profileUpdate) {
        currentUser.putAll(profileUpdate);
        return ResponseEntity.ok(currentUser);
    }

    // API: Lấy danh sách lịch hẹn
    @GetMapping("/bookings")
    public ResponseEntity<List<Map<String, Object>>> getBookings() {
        return ResponseEntity.ok(bookings);
    }

    // API: Tạo mới lịch hẹn
    @PostMapping("/bookings")
    public ResponseEntity<Map<String, Object>> createBooking(@RequestBody Map<String, Object> booking) {
        booking.put("id", bookings.size() + 1);
        bookings.add(booking);
        return ResponseEntity.ok(booking);
    }

    // API: Lấy danh sách thông báo
    @GetMapping("/notifications")
    public ResponseEntity<List<Map<String, Object>>> getNotifications() {
        return ResponseEntity.ok(notifications);
    }

    // API: Đánh dấu tất cả thông báo là đã đọc
    @PostMapping("/notifications/read-all")
    public ResponseEntity<String> markAllAsRead() {
        notifications.forEach(n -> n.put("read", true));
        return ResponseEntity.ok("Đã đánh dấu tất cả là đã đọc");
    }
}
