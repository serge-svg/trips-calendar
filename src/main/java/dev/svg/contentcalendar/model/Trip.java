package dev.svg.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(value = "TRIPS")
public record Trip(
        @Id
        Integer id,
        @NotBlank
        String description,
        @NotNull
        Status status,
        @NotNull
        TripType trip_type,
        int distance,
        float price,
        LocalDate start_date,
        LocalDate end_date
) {
}
