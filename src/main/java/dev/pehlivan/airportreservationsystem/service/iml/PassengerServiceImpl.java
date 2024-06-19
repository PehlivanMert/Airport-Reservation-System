package dev.pehlivan.airportreservationsystem.service.iml;

import dev.pehlivan.airportreservationsystem.exception.NotFoundException;
import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import dev.pehlivan.airportreservationsystem.model.mapper.PassengerMapper;
import dev.pehlivan.airportreservationsystem.producer.PassengerProducer;
import dev.pehlivan.airportreservationsystem.repository.PassengerRepository;
import dev.pehlivan.airportreservationsystem.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PassengerServiceImpl implements PassengerService {

    private static final PassengerMapper PASSENGER_MAPPER = Mappers.getMapper(PassengerMapper.class);
    private final PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAllPassenger() {
        // business logic
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassenger(Integer id) {
        Optional<Passenger> byId = passengerRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Passenger"));
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
        log.info("Passenger sent to Producer Queue : {}", passenger);
        PassengerProducer.addToQueue(passenger);
    }

    @Override
    public Passenger updatePassenger(Integer id, Passenger passenger) {
        Passenger currPassenger = getPassenger(id);
        PASSENGER_MAPPER.fill(passenger, currPassenger);
        return passengerRepository.save(currPassenger);

    }

    @Override
    public boolean deletePassenger(Integer id) {
        passengerRepository.delete(getPassenger(id));
        return true;
    }

    @Override
    public List<Passenger> getPassengersNameStartsWith(String prefix) {
        List<Passenger> allPassenger = getAllPassenger();
        return allPassenger.stream()
                .filter(passenger -> passenger.getFirstname().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Passenger> getPassengersSortedViaLastNameAsUpperCase() {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .sorted(Comparator.comparing(Passenger::getLastname))
                .peek(passenger -> passenger.setLastname(passenger.getLastname().toUpperCase()))
                .collect(Collectors.toList());
    }

    private Passenger getTheOldestMalePassengerAndLowerCaseFirstLast() {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .max(Comparator.comparing(Passenger::getAge))
                .filter(p -> p.getGender().equals("male"))
                .orElseThrow(() -> new NotFoundException("No matching passenger"));
    }

    private Boolean isAnyPassengerLastNameStartsWithCharAndFemale(String prefix) {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .anyMatch(p -> p.getLastname().startsWith(prefix) && p.getGender().equals("female"));
    }

    private Boolean isAllPassengerFemaleAndAgeBetween(Integer minAge, Integer maxAge) {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .allMatch(p -> p.getGender().equals("female") && (p.getAge() > minAge && p.getAge() < maxAge));
    }

    private Boolean isNonePassengerFirstNameAndPhoneStartsWith(String firstName, String phonePrefix) {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .noneMatch(p -> p.getFirstname().equals(firstName) && p.getPhone().startsWith(phonePrefix));
    }

    private Integer getCountOfMalePassengersAgeBetween(Integer minAge, Integer maxAge) {
        List<Passenger> allPassengers = getAllPassenger();
        return (int) allPassengers.stream()
                .filter(p -> p.getGender().equals("male") && (p.getAge() > minAge && p.getAge() < maxAge))
                .count();
    }

    private List<String> getPassengerListAsFirstNameAndLastName() {
        List<Passenger> allPassengers = getAllPassenger();
        return allPassengers.stream()
                .map(p -> p.getFirstname() + " " + p.getLastname())
                .collect(Collectors.toList());
    }
}
