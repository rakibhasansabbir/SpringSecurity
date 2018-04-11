package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.services.TaskService;
import com.example.SpringSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){

        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks",taskService.findByUser(user));
        model.addAttribute("name",user.getName());
        return "views/profile";
    }
}
