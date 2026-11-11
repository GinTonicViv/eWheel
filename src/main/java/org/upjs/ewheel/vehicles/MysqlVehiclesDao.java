package org.upjs.ewheel.vehicles;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MysqlVehiclesDao implements VehiclesDao {

    private final JdbcTemplate jdbc;

    public MysqlVehiclesDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle findById(UUID id) {
        return null;
    }

    @Override
    public Vehicle findByLicencePlate(String licencePlate) {
        return null;
    }

    @Override
    public List<Vehicle> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Vehicle> findByCategory(VehicleCategory vehicleCategory) {
        return List.of();
    }

    @Override
    public List<Vehicle> searchVehicle(String query) {
        return List.of();
    }

    @Override
    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM Vehicle";
        List<Vehicle> vehicles = jdbc.query(sql, new VehicleRowMapper());
        return new ArrayList<>(vehicles);
    }

    @Override
    public void deactivate(UUID id) {

    }

    @Override
    public Vehicle reactivate(UUID id) {
        return null;
    }
}
