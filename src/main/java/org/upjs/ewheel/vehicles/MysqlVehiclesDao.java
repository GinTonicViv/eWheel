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
    public VehicleData findByLicencePlate(String licencePlate) {
        return null;
    }

    @Override
    public List<VehicleData> findByName(String name) {
        return List.of();
    }

    @Override
    public List<VehicleData> findByCategory(VehicleCategory vehicleCategory) {
        String sql = "SELECT * FROM VEHICLES WHERE category = ?";
        List<VehicleData> vehicles = jdbc.query(sql, new VehicleDataRowMapper(), vehicleCategory);
        return new ArrayList<>(vehicles);
    }

    @Override
    public List<VehicleData> searchVehicle(String query) {
        return List.of();
    }

    @Override
    public List<VehicleData> findAll() {
        String sql = "SELECT v.*, (SELECT COUNT(*) FROM Business_Trip AS bt WHERE bt.vehicle_id = v.uuid AND bt.status = 'approved') AS trips_count FROM Vehicle AS v";
        List<VehicleData> vehicles = jdbc.query(sql,new VehicleDataRowMapper());
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
