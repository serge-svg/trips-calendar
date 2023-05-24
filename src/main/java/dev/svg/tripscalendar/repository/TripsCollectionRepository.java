package dev.svg.tripscalendar.repository;

import dev.svg.tripscalendar.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TripsCollectionRepository {

    private final List<Trip> tripsList = new ArrayList<>();

    public List<Trip> findAll() {
        return tripsList;
    }

    public Optional<Trip> findById(Integer id) {
        return tripsList.stream().filter(trip -> trip.id().equals(id)).findFirst();
    }

    public void save(Trip trip) {
        tripsList.removeIf(t -> t.id().equals(trip.id()));
        tripsList.add(trip);
    }

    public void deleteById(Integer id) {
        tripsList.removeIf(t -> t.id().equals(id));
    }


}
