package org.example.ticketservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Integer capacity;
    private Long id;
    private String destination;
    private String origin;
    private Integer availableSeats;
    private Double price;
    private String flightNumber;
}
