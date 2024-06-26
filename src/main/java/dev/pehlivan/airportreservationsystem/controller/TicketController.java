package dev.pehlivan.airportreservationsystem.controller;


import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import dev.pehlivan.airportreservationsystem.model.entity.Ticket;
import dev.pehlivan.airportreservationsystem.service.FlightService;
import dev.pehlivan.airportreservationsystem.service.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    private final FlightService flightService;

    @GetMapping
    public String welcome() {
        return "Welcome to Ticket Service!";
    }

    @GetMapping(value = "/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping(value = "/{id}")
    public Ticket getTicket(@PathVariable @Min(1) Integer id) {
        return ticketService.getTicket(id);
    }

    @PostMapping(value = "/create")
    public void saveTicket(@Valid @RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    @PutMapping(value = "/update")
    public Ticket updateTicket(@Valid @RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteTicket(@RequestParam @Min(1) Integer id) {
        return ticketService.deleteTicket(id);
    }

    @GetMapping(value = "/all/flight/{id}")
    public List<Ticket> getFlightRelatedTickets(@PathVariable @Min(1) Integer id) {
        Flight flight = flightService.getFlight(id);
        Page<Ticket> relatedFlightTickets = ticketService.getRelatedFlightTickets(Pageable.unpaged(), flight);
        return relatedFlightTickets.getContent();
    }

}
