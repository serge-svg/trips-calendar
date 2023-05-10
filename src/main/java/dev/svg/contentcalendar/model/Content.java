package dev.svg.contentcalendar.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Content(
        Integer id,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
