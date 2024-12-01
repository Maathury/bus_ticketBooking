package com.example.ticketBooking.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

    private Booking booking;
    private Bus bus;
    private User user;

    @BeforeEach
    public void setUp() {
        bus = new Bus();
        bus.setBusName("Test Bus");

        user = new User();
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        booking = new Booking();
        booking.setBusName("Test Bus");
        booking.setDate("2023-12-01");
        booking.setNoOfPersons(2);
        booking.setTotalCalculated(100.0);
        booking.setTripStatus("CONFIRMED");
        booking.setBus(bus);
        booking.setUser(user);
    }

    @Test
    public void testBookingFields() {
        assertEquals("Test Bus", booking.getBusName());
        assertEquals("2023-12-01", booking.getDate());
        assertEquals(2, booking.getNoOfPersons());
        assertEquals(100.0, booking.getTotalCalculated());
        assertEquals("CONFIRMED", booking.getTripStatus());
    }

    @Test
    public void testBookingRelationships() {
        assertEquals(bus, booking.getBus());
        assertEquals(user, booking.getUser());
    }
}
