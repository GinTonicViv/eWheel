package org.upjs.ewheel.trips;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.UuidUtil;
import org.upjs.ewheel.trips.TripRecords.TripRowAnalytics;
import org.upjs.ewheel.users.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<TripRowAnalytics> listTripsOfVehicleAnalytics(UUID vehicle_id,Integer limit) {
        String sql = "SELECT bt.uuid AS bt_uuid, bt.start_date AS bt_start_date ,bt.status AS bt_status, CONCAT(u.name, ' ',u.last_name) AS u_fullname FROM Business_Trip AS bt JOIN User AS u ON u.uuid = bt.user_id JOIN Vehicle AS v ON v.uuid = bt.vehicle_id WHERE bt.status = 'approved' AND v.uuid = ? ORDER BY bt.start_date DESC LIMIT ?";
        return jdbc.query(sql,
                (rs, rowNum) -> new TripRowAnalytics(
                UuidUtil.toUuid(rs.getBytes("bt_uuid")),
                rs.getObject("bt_start_date", LocalDateTime.class),
                rs.getString("bt_status"),
                rs.getString("u_fullname")
                ),
                UuidUtil.toBytes(vehicle_id),
                limit);
    }

    @Override
    public List<Trip> listCarTrips(Integer limit, UUID id) {
        String sql = "SELECT * FROM Business_Trip WHERE vehicle_id = ? ORDER BY start_date DESC LIMIT ?";
        List<Trip> trips = jdbc.query(sql, new TripRowMapper(),UuidUtil.toBytes(id), limit);
        return new ArrayList<>(trips);
    }
}
