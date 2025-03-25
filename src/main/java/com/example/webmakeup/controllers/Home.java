package com.example.webmakeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    
    @GetMapping("/")  // Trang chủ
    public String homePage() {
        return "index";  // Trả về file index.html
    }

    @GetMapping("/products")  // Trang sản phẩm
    public String productsPage() {
        return "products";  // Trả về file products.html
    }

    @GetMapping("/about")  // Trang giới thiệu
    public String aboutPage() {
        return "about";  // Trả về file about.html
    }

    @GetMapping("/client")  // Trang khách hàng
    public String clientPage() {
        return "client";  // Trả về file client.html
    }

    @GetMapping("/contact")  // Trang liên hệ
    public String contactPage() {
        return "contact";  // Trả về file contact.html
    }
}
