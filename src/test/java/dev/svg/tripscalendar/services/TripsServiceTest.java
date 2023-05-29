package dev.svg.tripscalendar.services;

import dev.svg.tripscalendar.model.Status;
import dev.svg.tripscalendar.model.Trip;
import dev.svg.tripscalendar.model.TripType;
import dev.svg.tripscalendar.repository.TripsSDJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("Trips Service")
@ExtendWith(MockitoExtension.class)
class TripsServiceTest {

    @Mock
    private TripsSDJdbcRepository repository;

    @InjectMocks
    private TripsService tripsService;

    private Trip trip;

    @BeforeEach
    void setUp() {
        trip = new Trip(1,
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
        when(repository.findAll()).thenReturn(Collections.singletonList(trip));

        assertThat(tripsService.getAll()).isNotEmpty();
    }

    @Test
    void getById() {
        when(repository.findById(1)).thenReturn(java.util.Optional.of(trip));

        assertThat(tripsService.getById(1)).isEqualTo(java.util.Optional.of(trip));
    }

    @Test
    void create() {
        when(repository.save(any(Trip.class))).thenReturn(trip);
        tripsService.create(trip);
        verify(repository, times(1)).save(any(Trip.class));
    }

    @Test
    void update() {
        when(repository.save(any(Trip.class))).thenReturn(trip);
        tripsService.update(trip);
        verify(repository, atLeastOnce()).save(any(Trip.class));
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(1);
        tripsService.delete(1);
        verify(repository, times(1)).deleteById(1);
    }

    @Test
    void findByStatus() {
        when(repository.findByStatus("IDEA")).thenReturn(Collections.singletonList(trip));

        assertThat(tripsService.findByStatus("IDEA")).isNotEmpty();
    }

    @Test
    void listByTripType() {
        when(repository.listByTripType("BEACH")).thenReturn(Collections.singletonList(trip));

        assertThat(tripsService.listByTripType("BEACH")).isNotEmpty();
    }
}