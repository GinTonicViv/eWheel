package org.upjs.ewheel.trips;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TripDataRowMapper implements RowMapper<TripData> {
    @Override
    public TripData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TripData(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                TripReason.valueOf(rs.getString("reason")),
                rs.getString("note"),
                TripStatus.valueOf(rs.getString("status")),
                UuidUtil.toUuid(rs.getBytes("vehicle_id")),
                UuidUtil.toUuid(rs.getBytes("user_id")),
                rs.getObject("start_date", LocalDateTime.class),
                rs.getObject("end_date", LocalDateTime.class),
                UuidUtil.toUuid(rs.getBytes("start_address")),
                UuidUtil.toUuid(rs.getBytes("destination_address")),
                rs.getString("user_full_name"),
                rs.getInt("count_pages"),
                rs.getString("vehicle_name")
        );
    }
}
