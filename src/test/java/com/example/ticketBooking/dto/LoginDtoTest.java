package com.example.ticketBooking.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginDtoTest {

    private LoginDto loginDto;

    @BeforeEach
    public void setUp() {
        loginDto  = new LoginDto();
        loginDto.setUsername("johndoe");
        loginDto.setPassword("password123");
    }

    @Test
    public void testUserLoginDTOFields() {
        assertEquals("johndoe", loginDto.getUsername());
        assertEquals("password123", loginDto.getPassword());
    }

    @Test
    public void testUserLoginDTONoArgsConstructor() {
        LoginDto userLogin = new LoginDto();
        assertNull(userLogin.getUsername());
        assertNull(userLogin.getPassword());
    }
}
