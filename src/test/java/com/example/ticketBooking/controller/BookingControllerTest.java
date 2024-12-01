package com.example.ticketBooking.controller;

import com.example.ticketBooking.entity.Booking;
import com.example.ticketBooking.entity.Bus;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.repository.BusRepository;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.BookingService;
import com.example.ticketBooking.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    @Mock
    private BusRepository busRepository;

    @Mock
    private BusService busService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBooking() {
        Long busId = 1L;
        Bus bus = new Bus();
        bus.setBusName("Test Bus");

        when(busService.getById(busId)).thenReturn(bus);

        String viewName = bookingController.booking(busId, model);

        assertEquals("Booking", viewName);
        verify(model).addAttribute(eq("booking").toString(), any(Booking.class));
    }

    @Test
    public void testBooked() {
        Booking booking = new Booking();
        Bus bus = new Bus();
        bus.setPrice(100.0);
        booking.setBus(bus);
        booking.setNoOfPersons(2);

        when(busRepository.findById(anyLong())).thenReturn(Optional.of(bus));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));

        String viewName = bookingController.booked(booking, model);

        assertEquals("pay", viewName);
        verify(bookingService).save(booking);
    }

}
