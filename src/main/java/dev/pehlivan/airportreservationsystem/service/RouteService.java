package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    List<Route> getAllRoutes();

    Route getRoute(Integer id);

    void addRoute(Route route);

    Route updateRoute(Route route);

    boolean deleteRoute(Integer id);

    Route getFirstRouteByDepartureAirportByDefault(Integer departureAirportId);
}
