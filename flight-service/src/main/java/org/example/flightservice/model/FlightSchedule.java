package org.example.flightservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_schedules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private String status;
}
