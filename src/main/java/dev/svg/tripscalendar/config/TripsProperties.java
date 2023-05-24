package dev.svg.tripscalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "tc")
public record TripsProperties(String welcomeMessage, String about){}
