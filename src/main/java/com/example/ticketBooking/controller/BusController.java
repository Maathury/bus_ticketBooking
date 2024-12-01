package com.example.ticketBooking.controller;

import com.example.ticketBooking.entity.Bus;
import com.example.ticketBooking.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor

public class BusController {

    private BusService busService;

    @GetMapping("/buses")
    public String getAllBuses(Model model){
        model.addAttribute("listOfBuses", busService.getAllBuses());
        return "allBuses";
    }

    @GetMapping("/addBus")
    public String addPage(Model model){
        Bus bus = new Bus();
        model.addAttribute("bus", bus);
        return "addBus";
    }

    @PostMapping("/saveBus")
    public String save(@ModelAttribute("bus") Bus bus){
        busService.saveBus(bus);
        return "redirect:/buses";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Bus bus = busService.getById(id);
        model.addAttribute("bus", bus);
        return "updateBus";
    }

    @PostMapping("/updateBus")
    public String update(@ModelAttribute("bus") Bus bus){
        busService.saveBus(bus);  // This will save the updated bus entity
        return "redirect:/buses";  // Redirect back to the bus list after successful update
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        busService.deleteById(id);
        return "redirect:/buses";
    }
}
