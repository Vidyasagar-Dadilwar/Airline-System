package org.example.ticketservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketRequest {
    @NotNull(message = "Enter user id")
    private Long userId;

    @NotNull(message = "Enter flight id")
    private Long flightId;

    @NotNull(message = "Enter flight schedule id")
    private Long flightScheduleId;
}

