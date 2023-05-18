package dev.svg.contentcalendar.services;


import dev.svg.contentcalendar.model.Status;
import dev.svg.contentcalendar.model.Trip;
import dev.svg.contentcalendar.repository.TripsJdbcTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripsService {

    //private final TripCollectionRepository repository;
    private final TripsJdbcTemplateRepository repository;

    public TripsService(TripsJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    public List<Trip> getAll() {
        return repository.findAll();
    }

    public Optional<Trip> getById(Integer id) {
        return repository.findById(id);
    }

    public void create(Trip trip) {
        repository.create(trip);
    }

    public void update(Trip trip) {
        repository.update(trip);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

}
