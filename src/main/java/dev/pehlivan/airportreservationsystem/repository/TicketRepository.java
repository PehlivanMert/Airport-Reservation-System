package dev.pehlivan.airportreservationsystem.repository;

import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import dev.pehlivan.airportreservationsystem.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getByPassenger(Passenger passenger);

    List<Ticket> getByFlight(Flight flight);

    List<Ticket> getAllByFlight_DepartureDateBetween(Date startDate, Date endDate);

    //JPQL - Java Persistence Query Language
    @Query(
            value = "SELECT t FROM Ticket t " +
                    " WHERE (:flight is NULL or :flight = t.flight) " +
                    " ORDER BY t.id ")
    Page<Ticket> getAllByFlightPagination(
            Pageable pageable,
            @Param("flight") Flight flight
    );

    Page<Ticket> getAllByFlightOrderById(Pageable pageable, Flight flight);
}
