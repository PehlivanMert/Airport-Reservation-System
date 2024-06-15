package dev.pehlivan.airportreservationsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airport_company")
public class AirportCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can not be null")
    private String name;

    // Cascade Type sample usage as CascadeType.REMOVE
    @JsonIgnore
    @OneToMany(mappedBy = "airportCompany", cascade = CascadeType.MERGE)
    private List<Flight> flights;

    @Override
    public String toString() {
        return "AirportCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
