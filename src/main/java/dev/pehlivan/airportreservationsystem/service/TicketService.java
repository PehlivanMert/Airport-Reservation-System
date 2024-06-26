package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import dev.pehlivan.airportreservationsystem.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicket(Integer id);
    void addTicket(Ticket ticket);
    Ticket updateTicket(Ticket ticket);
    boolean deleteTicket(Integer id);

    Page<Ticket> getRelatedFlightTickets(Pageable pageable, Flight flight);
}
