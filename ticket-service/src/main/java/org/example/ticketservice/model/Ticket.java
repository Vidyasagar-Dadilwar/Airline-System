package org.example.ticketservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private Double price;
    private Long userId;
    private Long flightScheduleId;
    private Long flightId;
    private String status;
    private LocalDateTime bookingTime;
    private String seatNumber;
}
