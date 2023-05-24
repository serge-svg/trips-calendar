package dev.svg.tripscalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Trip(
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
