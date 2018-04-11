package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entities.StakeholderInfo;
import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exist", true);

            return "views/registerForm";
        }
        userService.createAdmin(user);
        return "views/success";

    }


    @GetMapping("/addReportAdmin")
    public String rReportUSERForm(Model model) {
        model.addAttribute("user", new User());
        return "views/report_admin_form";
    }

    @PostMapping("/addReportAdmin")
    public String registerReportUser(@Valid User user, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "views/report_admin_form";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exist", true);

            return "views/report_admin_form";
        }
        User user1 = userService.findOne(principal.getName());
        userService.createReportAdmin(user,user1.getUsername());
        return "views/success";

    }

    @GetMapping("/addStakeholderApi")
    public String StakeholderAPIForm(Model model) {
        model.addAttribute("user", new User());
        return "views/stakeholder_api_form";
    }

    @PostMapping("/addStakeholderApi")
    public String registerStakeholderAPI(@Valid User user, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "views/stakeholder_api_form";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exist", true);

            return "views/stakeholder_api_form";
        }
        User user1 = userService.findOne(principal.getName());
        userService.createStakeholderApitUser(user,user1.getUsername());
        return "views/success";

    }

    @GetMapping("/addStakeholderReport")
    public String StakeholderReportForm(Model model) {
        model.addAttribute("user", new User());
        return "views/stakeholder_report_form";
    }

    @PostMapping("/addStakeholderReport")
    public String registerStakeholderReport(@Valid User user, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "views/stakeholder_report_form";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exist", true);

            return "views/stakeholder_report_form";
        }
        User user1 = userService.findOne(principal.getName());
        userService.createStakeholderReportUser(user,user1.getUsername());
        return "views/success";

    }

    @GetMapping("/rStakeholder")
    public String StakeholderRegistrationForm(Model model) {
        model.addAttribute("stakeholders", new StakeholderInfo());
        return "views/stakeholder_registration_form";
    }

    @PostMapping("/rStakeholder")
    public String registerStakeholder(@Valid StakeholderInfo stakeholderInfo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/stakeholder_registration_form";
        }
        if (userService.isUserPresent(stakeholderInfo.getName())) {
            model.addAttribute("exist", true);

            return "views/stakeholder_registration_form";
        }

        userService.createStakeholder(stakeholderInfo);
        return "views/success";

    }
}