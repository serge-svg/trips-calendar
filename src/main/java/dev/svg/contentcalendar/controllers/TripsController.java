package dev.svg.contentcalendar.controllers;

import dev.svg.contentcalendar.model.Trip;
import dev.svg.contentcalendar.services.TripsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/trips")
@CrossOrigin
public class TripsController {

    private final TripsService service;

    public TripsController(TripsService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Trip> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Trip> getById(@PathVariable Integer id) {
        return Optional.ofNullable(service.getById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found")));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Trip trip) {
        service.create(trip);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody Trip trip) {
        if (!service.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");
        }
        service.update(trip);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");
        }
        service.delete(id);
    }

}
