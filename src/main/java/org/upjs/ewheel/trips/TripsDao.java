package org.upjs.ewheel.trips;

import org.upjs.ewheel.users.User;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TripsDao {
    Trip create(Trip trip);

    Trip update(Trip trip);

    Trip findById(UUID id);

    List<Trip> findByUser(User user);

    List<Trip> findByDate(LocalDate from, LocalDate to);

    List<Trip> findByStatus(TripStatus tripStatus);

    List<Trip> findAll();

    List<Trip> searchTrips(String query);

    void deactivate(UUID id);

    Trip reactivate(UUID id);

    List<Trip> listRecentTrips(Integer limit);

    public List<Trip> listCarTrips(Integer limit, UUID id);
}
