package org.upjs.ewheel.vehicles.repairs;

import org.upjs.ewheel.vehicles.Vehicle;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RepairDao {
    Repair create(Repair repair);

    Repair update(Repair repair);

    Repair findById(UUID id);

    List<Repair> findByDate (LocalDate localDate);

    List<Repair> findByVehicle(Vehicle vehicle);

    List<Repair> findByTitle(Title title);

    List<Repair> searchRepair(String query);

    List<Repair> findAll();

    void deactivate(UUID id);

    Repair reactivate(UUID id);
}
