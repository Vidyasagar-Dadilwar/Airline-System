package org.example.flightservice.repository;

import org.example.flightservice.model.FlightSchedule;
import org.springframework.data.jpa.repository.*;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
    List<FlightSchedule> findByFlightId(Long id);

    @Query("select f from FlightSchedule f where f.flight.id = ?1 and f.departureTime >= ?2 and f.arrivalTime <= ?3")
    List<FlightSchedule> findAllByFlightIdAndDateRange(Long id, LocalDateTime departureTime, LocalDateTime arrivalTime);
}