package org.upjs.ewheel.vehicles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record VehicleData(
        UUID uuid,
        String name,
        String licencePlate,
        VehicleCategory category,
        boolean active,
        BigDecimal kilometers,
        LocalDate lastStk,
        BigDecimal nextOilChangeKilometers,
        LocalDate nextOilChangeDate,
        Integer trips_count
) {
}