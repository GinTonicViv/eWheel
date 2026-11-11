package org.upjs.ewheel;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidUtil {
    public static UUID getUUID() {
        return UUID.randomUUID();
    }

    public static UUID toUuid(byte[] bytes) {
        var bb = ByteBuffer.wrap(bytes);
        return new UUID(bb.getLong(), bb.getLong());
    }

    // Java -> DB
    public static byte[] toBytes(UUID uuid) {
        return ByteBuffer.allocate(16)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits())
                .array();
    }
}
