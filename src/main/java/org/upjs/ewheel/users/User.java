package org.upjs.ewheel.users;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public record User(
        UUID uuid,
        String email,
        String name,
        String last_name,
        Role role,
        String password,
        Boolean is_active,
        Date birthdate,
        Timestamp created_at
) {
}
