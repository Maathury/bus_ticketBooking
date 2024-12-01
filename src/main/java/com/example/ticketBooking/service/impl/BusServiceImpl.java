package com.example.ticketBooking.service.impl;

import com.example.ticketBooking.entity.Bus;
import com.example.ticketBooking.repository.BusRepository;
import com.example.ticketBooking.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BusServiceImpl implements BusService {

    private BusRepository busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public void saveBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public Bus getById(Long id) {
        return busRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        busRepository.deleteById(id);

    }

    @Override
    public List<Bus> find(String source, String destination, String date) {
        return busRepository.findBySourceDestinationAndDate(source,destination,date);
    }
}
