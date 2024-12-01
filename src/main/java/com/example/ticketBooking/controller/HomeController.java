package com.example.ticketBooking.controller;

import com.example.ticketBooking.dto.FindDto;
import com.example.ticketBooking.entity.Bus;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.BusService;
import com.example.ticketBooking.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
@Tag(name = "Home Controller", description = "Controller for managing dashboard operations")

public class HomeController {

    private BusService busService;
    private UserService userService;
    private UserRepository userRepository;

    @GetMapping("/home/admin")
    @Secured("ROLE_ADMIN")
    public String adminHome(Model model) {
        model.addAttribute("userDetail", returnUser());
        return "adminHome"; // Returns the admin home view
    }

    @GetMapping("/home/user")
    @Secured("ROLE_USER")
    public String userHome(Model model) {
        model.addAttribute("userDetail", returnUser());
        return "userHome"; // Returns the user home view
    }

    @GetMapping("/searchBus")
    public String find(Model model){
        model.addAttribute("findDto",new FindDto());
        return "searchBus";
    }

    @PostMapping("/find")
    public String findBus(@ModelAttribute("findDto")FindDto findDto, Model model){
        List<Bus> option=busService.find(findDto.getSource(),findDto.getDestination(),findDto.getDate());
        model.addAttribute("findBuses",option);
        return "searchBus";
    }



    private Object returnUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        User users = userRepository.findByEmail(user.getUsername()).get();
        return users;
    }




}
