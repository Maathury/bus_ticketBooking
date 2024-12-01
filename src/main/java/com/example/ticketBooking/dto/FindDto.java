package com.example.ticketBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FindDto {

    private String source;

    private String destination;

    private String date;

}
