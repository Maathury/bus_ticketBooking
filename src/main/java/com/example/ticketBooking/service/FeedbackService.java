package com.example.ticketBooking.service;

import com.example.ticketBooking.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> getAllFeedbacks();
    void saveFeedback(Feedback feedback);
}
