package org.upjs.ewheel.trips.TripRecords;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripRowAnalytics(
        UUID uuid,
        LocalDateTime startDate,
        String status,
        String fullName
) {
}