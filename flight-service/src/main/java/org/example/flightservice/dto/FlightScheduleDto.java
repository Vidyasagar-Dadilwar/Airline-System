package org.example.flightservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightScheduleDto {
    private Long id;

    @NotBlank(message = "Enter flight id")
    private Long flightId;

    private String status;

    @NotNull(message = "Enter departure time")
    @FutureOrPresent(message = "Entire proper time")
    private LocalDateTime departureTime;

    @NotNull(message = "Enter arrival time")
    @FutureOrPresent(message = "Entire proper time")
    private LocalDateTime arrivalTime;

    private String origin;
    private String destination;
    private String flightNumber;
    private Integer availableSeats;
    private Double price;

}
