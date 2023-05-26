package dev.svg.tripscalendar.services;

import dev.svg.tripscalendar.model.Status;
import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.model.TripType;
import dev.svg.tripscalendar.repository.TripsSDJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TripsServiceTest {

    @Mock
    private TripsSDJdbcRepository repository;

    @InjectMocks
    private TripsService tripsService;

    private Trip trip;

    @BeforeEach
    void setUp() {
        tripsService =  new TripsService(repository);
        trip = new Trip(null,
                "Trip to somewhere",
                Status.IDEA,
                TripType.BEACH,
                100,
                100.0f,
                null,
                null);
    }

    @Test
    void getAll() {
        doReturn(Collections.singletonList(trip)).when(repository).findAll();

    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByStatus() {
    }

    @Test
    void listByTripType() {
    }
}