package com.example.webmakeup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index"; // Trang chủ kiêm luôn trang đăng nhập
    }

    @GetMapping("/products")
    public String productsPage() {
        return "products"; 
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; 
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client"; 
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";  
    }
}