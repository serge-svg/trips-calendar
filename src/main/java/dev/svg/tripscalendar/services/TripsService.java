package dev.svg.tripscalendar.services;

import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.repository.TripsSDJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripsService {

    private final TripsSDJdbcRepository repository;

    public TripsService(TripsSDJdbcRepository repository) {
        this.repository = repository;
    }

    public List<Trip> getAll() {
        return repository.findAll();
    }

    public Optional<Trip> getById(Integer id) {
        return repository.findById(id);
    }

    public void create(Trip trip) {
        repository.save(trip);
    }

    public void update(Trip trip) {
        repository.save(trip);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Trip> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Trip> listByTripType(String tripType) {
        return repository.listByTripType(tripType);
    }
}
