package com.example.ticketBooking.controller;

import com.example.ticketBooking.entity.Feedback;
import com.example.ticketBooking.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.List;


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class FeedbackControllerTest {

    @InjectMocks
    private FeedbackController feedbackController;

    @Mock
    private FeedbackService feedbackService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFeedbackForm() {
        String viewName = feedbackController.feedbackForm(model);

        assertEquals("FeedbackForm", viewName);
        verify(model).addAttribute(eq("feedback"), any(Feedback.class));
    }

    @Test
    public void testAllFeedbacks() {
        when(feedbackService.getAllFeedbacks()).thenReturn(List.of(new Feedback()));

        String viewName = feedbackController.allFeedbacks(model);

        assertEquals("viewFeedbacks", viewName);
        verify(model).addAttribute(eq("feedbacks"), anyList());
    }
}
