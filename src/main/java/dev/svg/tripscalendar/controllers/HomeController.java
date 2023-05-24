package dev.svg.tripscalendar.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
    @Value("${tc.welcomeMessage: Default Welcome Message}")
    private String welcomeMessage;

    @Value("${tc.about: Default About Message}")
    private String about;

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("welcomeMessage", welcomeMessage, "about", about);
    }
}
