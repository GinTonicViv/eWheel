package org.upjs.ewheel.vehicles;
import java.util.List;
import java.util.UUID;

public interface VehiclesDao {
    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    Vehicle findById(UUID id);

    Vehicle findByLicencePlate(String licencePlate);

    List<Vehicle> findByName(String name);

    List<Vehicle> findByCategory(VehicleCategory vehicleCategory);

    List<Vehicle> searchVehicle(String query);

    List<Vehicle> findAll();

    void deactivate(UUID id);

    Vehicle reactivate(UUID id);
}
