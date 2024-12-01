package com.example.ticketBooking.service.impl;

import com.example.ticketBooking.entity.Booking;
import com.example.ticketBooking.repository.BookingRepository;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;


    @Override
    public void save(Booking booking) {

        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllById(Long id) {

        return userRepository.findBookingsByUserId(id);
    }

    @Override
    public Booking getById(Long id) {

        return bookingRepository.findById(id).get();
    }
}
