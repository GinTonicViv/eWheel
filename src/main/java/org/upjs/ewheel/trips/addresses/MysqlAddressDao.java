package org.upjs.ewheel.trips.addresses;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.trips.Trip;

import java.util.List;
import java.util.UUID;

public class MysqlAddressDao implements AddressDao {
    private JdbcTemplate jdbc;
    public MysqlAddressDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Address create(Address address) {
        return null;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public Address findById(UUID id) {
        return null;
    }

    @Override
    public List<Trip> findByRegion(Region region) {
        return List.of();
    }

    @Override
    public List<Trip> findByCity(String cityName) {
        return List.of();
    }

    @Override
    public List<Trip> findByZip(String zip) {
        return List.of();
    }

    @Override
    public List<Address> findAll() {
        String sql = "SELECT * FROM Business_Trip";
        List<Address> addresses = jdbc.query(sql, new AddressRowMapper());
        return addresses;
    }

    @Override
    public void deactivate(UUID id) {

    }

    @Override
    public Trip reactivate(UUID id) {
        return null;
    }
}
