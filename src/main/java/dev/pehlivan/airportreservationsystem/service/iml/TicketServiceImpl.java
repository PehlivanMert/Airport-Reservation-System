package dev.pehlivan.airportreservationsystem.service.iml;

import dev.pehlivan.airportreservationsystem.exception.NotFoundException;
import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import dev.pehlivan.airportreservationsystem.model.entity.Ticket;
import dev.pehlivan.airportreservationsystem.repository.TicketRepository;
import dev.pehlivan.airportreservationsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(Integer id) {
        Optional<Ticket> byId = ticketRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Ticket"));
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public boolean deleteTicket(Integer id) {
        ticketRepository.delete(getTicket(id));
        return true;

    }

    @Override
    public Page<Ticket> getRelatedFlightTickets(Pageable pageable, Flight flight) {
        return ticketRepository.getAllByFlightPagination(pageable, flight);
    }
}
