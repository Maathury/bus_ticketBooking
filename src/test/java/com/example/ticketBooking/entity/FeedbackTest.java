package com.example.ticketBooking.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackTest {

    private Feedback feedback;

    @BeforeEach
    public void setUp() {
        feedback = new Feedback();
        feedback.setEmail("user@example.com");
        feedback.setBusName("Express");
        feedback.setComments("Great service!");
    }

    @Test
    public void testFeedbackFields() {
        assertEquals("user@example.com", feedback.getEmail());
        assertEquals("Express", feedback.getBusName());
        assertEquals("Great service!", feedback.getComments());
    }
}
