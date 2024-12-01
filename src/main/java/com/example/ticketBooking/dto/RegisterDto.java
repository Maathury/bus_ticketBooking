package com.example.ticketBooking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterDto {

    private String name;

    private String email_id;

    private String password;

    private String role;

    public void RegisterDTO() {

    }

    public RegisterDto(String testuser, String mail, String password) {
    }
}


