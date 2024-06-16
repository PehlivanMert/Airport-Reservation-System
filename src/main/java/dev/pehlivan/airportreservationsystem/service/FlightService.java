package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {
    List<Flight> getAllFlights();

    Flight getFlight(Integer id);

    void addFlight(Flight flight);

    Flight updateFlight(Flight flight);

    boolean deleteFlight(Integer id);

    List<Flight> getAllFlightsDepartureDateBetween(Date start, Date end);

    Flight getFlightByCode(String code);

    List<Flight> getFlightsByAirportCompany(String airportCompanyName);
}
