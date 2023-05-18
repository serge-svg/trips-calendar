package dev.svg.contentcalendar.repository;

import dev.svg.contentcalendar.model.Status;
import dev.svg.contentcalendar.model.Trip;
import dev.svg.contentcalendar.model.TripType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TripsJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public TripsJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Trip(rs.getInt("id"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                TripType.valueOf(rs.getString("trip_type")),
                rs.getInt("distance"),
                rs.getFloat("price"),
                rs.getObject("start_date", LocalDate.class),
                rs.getObject("end_date", LocalDate.class));
    }

    public List<Trip> findAll() {
        return jdbcTemplate.query("SELECT * FROM Trips", TripsJdbcTemplateRepository::mapRow);
    }

    public Optional<Trip> findById(Integer id) {
        Trip trip = jdbcTemplate.queryForObject("SELECT * FROM Trips WHERE id = ?", new Object[]{id}, TripsJdbcTemplateRepository::mapRow);
        return Optional.of(trip);
    }

    public void create(Trip trip) {
        String sql = "INSERT INTO Trips (description, status, trip_type, distance, price, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, trip.description(), trip.status().toString(), trip.trip_type().toString(), trip.distance(), trip.price(), trip.start_date(), trip.end_date());
    }

    public void update(Trip trip) {
        String sql = "UPDATE Trips SET description = ?, status = ?, trip_type = ?, distance = ?, price = ?, start_date = ?, end_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, trip.description(), trip.status().toString(), trip.trip_type().toString(), trip.distance(), trip.price(), trip.start_date(), trip.end_date(), trip.id());
    }


    public void delete(int id) {
        String sql = "DELETE FROM Trips WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
