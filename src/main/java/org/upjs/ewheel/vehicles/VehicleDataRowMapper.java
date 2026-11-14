package org.upjs.ewheel.vehicles;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleDataRowMapper implements RowMapper<VehicleData> {
    @Override
    public VehicleData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new VehicleData(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                rs.getString("name"),
                rs.getString("licence_plate"),
                VehicleCategory.valueOf(rs.getString("category")),
                rs.getBoolean("is_active"),
                rs.getBigDecimal("kilometers"),
                rs.getDate("last_stk").toLocalDate(),
                rs.getBigDecimal("next_oil_change_kilometers"),
                rs.getDate("next_oil_change_date").toLocalDate(),
                rs.getInt("trips_count")
        );
    }
}
