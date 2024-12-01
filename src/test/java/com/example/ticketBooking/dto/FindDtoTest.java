package com.example.ticketBooking.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FindDtoTest {

    private FindDto findDto;

    @BeforeEach
    public void setUp() {
        findDto = new FindDto("CityA", "CityB", "2023-12-01");
    }

    @Test
    public void testFindDtoFields() {
        assertEquals("CityA", findDto.getSource());
        assertEquals("CityB", findDto.getDestination());
        assertEquals("2023-12-01", findDto.getDate());
    }

    @Test
    public void testFindDtoNoArgsConstructor() {
        FindDto emptyFindDto = new FindDto();
        assertNull(emptyFindDto.getSource());
        assertNull(emptyFindDto.getDestination());
        assertNull(emptyFindDto.getDate());
    }
}
