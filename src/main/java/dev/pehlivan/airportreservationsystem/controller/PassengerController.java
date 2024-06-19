package dev.pehlivan.airportreservationsystem.controller;


import dev.pehlivan.airportreservationsystem.model.Language;
import dev.pehlivan.airportreservationsystem.model.dto.PassengerDTO;
import dev.pehlivan.airportreservationsystem.model.dto.TestBody;
import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import dev.pehlivan.airportreservationsystem.model.mapper.PassengerMapper;
import dev.pehlivan.airportreservationsystem.service.PassengerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passenger")
public class PassengerController {

    private final PassengerService passengerService;
    private static final PassengerMapper PASSENGER_MAPPER = Mappers.getMapper(PassengerMapper.class);

    @GetMapping
    public String welcome() {
        return "Welcome to Passenger Service!";
    }

    @GetMapping(value = "/all")
    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> allPassengers = passengerService.getAllPassenger();
        return allPassengers.stream().map(PASSENGER_MAPPER::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public PassengerDTO getPassenger(@PathVariable @Min(1) Integer id) {
        return PASSENGER_MAPPER.toDto(passengerService.getPassenger(id));
    }

    @PostMapping(value = "/create")
    public void savePassenger(@Valid @RequestBody PassengerDTO passenger) {
        passengerService.addPassenger(PASSENGER_MAPPER.toEntity(passenger));
    }

    // PUT vs PATCH
    @PutMapping(value = "/update/{id}")
    public PassengerDTO updatePassenger(@PathVariable @Min(1) final Integer id,
                                        @Valid @RequestBody PassengerDTO passengerDTO) {
        return PASSENGER_MAPPER.toDto(passengerService.updatePassenger(id, PASSENGER_MAPPER.toEntity(passengerDTO)));
    }

//    @PatchMapping(value = "/update/{id}")
//    public PassengerDTO patchPassenger(@PathVariable @Min(1) final Integer id,
//                                       @Valid @RequestBody Passenger passenger) {
//        return PASSENGER_MAPPER.toDto(passengerService.updatePassenger(id, passenger));
//    }

    @DeleteMapping(value = "/delete")
    public boolean deletePassenger(@RequestParam @Min(1) Integer id) {
        return passengerService.deletePassenger(id);
    }


    @PostMapping("/test/{lang}")
    public String testGetRequestCorrespondingEnum(@PathVariable Language lang,
                                                  @RequestBody TestBody testBody) {

        return "Result : " + lang + " - " + testBody.getLanguage();
    }

}
