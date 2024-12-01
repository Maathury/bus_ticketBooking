package com.example.ticketBooking.service;

import com.example.ticketBooking.dto.RegisterDto;
import com.example.ticketBooking.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(RegisterDto userRegisteredDTO);

}
