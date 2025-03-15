package org.example.ticketservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketRequest {
    @NotNull(message = "user id is required")
    private Long userId;

    @NotNull(message = "flight id is required")
    private Long flightId;

    @NotNull(message = "flight schedule id is required")
    private Long flightScheduleId;

}
