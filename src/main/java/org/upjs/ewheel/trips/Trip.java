package org.upjs.ewheel.trips;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record Trip(
        UUID uuid,
        TripReason reason,
        String note,
        TripStatus status,
        UUID vehicle_id,
        UUID user_id,
        LocalDateTime start_date,
        LocalDateTime end_date,
        UUID start_address,
        UUID destination_address
) {
}
