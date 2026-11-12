package org.upjs.ewheel.trips;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TripRowMapper implements RowMapper<Trip> {
    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Trip(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                TripReason.valueOf(rs.getString("reason")),
                rs.getString("note"),
                TripStatus.valueOf(rs.getString("status")),
                UuidUtil.toUuid(rs.getBytes("vehicle_id")),
                UuidUtil.toUuid(rs.getBytes("user_id")),
                rs.getObject("start_date", LocalDateTime.class),
                rs.getObject("end_date", LocalDateTime.class),
                UuidUtil.toUuid(rs.getBytes("start_address")),
                UuidUtil.toUuid(rs.getBytes("destination_address"))
        );
    }
}
