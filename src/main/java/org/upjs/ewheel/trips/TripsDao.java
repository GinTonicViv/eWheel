package org.upjs.ewheel.trips;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TripsDao {
    Trip create(Trip trip);

    Trip update(Trip trip);

    Trip findById(UUID id);

    List<Trip> findByUser(UUID userId, Integer limit, Integer offset);

    List<Trip> findByDate(LocalDate from, LocalDate to, Integer limit, Integer offset);

    List<Trip> findByStatus(TripStatus tripStatus, Integer limit, Integer offset);

    List<Trip> findAll(Integer limit, Integer offset, UUID userId, UUID vehicleId, TripStatus status, LocalDate from, LocalDate to);

    List<Trip> searchTrips(String query, Integer limit, Integer offset);

    void deactivate(UUID id);

    Trip reactivate(UUID id);

    List<TripData> listTripsOfVehicleAnalytics(UUID vehicleId, Integer limit);

    public List<Trip> listCarTrips(Integer limit, UUID id);

    public List<TripData> listTripRequests(Integer limit, Integer offset, UUID userID, UUID vehicleID, LocalDate from, LocalDate to);

}
