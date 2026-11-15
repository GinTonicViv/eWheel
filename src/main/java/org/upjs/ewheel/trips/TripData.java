package org.upjs.ewheel.trips;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripData(
        UUID uuid,
        TripReason reason,
        String note,
        TripStatus status,
        UUID vehicleId,
        UUID userId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        UUID startAddress,
        UUID destinationAddress,
        String userFullName,
        Integer count_pages,
        String vehicleName
) {
}
