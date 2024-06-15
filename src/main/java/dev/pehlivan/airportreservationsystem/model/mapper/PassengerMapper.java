package dev.pehlivan.airportreservationsystem.model.mapper;

import dev.pehlivan.airportreservationsystem.model.dto.PassengerDTO;
import dev.pehlivan.airportreservationsystem.model.entity.Passenger;
import org.mapstruct.*;

@Mapper
public interface PassengerMapper {
    PassengerDTO toDto(Passenger entity);

    Passenger toEntity(PassengerDTO dto);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void fill(Passenger source, @MappingTarget Passenger target);

}
