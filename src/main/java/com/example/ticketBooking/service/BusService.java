package com.example.ticketBooking.service;

import com.example.ticketBooking.entity.Bus;

import java.util.List;

public interface BusService {

    List<Bus> getAllBuses();

    void saveBus(Bus bus);

    Bus getById(Long id);

    void deleteById(Long id);

    List<Bus> find(String source,String destination,String date);
}
