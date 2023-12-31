package com.expensetracker.controller;

import com.expensetracker.dto.RegistrationDto;
import com.expensetracker.model.Users;
import com.expensetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("users", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("users")RegistrationDto users, BindingResult result, Model model) {
        Users existingUserEmail = userService.findByEmail(users.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            result.rejectValue("email", "There is already a user with this email/username.");
        }
        Users existingUserUsername = userService.findByUsername(users.getUsername());
        if (existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            result.rejectValue("username", "There is already a user with this email/username.");
        }
        if (result.hasErrors()) {
            model.addAttribute("users", users);
            return "register";
        }
        userService.saveUser(users);
        return "redirect:/persons?success";
    }
}
