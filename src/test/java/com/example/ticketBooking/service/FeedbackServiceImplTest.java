package com.example.ticketBooking.service;

import com.example.ticketBooking.entity.Feedback;
import com.example.ticketBooking.repository.FeedbackRepository;
import com.example.ticketBooking.service.impl.FeedbackServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class FeedbackServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Test
    void testGetAllFeedbacks() {
        Feedback feedback1 = new Feedback(1L, "Good service!");
        Feedback feedback2 = new Feedback(2L, "Could be improved.");
        List<Feedback> feedbackList = Arrays.asList(feedback1, feedback2);

        when(feedbackRepository.findAll()).thenReturn(feedbackList);

        List<Feedback> result = feedbackService.getAllFeedbacks();
        assertEquals(2, result.size());
    }

    @Test
    void testSaveFeedback() {
        Feedback feedback = new Feedback(1L, "Great experience!");

        feedbackService.saveFeedback(feedback);

        verify(feedbackRepository, times(1)).save(feedback);
    }
}
