package org.example.ticketservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;

    private Long userId;

    private String passengerName;

    private Long flightId;

    private Long flightScheduleId;

    private String flightNumber;

    private String origin;

    private String destination;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private String seatNumber;

    private Double price;

    private String status;

    private LocalDateTime bookingTime;
}

