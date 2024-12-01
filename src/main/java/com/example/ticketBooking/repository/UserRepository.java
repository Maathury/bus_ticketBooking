package com.example.ticketBooking.repository;

import com.example.ticketBooking.entity.Booking;
import com.example.ticketBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId")
    List<Booking> findBookingsByUserId(@Param("userId") Long userId);

    Optional<User> findByEmail(String username);
}
