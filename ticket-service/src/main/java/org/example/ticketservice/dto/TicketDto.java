package org.example.ticketservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long flightScheduleId;
    private Long userId;
    private LocalDateTime bookingTime;
    private String passengerName;
    private Long flightId;
    private String destination;
    private Long id;
    private String origin;
    private Double price;
    private LocalDateTime departureTime;
    private String flightNumber;
    private String seatNumber;
    private String status;
    private LocalDateTime arrivalTime;
}