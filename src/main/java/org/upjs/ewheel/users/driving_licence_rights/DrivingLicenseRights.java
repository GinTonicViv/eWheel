package org.upjs.ewheel.users.driving_licence_rights;

import java.util.UUID;

public record DrivingLicenseRights(
        UUID uuid,
        Category category,
        UUID user_id
) {
}
