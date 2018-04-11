package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entities.Task;
import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.services.TaskService;
import com.example.SpringSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session){
        session.setAttribute("email",email);
        model.addAttribute("task", new Task());
        return "views/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult,HttpSession session) {
        if (bindingResult.hasErrors())
            return "views/taskForm";
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        taskService.addTask(task,userService.findOne(user.getUsername()));
        return "redirect:/users";
    }
}
