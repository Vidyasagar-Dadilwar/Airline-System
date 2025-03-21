package org.example.ticketservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.id.uuid.UuidGenerator;

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

    private Long userId;

    private Long flightId;

    private Long flightScheduleId;

    private String passengerName;

    private String seatNumber;

    private Double price;

    private String status;

    private LocalDateTime bookingTime;
}

