package org.upjs.ewheel.trips;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.UuidUtil;
import org.upjs.ewheel.users.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Trip> findByUser(UUID userId, Integer limit, Integer offset) {
        return List.of();
    }

    @Override
    public List<Trip> findByDate(LocalDate from, LocalDate to, Integer limit, Integer offset) {
        return List.of();
    }

    @Override
    public List<Trip> findByStatus(TripStatus tripStatus, Integer limit, Integer offset) {
        return List.of();
    }

    @Override
    public List<Trip> findAll(Integer limit, Integer offset, UUID userId, UUID vehicleId, TripStatus status, LocalDate from, LocalDate to) {
        return List.of();
    }

    @Override
    public List<Trip> searchTrips(String query, Integer limit, Integer offset) {
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
    public List<TripData> listTripsOfVehicleAnalytics(UUID vehicleId, Integer limit) {
        String sql = "SELECT bt.*, CONCAT(u.name, ' ', u.last_name) AS user_full_name, (SELECT COUNT(*) FROM Business_Trip) AS count_pages FROM Business_Trip AS bt JOIN User AS u ON u.uuid = bt.user_id WHERE bt.status = 'approved' AND bt.vehicle_id = ? ORDER BY bt.start_date DESC LIMIT ?";
        return jdbc.query(sql, new TripDataRowMapper(), UuidUtil.toBytes(vehicleId), limit);
    }

    @Override
    public List<Trip> listCarTrips(Integer limit, UUID id) {
        String sql = "SELECT *, (SELECT COUNT(*) FROM Business_Trip) AS count_pages FROM Business_Trip WHERE vehicle_id = ? ORDER BY start_date DESC LIMIT ?";
        List<Trip> trips = jdbc.query(sql, new TripRowMapper(),UuidUtil.toBytes(id), limit);
        if (trips.isEmpty()) {
            return List.of();
        }
        return new ArrayList<>(trips);
    }

    @Override
    public List<TripData> listTripRequests(Integer limit, Integer offset, UUID userID, UUID vehicleID, LocalDate from, LocalDate to) {
        StringBuilder sql = new StringBuilder("SELECT bt.*, CONCAT(u.name, ' ', u.last_name) AS user_full_name, (SELECT COUNT(*) FROM Business_Trip) AS count_pages, v.name AS vehicle_name FROM Business_Trip AS bt JOIN User AS u ON u.uuid = bt.user_id JOIN Vehicle AS v ON v.uuid = bt.vehicle_id WHERE bt.status = 'pending'");
        List<Object> args = new ArrayList<>();
        if(userID != null) {
            sql.append(" AND bt.user_id = ? ");
            args.add(UuidUtil.toBytes(userID));
        }

        if(vehicleID != null) {
            sql.append(" AND bt.vehicle_id = ? ");
            args.add(UuidUtil.toBytes(vehicleID));
        }

        if(from != null) {
            sql.append(" AND bt.start_date >= ? ");
            args.add(from);
        }

        if(to != null) {
            sql.append(" AND bt.start_date <= ? ");
            args.add(to);
        }
        sql.append(" ORDER BY start_date DESC LIMIT ?,?");
        args.add(offset);
        args.add(limit);
        List<TripData> trips = jdbc.query(sql.toString(), new TripDataRowMapper(), args.toArray());

        if (trips.isEmpty()) {
            return List.of();
        }
        return new ArrayList<>(trips);
    }
}
