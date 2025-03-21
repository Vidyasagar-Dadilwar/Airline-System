package org.example.ticketservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightScheduleDto {
    private Long id;

    private Long flightId;

    private String status;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private String origin;

    private String destination;

    private String flightNumber;

    private Integer availableSeats;

    private Double price;
}
