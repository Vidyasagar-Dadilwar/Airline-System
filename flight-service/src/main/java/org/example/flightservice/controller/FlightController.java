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

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights(@RequestParam(name = "sort", defaultValue = "asc") String sortDirection) {
        List<FlightDto> flights = flightService.getAllFlights(sortDirection);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @GetMapping("/{id}/schedules")
    public ResponseEntity<List<FlightScheduleDto>> getFlightSchedules(@PathVariable Long id, @RequestParam(name = "dates", required = false) String dates) {
        return ResponseEntity.ok(flightService.getFlightSchedules(id, dates));
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<FlightScheduleDto> getFlightSchedule(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightSchedule(id));
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@Valid @RequestBody FlightDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.createFlight(request));
    }
}

