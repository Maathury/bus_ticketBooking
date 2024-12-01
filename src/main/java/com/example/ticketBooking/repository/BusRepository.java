package com.example.ticketBooking.repository;

import com.example.ticketBooking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BusRepository extends JpaRepository<Bus,Long> {

    boolean existsById(Long id);
    List<Bus> findBySourceDestinationAndDate(String source, String destination, String date);
}
