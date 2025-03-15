package org.example.flightservice.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.flightservice.dto.FlightDto;
import org.example.flightservice.dto.FlightScheduleDto;
import org.example.flightservice.model.Flight;
import org.example.flightservice.model.FlightSchedule;
import org.example.flightservice.repository.FlightRepository;
import org.example.flightservice.repository.FlightScheduleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightScheduleRepository flightScheduleRepository;

    private FlightDto toFlightDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .flightNumber(flight.getFlightNumber())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .capacity(flight.getCapacity())
                .availableSeats(flight.getAvailableSeats())
                .price(flight.getPrice())
                .build();
    }

    private Flight toFlight(FlightDto flightDto) {
        return Flight.builder()
                .id(flightDto.getId())
                .flightNumber(flightDto.getFlightNumber())
                .origin(flightDto.getOrigin())
                .destination(flightDto.getDestination())
                .capacity(flightDto.getCapacity())
                .availableSeats(flightDto.getAvailableSeats())
                .price(flightDto.getPrice())
                .build();
    }

    private FlightScheduleDto toFlightScheduleDto(FlightSchedule schedule) {
        return FlightScheduleDto.builder()
                .id(schedule.getId())
                .flightId(schedule.getFlight().getId())
                .flightNumber(schedule.getFlight().getFlightNumber())
                .origin(schedule.getFlight().getOrigin())
                .destination(schedule.getFlight().getDestination())
                .availableSeats(schedule.getFlight().getAvailableSeats())
                .price(schedule.getFlight().getPrice())
                .departureTime(schedule.getDepartureTime())
                .arrivalTime(schedule.getArrivalTime())
                .status(schedule.getStatus())
                .build();
    }

    private List<FlightDto> toFlightDtos(List<Flight> flights) {
        return flights.stream().map(this::toFlightDto).collect(Collectors.toList());
    }

    private List<FlightScheduleDto> toFlightScheduleDtos(List<FlightSchedule> schedules) {
        return schedules.stream().map(this::toFlightScheduleDto).collect(Collectors.toList());
    }

    public List<FlightDto> getAllFlights(String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("asc") ?
                Sort.by("flightNumber").ascending() :
                Sort.by("flightNumber").descending();

        List<Flight> flights = flightRepository.findAll(sort);
        return toFlightDtos(flights);
    }

    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No flight with this id"));

        return toFlightDto(flight);
    }

    public List<FlightScheduleDto> getFlightSchedules(Long flightId, String dates) {
        flightRepository.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("No flight with this id"));

        List<FlightSchedule> schedules;

        if (dates != null) {
            String[] dateRange = dates.split(",");
            LocalDateTime startDate = LocalDateTime.parse(dateRange[0], DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime endDate = dateRange.length > 1 ?
                    LocalDateTime.parse(dateRange[1], DateTimeFormatter.ISO_DATE_TIME) :
                    startDate.plusDays(7);

            schedules = flightScheduleRepository.findAllByFlightIdAndDateRange(flightId, startDate, endDate);
        }
        else {
            schedules = flightScheduleRepository.findByFlightId(flightId);
        }

        return toFlightScheduleDtos(schedules);
    }

    public FlightScheduleDto getFlightSchedule(Long scheduleId) {
        FlightSchedule schedule = flightScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("No schedule with this id"));

        return toFlightScheduleDto(schedule);
    }

    @Transactional
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = toFlight(flightDto);
        return toFlightDto(flightRepository.save(flight));
    }
}
