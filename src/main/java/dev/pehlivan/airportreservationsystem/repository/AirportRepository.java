package dev.pehlivan.airportreservationsystem.repository;

import dev.pehlivan.airportreservationsystem.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
