package dev.svg.tripscalendar.repository;

import dev.svg.tripscalendar.model.Status;
import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.model.TripType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TripsSDJdbcRepositoryTest {

    @Autowired
    TripsSDJdbcRepository repository;

    @Test
    void shouldReturnOneOrMoreTripsWhenFindByStatusIDEA() {
        repository.save(new Trip(null,
                "Trip to somewhere",
                Status.IDEA,
                TripType.BEACH,
                100,
                100.0f,
                null,
                null));

        var tripsWithStatusIDEA = repository.findByStatus(Status.IDEA.toString());

        assertTrue(tripsWithStatusIDEA.size() > 0);
    }

    @Test
    void shouldReturnOneOrMoreTripsWhenListByTripTypeBEACH() {
        repository.save(new Trip(null,
                "Trip to somewhere",
                Status.IDEA,
                TripType.BEACH,
                100,
                100.0f,
                null,
                null));

        var tripsWithTypeBEACH = repository.listByTripType(TripType.BEACH.toString());

        assertTrue(tripsWithTypeBEACH.size() > 0);
    }
}