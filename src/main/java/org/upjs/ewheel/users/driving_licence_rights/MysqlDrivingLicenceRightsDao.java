package org.upjs.ewheel.users.driving_licence_rights;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.trips.Trip;
import org.upjs.ewheel.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MysqlDrivingLicenceRightsDao implements DrivingLicenceRightsDao {
    private JdbcTemplate jdbc;
    public MysqlDrivingLicenceRightsDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Trip create(DrivingLicenseRights rights) {
        return null;
    }

    @Override
    public Trip update(DrivingLicenseRights rights) {
        return null;
    }

    @Override
    public Trip findById(UUID id) {
        return null;
    }

    @Override
    public List<DrivingLicenseRights> findUsersRights(UUID id) {
        String sql = "SELECT * FROM driving_licence_rights WHERE user_id = ?";
        List<DrivingLicenseRights> drivingLicenseRights = jdbc.query(sql, new DrivingLicenceRightsRowMapper(), id);
        return new ArrayList<>(drivingLicenseRights);
    }

    @Override
    public List<User> findUsersByCategory(String category) {
        return List.of();
    }

    @Override
    public List<DrivingLicenseRights> findAll(Integer pagination) {
        return List.of();
    }

    @Override
    public void deactivate(UUID id) {

    }

    @Override
    public DrivingLicenseRights reactivate(UUID id) {
        return null;
    }
}
