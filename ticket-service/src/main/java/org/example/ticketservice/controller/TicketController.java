package org.example.ticketservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ticketservice.dto.CreateTicketRequest;
import org.example.ticketservice.dto.TicketDto;
import org.example.ticketservice.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Validated
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @PostMapping("/")
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        TicketDto newTicket = ticketService.createTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.noContent().build();
    }
}
