package dev.svg.tripscalendar.repository;

import dev.svg.tripscalendar.model.Status;
import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.model.TripType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @PostConstruct
    private void init(){
        tripsList.add(new Trip(1,
                "First Trip",
                Status.IDEA,
                TripType.WORK,
                100,
                1000,
                LocalDate.now(),
                null));
        tripsList.add(new Trip(2,
                "Second Trip",
                Status.IDEA,
                TripType.ADVENTURE,
                200,
                2000,
                LocalDate.now(),
                null));
    }



}
