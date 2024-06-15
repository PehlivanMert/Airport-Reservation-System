package dev.pehlivan.airportreservationsystem.model.dto;

import dev.pehlivan.airportreservationsystem.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.StringJoiner;

@Data
public class AirportDTO {

    @NotBlank
    private String name;

    @NotEmpty
    private List<@Valid Address> addresses;

    public String formatAddresses() {
        StringJoiner stringJoiner = new StringJoiner("//");
        getAddresses().forEach(address -> stringJoiner.add(address.dbFormat()));
        return stringJoiner.toString();
    }
}
