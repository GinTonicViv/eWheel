package org.upjs.ewheel.trips.addresses;

import org.upjs.ewheel.trips.Trip;
import java.util.List;
import java.util.UUID;

public interface AddressDao {
    Address create(Address address);

    Address update(Address address);

    Address findById(UUID id);

    List<Trip> findByRegion(Region region);

    List<Trip> findByCity(String cityName);

    List<Trip> findByZip(String zip);

    List<Trip> findAll();

    void deactivate(UUID id);

    Trip reactivate(UUID id);
}
