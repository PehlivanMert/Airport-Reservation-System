package dev.pehlivan.airportreservationsystem.model.dto;

import dev.pehlivan.airportreservationsystem.model.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String email;
    List<Role> roles;

}