package dev.pehlivan.airportreservationsystem.service.iml;

import dev.pehlivan.airportreservationsystem.exception.NotFoundException;
import dev.pehlivan.airportreservationsystem.model.entity.Airport;
import dev.pehlivan.airportreservationsystem.model.entity.Route;
import dev.pehlivan.airportreservationsystem.repository.RouteRepository;
import dev.pehlivan.airportreservationsystem.service.AirportService;
import dev.pehlivan.airportreservationsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final AirportService airportService;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route getRoute(Integer id) {
        Optional<Route> byId = routeRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Route"));
    }

    @Override
    public void addRoute(Route route) {
        routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public boolean deleteRoute(Integer id) {
        routeRepository.delete(getRoute(id));
        return true;

    }

    @Override
    public Route getFirstRouteByDepartureAirportByDefault(Integer departureAirportId) {
        Airport depAirport = airportService.getAirport(departureAirportId);
        Optional<Route> byDepartureAirport = Optional.ofNullable(routeRepository.findByDepartureAirport(depAirport));
        return byDepartureAirport.orElseThrow(() -> new NotFoundException("FirstRouteByDepartureAirport"));
    }
}
