package dev.pehlivan.airportreservationsystem.service;

import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    List<Passenger> getAllPassenger();

    Passenger getPassenger(Integer id);

    void addPassenger(Passenger passenger);

    Passenger updatePassenger(final Integer id, final Passenger passenger);

    boolean deletePassenger(Integer id);

    List<Passenger> getPassengersNameStartsWith(String prefix);

    List<Passenger> getPassengersSortedViaLastNameAsUpperCase();
}
