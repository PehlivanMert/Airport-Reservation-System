package dev.pehlivan.airportreservationsystem.model.mapper;

import dev.pehlivan.airportreservationsystem.model.dto.AirportDTO;
import dev.pehlivan.airportreservationsystem.model.entity.Airport;

// Sample user defined Mapper
public class AirportMapper {

    public static AirportDTO toDto(Airport airport) {
        AirportDTO airportDto = new AirportDTO();
        airportDto.setName(airport.getName());
        airportDto.setAddresses(airport.formatToAddressList());
        return airportDto;
    }

    public static Airport toEntity(AirportDTO airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.getName());
        airport.setAddress(airportDto.formatAddresses());
        return airport;
    }
}