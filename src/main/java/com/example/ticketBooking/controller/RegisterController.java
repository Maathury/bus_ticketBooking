package com.example.ticketBooking.controller;

import com.example.ticketBooking.dto.RegisterDto;
import com.example.ticketBooking.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@Tag(name = "Registration Controller", description = "Controller for managing user registration")

public class RegisterController {

    public UserService userService;

    public RegisterController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public RegisterDto registerDto() {
        return new RegisterDto();
    }

    @GetMapping
    @Operation(summary = "Show Registration Form", description = "Displays the registration form")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    @Operation(summary = "Register User Account", description = "Registers a new user account and redirects to the login page")
    public String registerUserAccount(@ModelAttribute("user")
                                      RegisterDto registerDto) {
        userService.save(registerDto);
        return "redirect:/login";
    }
}
