package org.example.ticketservice.service;

import org.example.ticketservice.dto.*;
import org.example.ticketservice.model.Ticket;
import org.example.ticketservice.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final RestTemplate restTemplate;

    private static final String FLIGHT_SERVICE_URL = "http://localhost:8081/flights";
    private static final String USER_SERVICE_URL = "http://localhost:8080/users";

    @Transactional(readOnly = true)
    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket with this id does not exist"));

        UserDto user = fetchUser(ticket.getUserId());
        FlightDto flight = fetchFlight(ticket.getFlightId());
        FlightScheduleDto schedule = fetchSchedule(ticket.getFlightScheduleId());

        return toDto(ticket, user, flight, schedule);
    }

    @Transactional
    public TicketDto createTicket(CreateTicketRequest request) {
        UserDto user = fetchUser(request.getUserId());
        FlightDto flight = fetchFlight(request.getFlightId());
        FlightScheduleDto schedule = fetchSchedule(request.getFlightScheduleId());

        String seatNumber = "S" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        Ticket ticket = Ticket.builder()
                .passengerName(user.getFirstName() + " " + user.getLastName())
                .seatNumber(seatNumber)
                .price(flight.getPrice())
                .flightId(request.getFlightId())
                .flightScheduleId(request.getFlightScheduleId())
                .userId(request.getUserId())
                .status("BOOKED")
                .bookingTime(LocalDateTime.now())
                .build();

        return toDto(ticketRepository.save(ticket), user, flight, schedule);
    }

    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket with this id does not exist"));

        ticket.setStatus("CANCELLED");
        ticketRepository.save(ticket);
    }

    private UserDto fetchUser(Long userId) {
        try {
            return restTemplate.getForObject(USER_SERVICE_URL + "/{id}", UserDto.class, userId);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid User ID provided");
        }
    }

    private FlightDto fetchFlight(Long flightId) {
        try {
            return restTemplate.getForObject(FLIGHT_SERVICE_URL + "/{id}", FlightDto.class, flightId);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Flight ID provided");
        }
    }

    private FlightScheduleDto fetchSchedule(Long scheduleId) {
        try {
            return restTemplate.getForObject(FLIGHT_SERVICE_URL + "/schedules/{id}", FlightScheduleDto.class, scheduleId);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Schedule ID provided");
        }
    }

    private TicketDto toDto(Ticket ticket, UserDto user, FlightDto flight, FlightScheduleDto schedule) {
        return TicketDto.builder()
                .id(ticket.getId())
                .userId(ticket.getUserId())
                .passengerName(user.getFirstName() + " " + user.getLastName())
                .flightId(ticket.getFlightId())
                .flightScheduleId(ticket.getFlightScheduleId())
                .arrivalTime(schedule.getArrivalTime())
                .departureTime(schedule.getDepartureTime())
                .flightNumber(flight.getFlightNumber())
                .origin(flight.getOrigin())
                .price(flight.getPrice())
                .destination(flight.getDestination())
                .seatNumber(ticket.getSeatNumber())
                .status(ticket.getStatus())
                .bookingTime(ticket.getBookingTime())
                .build();
    }
}
