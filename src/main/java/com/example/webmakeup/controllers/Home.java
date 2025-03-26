package com.example.webmakeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    
    @GetMapping("/")  // Trang chủ
    public String homePage() {
        return "index";  
    }

    @GetMapping("/products")  // Trang sản phẩm
    public String productsPage() {
        return "products"; 
    }

    @GetMapping("/about")  // Trang giới thiệu
    public String aboutPage() {
        return "about"; 
    }

    @GetMapping("/client")  // Trang khách hàng
    public String clientPage() {
        return "client"; 
    }

    @GetMapping("/contact")  // Trang liên hệ
    public String contactPage() {
        return "contact";  
    }
    @GetMapping("/login")  // Trang login
    public String loginPage() {
        return "login";  
    }
}
