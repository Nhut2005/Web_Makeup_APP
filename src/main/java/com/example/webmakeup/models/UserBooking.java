package com.example.webmakeup.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_bookings")  // Đã xóa annotation @Table trùng lặp
public class UserBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ với User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Quan hệ với Chi nhánh (có thể null cho dịch vụ tại nhà)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    // Quan hệ với Nghệ sĩ trang điểm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private MakeupArtist artist;

    // Quan hệ với Dịch vụ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    // Thông tin đặt lịch
    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private LocalTime bookingTime;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Loại đặt lịch (nên dùng enum)
    @Column(nullable = false)
    private String bookingType; // "SPECIFIC_TIME" hoặc "FIFO"

    // Loại địa điểm (nên dùng enum)
    @Column(nullable = false)
    private String locationType; // "SALON" hoặc "HOME"

    // Thông tin địa chỉ nhà (chỉ cho dịch vụ tại nhà)
    @Column(length = 500)
    private String homeAddress;

    @Column(length = 100)
    private String homeLocationNotes;

    // Thông tin thanh toán
    @Column(nullable = false)
    private double totalPrice;

    @Column
    private String paymentMethod;

    @Column
    private String transactionId;

    // Quản lý trạng thái
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.PENDING;

    @Column(length = 500)
    private String cancellationReason;

    // Constructors
    public UserBooking() {
        // Giá trị mặc định đã được đặt trong khai báo trường
    }

    // Enum cho trạng thái
    public enum BookingStatus {
        PENDING,   // Đang chờ
        CONFIRMED, // Đã xác nhận
        COMPLETED, // Hoàn thành
        CANCELLED, // Đã hủy
        NO_SHOW    // Không đến
    }

    // Getter và setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ... (các getter và setter khác)

    // Các phương thức nghiệp vụ
    public boolean isAtHome() {
        return "HOME".equalsIgnoreCase(locationType);
    }

    public boolean isSpecificTimeBooking() {
        return "SPECIFIC_TIME".equalsIgnoreCase(bookingType);
    }

    public void cancel(String reason) {
        this.status = BookingStatus.CANCELLED;
        this.cancellationReason = reason;
        this.updatedAt = LocalDateTime.now();
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }

    // Cập nhật thời gian
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}