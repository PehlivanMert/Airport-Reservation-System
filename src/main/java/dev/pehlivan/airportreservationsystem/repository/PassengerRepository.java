package dev.pehlivan.airportreservationsystem.repository;

import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
