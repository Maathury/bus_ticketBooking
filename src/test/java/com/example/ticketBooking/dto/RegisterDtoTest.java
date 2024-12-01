package com.example.ticketBooking.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterDtoTest {

    private RegisterDto registerDto;

    @BeforeEach
    public void setUp() {
        registerDto = new RegisterDto();
        registerDto.setName("John Doe");
        registerDto.setEmail_id("john.doe@example.com");
        registerDto.setPassword("password123");
        registerDto.setRole("USER");
    }

    @Test
    public void testUserRegisteredDtoFields() {
        assertEquals("John Doe", registerDto.getName());
        assertEquals("john.doe@example.com", registerDto.getEmail_id());
        assertEquals("password123", registerDto.getPassword());
        assertEquals("USER", registerDto.getRole());
    }

    @Test
    public void testUserRegisteredDtoParameterizedConstructor() {
        RegisterDto user = new RegisterDto("john.doe@example.com", "John Doe", "password123", "USER");
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail_id());
        assertEquals("password123", user.getPassword());
        assertEquals("USER", user.getRole());
    }
}
