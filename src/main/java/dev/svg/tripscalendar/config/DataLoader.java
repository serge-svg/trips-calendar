package dev.svg.tripscalendar.config;

import dev.svg.tripscalendar.model.Status;
import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.model.TripType;
import dev.svg.tripscalendar.repository.TripsCollectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    TripsCollectionRepository tripsCollectionRepository;

    public DataLoader(TripsCollectionRepository tripsCollectionRepository) {
        this.tripsCollectionRepository = tripsCollectionRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("DataLoader.run");
        tripsCollectionRepository.save(new Trip(1,
                    "First Trip",
                    Status.IDEA,
                    TripType.WORK,
                    100,
                    1000,
                    LocalDate.now(),
                    null));
        tripsCollectionRepository.save(new Trip(2,
                "Second Trip",
                Status.COMPLETED,
                TripType.WORK,
                200,
                2000,
                LocalDate.now(),
                null));
    }
}
