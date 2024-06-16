package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.Airport;
import dev.pehlivan.airportreservationsystem.model.entity.AirportCompany;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {
    List<Airport> getAllAirports();

    Airport getAirport(Integer id);

    void addAirport(Airport airport);

    Airport updateAirport(Integer id, Airport airport);

    boolean deleteAirport(Integer id);
}
