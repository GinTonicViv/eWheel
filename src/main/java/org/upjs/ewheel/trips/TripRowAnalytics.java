package org.upjs.ewheel.trips;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripRowAnalytics(
        UUID uuid,
        LocalDateTime startDate,
        String status,
        String fullName
) {
}