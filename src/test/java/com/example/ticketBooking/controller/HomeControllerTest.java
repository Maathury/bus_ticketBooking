package com.example.ticketBooking.controller;

import com.example.ticketBooking.dto.FindDto;
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


import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private BusService busService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFind() {
        String viewName = homeController.find(model);

        assertEquals("searchBuses", viewName);
        verify(model).addAttribute(eq("findDto"), any(FindDto.class));
    }

    @Test
    public void testFindBus() {
        FindDto findDto = new FindDto();
        findDto.setSource("Source");
        findDto.setDestination("Destination");
        findDto.setDate("2024-11-21");

        when(busService.find(anyString(), anyString(), anyString())).thenReturn(List.of(new Bus()));

        String viewName = homeController.findBus(findDto, model);

        assertEquals("searchBuses", viewName);
        verify(model).addAttribute(eq("findBuses"), anyList());
    }
}
