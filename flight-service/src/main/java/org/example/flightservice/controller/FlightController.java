package org.example.flightservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.flightservice.dto.FlightDto;
import org.example.flightservice.dto.FlightScheduleDto;
import org.example.flightservice.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class FlightController {
    private final FlightService flightService;

    // route to get the flight based on the id GET("/flights/123")
    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    // route to get the schedule of particular flight GET("/flights/123/schedules")
    @GetMapping("/{id}/schedules")
    public ResponseEntity<List<FlightScheduleDto>> getFlightSchedules(@PathVariable Long id, @RequestParam(name = "dates", required = false) String dates) {
        List<FlightScheduleDto> flights = flightService.getFlightSchedules(id, dates);
        return ResponseEntity.ok(flights);
    }

    // gives all the flights GET("/flights/")
    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights(@RequestParam(name = "sort", defaultValue = "asc") String sortDirection) {
        List<FlightDto> flights = flightService.getAllFlights(sortDirection);
        return ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@Valid @RequestBody FlightDto request) {
        FlightDto flight = flightService.createFlight(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(flight);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<FlightScheduleDto> getFlightSchedule(@PathVariable Long id) {
        FlightScheduleDto flightSchedule = flightService.getFlightSchedule(id);
        return ResponseEntity.ok(flightSchedule);
    }
}
