package org.example.ticketservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightScheduleDto {
    private String destination;
    private Long id;;
    private String status;
    private Double price;
    private String flightNumber;
    private Integer availableSeats;
    private Long flightId;
    private String origin;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
}
