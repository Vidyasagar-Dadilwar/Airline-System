package org.example.ticketservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.example.ticketservice.dto.*;
import org.example.ticketservice.model.Ticket;
import org.example.ticketservice.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final RestTemplate restTemplate;

    @Value("${flight.service.url}")
    private String FLIGHT_SERVICE_URL;

    @Value("${user.service.url}")
    private String USER_SERVICE_URL;

    public TicketService(TicketRepository ticketRepository, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional(readOnly = true)
    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket with this id does not exist"));

        UserDto user;
        FlightDto flight;
        FlightScheduleDto schedule;

        try {
            user = restTemplate.getForObject(
                    USER_SERVICE_URL + "/{id}",
                    UserDto.class,
                    ticket.getUserId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid User ID provided");
        }

        try {
            flight = restTemplate.getForObject(
                    FLIGHT_SERVICE_URL + "/{id}",
                    FlightDto.class,
                    ticket.getFlightId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Flight ID provided");
        }

        try {
            schedule = restTemplate.getForObject(
                    FLIGHT_SERVICE_URL + "/schedules/{id}",
                    FlightScheduleDto.class,
                    ticket.getFlightScheduleId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Schedule ID provided");
        }

        return toDto(ticket, user, flight, schedule);
    }

    @Transactional
    public TicketDto createTicket(CreateTicketRequest request) {
        UserDto user;
        FlightDto flight;
        FlightScheduleDto schedule;

        try {
            user = restTemplate.getForObject(
                    USER_SERVICE_URL + "/{id}",
                    UserDto.class,
                    request.getUserId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid User ID provided");
        }

        try {
            flight = restTemplate.getForObject(
                    FLIGHT_SERVICE_URL + "/{id}",
                    FlightDto.class,
                    request.getFlightId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Flight ID provided");
        }

        try {
            schedule = restTemplate.getForObject(
                    FLIGHT_SERVICE_URL + "/schedules/{id}",
                    FlightScheduleDto.class,
                    request.getFlightScheduleId()
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new IllegalArgumentException("Invalid Schedule ID provided");
        }

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

    // Mapper Method - Used to convert Ticket, User, Flight, and Schedule to TicketDto
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

    // Optional: Mapper Method to convert TicketDto back to Ticket entity
    private Ticket toTicket(TicketDto dto) {
        return Ticket.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .flightId(dto.getFlightId())
                .flightScheduleId(dto.getFlightScheduleId())
                .seatNumber(dto.getSeatNumber())
                .status(dto.getStatus())
                .bookingTime(dto.getBookingTime())
                .price(dto.getPrice())
                .build();
    }
}
