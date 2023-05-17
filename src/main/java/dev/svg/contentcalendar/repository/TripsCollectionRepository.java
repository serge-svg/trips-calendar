package dev.svg.contentcalendar.repository;

import dev.svg.contentcalendar.model.Trip;
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

    /*
    @PostConstruct
    private void init(){
        tripsList.add(new Trip(1,
                "First Trip",
                Status.IDEA,
                Type.WORK,
                LocalDate.now(),
                null,
                ""));
        tripsList.add(new Trip(2,
                "Second Trip",
                Status.IDEA,
                Type.ADVENTURE,
                LocalDate.now(),
                null,
                ""));
    }
    */


}
