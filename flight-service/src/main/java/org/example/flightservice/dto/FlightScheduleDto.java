package org.example.flightservice.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightScheduleDto {
    private Long id;

    @NotBlank(message = "Flight id is required")
    private Long flightId;

    @NotNull(message = "Departure time is required")
    @FutureOrPresent(message = "Departure time cannot be past time")
    private LocalDateTime departureTime;


    @NotNull(message = "Arrival time is required")
    @FutureOrPresent(message = "Arrival time cannot be past time")
    private LocalDateTime arrivalTime;

    private String status;

    private Integer availableSeats;
    private String flightNumber;
    private String destination;
    private Double price;
    private String origin;
}
