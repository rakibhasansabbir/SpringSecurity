package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private String listUser(Model model){
        model.addAttribute("users",userService.findAll());
        return "views/list";
    }
}
