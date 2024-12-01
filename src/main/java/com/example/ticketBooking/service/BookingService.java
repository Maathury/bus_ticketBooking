package com.example.ticketBooking.service;

import com.example.ticketBooking.entity.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);

    List<Booking> getAllById(Long id);

    Booking getById(Long id);
}
