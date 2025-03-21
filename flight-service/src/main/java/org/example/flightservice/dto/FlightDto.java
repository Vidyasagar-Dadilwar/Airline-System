package org.example.flightservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FlightDto {
    private Long id;

    @NotBlank(message = "Enter Origin")
    private String origin;
    @NotBlank(message = "Enter Destination")
    private String destination;

    @NotBlank(message = "Enter flight number")
    private String flightNumber;

    @NotNull(message = "Enter capacity")
    @Positive(message = "Capacity must be positive")
    private Integer capacity;

    @NotNull(message = "Enter available seats")
    @Positive(message = "Available seats must be positive")
    private Integer availableSeats;

    @NotNull(message = "Enter price")
    @Positive(message = "price must be positive")
    private Double price;
}

