package com.example.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    private String showIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    private String showLoginPage() {
        return "views/loginForm";
    }
}
