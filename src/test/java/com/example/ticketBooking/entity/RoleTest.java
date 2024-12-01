package com.example.ticketBooking.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
        role.setRole("USER");
    }

    @Test
    public void testRoleField() {
        assertEquals("USER", role.getRole());
    }
}
