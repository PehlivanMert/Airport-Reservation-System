package dev.pehlivan.airportreservationsystem.model.dto;

import dev.pehlivan.airportreservationsystem.model.Language;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBody {
    private Language language;
}
