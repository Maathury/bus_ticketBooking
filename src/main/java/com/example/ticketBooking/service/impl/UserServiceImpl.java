package com.example.ticketBooking.service.impl;


import com.example.ticketBooking.dto.RegisterDto;
import com.example.ticketBooking.entity.Role;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.repository.RoleRepository;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.security.JwtUtil;
import com.example.ticketBooking.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor(force = true)

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;
    private String email;

    public UserServiceImpl(@Lazy JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }



    @Override
    public User save(RegisterDto userRegisteredDTO) {
        Role role = new Role();
        if(userRegisteredDTO.getRole().equals("USER")) {
            role = roleRepository.findByRole("USER");
        }
        else if(userRegisteredDTO.getRole().equals("ADMIN")) {
            role = roleRepository.findByRole("ADMIN");
        }
        User user = new User();
        user.setEmail(userRegisteredDTO.getEmail_id());
        user.setName(userRegisteredDTO.getName());
        user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
        user.setRole(role);


        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepository.findByEmail(email).get();
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

}
