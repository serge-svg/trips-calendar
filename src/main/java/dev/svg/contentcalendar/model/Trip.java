package dev.svg.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record Trip(
        Integer id,
        @NotBlank
        String description,
        //@NotBlank
        //Status status,
        @NotBlank
        String status,
        //@NotBlank
        //TripType trip_type,
        @NotBlank
        String trip_type,
        int distance,
        float price,
        LocalDate start_date,
        LocalDate end_date,
        String url
) {
}
