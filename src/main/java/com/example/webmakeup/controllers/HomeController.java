package com.example.webmakeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Đổi từ @RestController sang @Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // Chuyển hướng đến templates/index.html
    }
}
