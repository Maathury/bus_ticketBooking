package com.example.ticketBooking.controller;


import com.example.ticketBooking.entity.Bus;
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

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BusControllerTest {

    @InjectMocks
    private BusController busController;

    @Mock
    private BusService busService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBuses() {
        String viewName = busController.getAllBuses(model);

        assertEquals("AllBuses", viewName);
        verify(busService).getAllBuses();
    }

    @Test
    public void testAddPage() {
        String viewName = busController.addPage(model);

        assertEquals("AddBus", viewName);
        verify(model).addAttribute(eq("bus"), any(Bus.class));
    }
}
