package com.example.ticketBooking.service;

import com.example.ticketBooking.entity.Booking;
import com.example.ticketBooking.repository.BookingRepository;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void testSaveBooking() {
        Booking booking = new Booking();
        bookingService.save(booking);


        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void testGetAllById() {
        List<Booking> bookings = Arrays.asList(new Booking(), new Booking());

        when(userRepository.findBookingsByUserId(1L)).thenReturn(bookings);

        List<Booking> result = bookingService.getAllById(1L);

        assertEquals(2, result.size());
    }

    @Test
    void testGetById() {
        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking result = bookingService.getById(1L);

        assertNotNull(result);
    }

}
