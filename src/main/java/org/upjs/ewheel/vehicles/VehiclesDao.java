package org.upjs.ewheel.vehicles;
import java.util.List;
import java.util.UUID;

public interface VehiclesDao {
    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    Vehicle findById(UUID id);

    VehicleData findByLicencePlate(String licencePlate);

    List<VehicleData> findByName(String name);

    List<VehicleData> findByCategory(VehicleCategory vehicleCategory);

    List<VehicleData> searchVehicle(String query);

    List<VehicleData> findAll();

    void deactivate(UUID id);

    Vehicle reactivate(UUID id);
}
