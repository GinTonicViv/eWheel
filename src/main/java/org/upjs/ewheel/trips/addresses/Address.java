package org.upjs.ewheel.trips.addresses;

import java.util.UUID;

public record Address(
        UUID uuid,
        String street,
        String number,
        String city,
        String zip,
        Region region
){
};
