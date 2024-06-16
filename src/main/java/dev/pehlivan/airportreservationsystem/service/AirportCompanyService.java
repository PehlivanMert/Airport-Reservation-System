package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.AirportCompany;
import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import dev.pehlivan.airportreservationsystem.model.entity.Ticket;

import java.util.List;

public interface AirportCompanyService {
    List<AirportCompany> getAllAirportCompanies();

    AirportCompany getAirportCompany(Integer id);

    void addAirportCompany(AirportCompany airportCompany);

    AirportCompany updateAirportCompany(AirportCompany airportCompany);

    boolean deleteAirportCompany(Integer id);

    boolean addNewFlight(Integer airportCompanyId, Integer flightId);

    Ticket buyTicketForFlight(Integer flightId, Integer passengerId);

    boolean cancelTicket(Integer ticketId);

    Ticket searchTicket(Integer ticketId);

    List<Flight> getAllFlightByAirportCompany(Integer airportCompanyId);
}
