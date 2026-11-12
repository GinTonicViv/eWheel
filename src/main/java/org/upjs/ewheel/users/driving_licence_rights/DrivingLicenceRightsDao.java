package org.upjs.ewheel.users.driving_licence_rights;

import org.upjs.ewheel.trips.Trip;
import org.upjs.ewheel.users.User;

import java.util.List;
import java.util.UUID;

public interface DrivingLicenceRightsDao {

    Trip create(DrivingLicenseRights rights);

    Trip update(DrivingLicenseRights rights);

    Trip findById(UUID id);

    List<DrivingLicenseRights> findUsersRights(UUID id);

    List<User> findUsersByCategory(String category);

    List<DrivingLicenseRights> findAll(Integer pagination);

    void deactivate(UUID id);

    DrivingLicenseRights reactivate(UUID id);

}
