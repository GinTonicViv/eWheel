package org.upjs.ewheel.trips;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.users.User;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MysqlTripsDao implements TripsDao {

    private final JdbcTemplate jdbc;

    public MysqlTripsDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Trip create(Trip trip) {
        return null;
    }

    @Override
    public Trip update(Trip trip) {
        return null;
    }

    @Override
    public Trip findById(UUID id) {
        return null;
    }

    @Override
    public List<Trip> findByUser(User user) {
        return List.of();
    }

    @Override
    public List<Trip> findByDate(LocalDate from, LocalDate to) {
        return List.of();
    }

    @Override
    public List<Trip> findByStatus(TripStatus tripStatus) {
        return List.of();
    }

    @Override
    public List<Trip> findAll() {

        return List.of();
    }

    @Override
    public List<Trip> searchTrips(String query) {
        return List.of();
    }

    @Override
    public void deactivate(UUID id) {

    }

    @Override
    public Trip reactivate(UUID id) {
        return null;
    }

    @Override
    public List<Trip> listRecentTrips(Integer limit) {
        return List.of();
    }
}
