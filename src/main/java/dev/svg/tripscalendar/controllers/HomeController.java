package dev.svg.tripscalendar.controllers;

import dev.svg.tripscalendar.config.TripsProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final TripsProperties properties;

    public HomeController(TripsProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public TripsProperties home() {
        return properties;
    }
}
