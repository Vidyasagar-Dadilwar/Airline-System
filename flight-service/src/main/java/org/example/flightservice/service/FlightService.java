package org.example.flightservice.service;

import org.example.flightservice.dto.FlightDto;
import org.example.flightservice.dto.FlightScheduleDto;
import org.example.flightservice.model.Flight;
import org.example.flightservice.repository.FlightRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<FlightDto> getAllFlights(String sortDirection) {
        return toDtos(flightRepository.findAll());
    }

    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight with this id does not exist"));
        return toDto(flight);
    }

    public List<FlightScheduleDto> getFlightSchedules(Long flightId, String dates) {
        // Implement logic to fetch flight schedules based on flightId and dates
        return List.of();
    }

    @Transactional
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = toFlight(flightDto);
        return toDto(flightRepository.save(flight));
    }

    public FlightScheduleDto getFlightSchedule(Long scheduleId) {
        // Implement logic to fetch a flight schedule by scheduleId
        return null;
    }

    private FlightDto toDto(Flight flight) {
        return new FlightDto(
                flight.getId(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getFlightNumber(),
                flight.getCapacity(),
                flight.getAvailableSeats(),
                flight.getPrice()
                );
    }

    private Flight toFlight(FlightDto flightDto) {
        return new Flight(
                flightDto.getId(),
                flightDto.getPrice(),
                flightDto.getCapacity(),
                flightDto.getOrigin(),
                flightDto.getDestination(),
                flightDto.getFlightNumber(),
                flightDto.getAvailableSeats()
        );
    }


    private List<FlightDto> toDtos(List<Flight> flights) {
        return flights.stream().map(this::toDto).toList();
    }
}
