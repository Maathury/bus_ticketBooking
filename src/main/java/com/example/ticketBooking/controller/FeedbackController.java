package com.example.ticketBooking.controller;


import com.example.ticketBooking.entity.Feedback;
import com.example.ticketBooking.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FeedbackController {

    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String feedbackForm(Model model){
        model.addAttribute("feedback",new Feedback());
        return "Feedback";
    }

    @PostMapping("/saveFeedback")
    public  String toSaveFeedback(@ModelAttribute("feedback")Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return "userHome";
    }

    @GetMapping("/viewFeedback")
    public String allFeedbacks(Model model){
        List<Feedback> feedbacks=feedbackService.getAllFeedbacks();
        model.addAttribute("feedbacks",feedbacks);
        return "viewFeedback";
    }

}
