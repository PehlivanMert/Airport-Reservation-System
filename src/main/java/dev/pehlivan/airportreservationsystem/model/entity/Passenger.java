package dev.pehlivan.airportreservationsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name can not be null")
    private String firstname;

    @NotBlank(message = "Last name can not be null")
    private String lastname;

    //@NotNull(message = "Gender can not be null")
    private String gender;

    //@NotNull(message = "Age can not be null")
    private Integer age;

    //@NotNull(message = "Phone can not be null")
    private String phone;

    @Email(message = "Please enter your e-mail address correctly")
    @NotBlank(message = "E-mail address can not be null")
    private String email;
}
