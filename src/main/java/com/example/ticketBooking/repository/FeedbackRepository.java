package com.example.ticketBooking.repository;

import com.example.ticketBooking.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
