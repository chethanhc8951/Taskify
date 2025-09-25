package com.Taskify.Taskify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Taskify.Taskify.model.User;
import com.Taskify.Taskify.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    /// profile
    @GetMapping("/profile")
    public String profile(Model model) {
        // Fetch user details and add to model
        // model.addAttribute("user", userService.getCurrentUser());
        return "profile";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/adduser")
    public String register(Model model, @ModelAttribute User user) {
        model.addAttribute("user", user);
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/verifyuser")
    public String verifyUser(Model model, @ModelAttribute User user) {
        // Logic to verify user credentials

        if (userService.verifyUser(user)) {
            return "redirect:/profile";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

}
