package org.example.ticketservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Long id;

    private String origin;

    private String destination;

    private String flightNumber;

    private Integer capacity;

    private Integer availableSeats;

    private Double price;
}
