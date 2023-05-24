package dev.svg.tripscalendar.repository;

import dev.svg.tripscalendar.model.Trip;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripsSDJdbcRepository extends ListCrudRepository<Trip, Integer> {
    List<Trip> findByStatus(String status);

    @Query("""
            SELECT * FROM trips
            WHERE trip_type = :tripType""")
    List<Trip> listByTripType(@Param("tripType") String tripType);
}
