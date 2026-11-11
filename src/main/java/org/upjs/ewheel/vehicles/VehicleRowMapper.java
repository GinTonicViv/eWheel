package org.upjs.ewheel.vehicles;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.upjs.ewheel.UuidUtil;

public class VehicleRowMapper implements RowMapper<Vehicle> {
    @Override
    public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Vehicle(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                rs.getString("name"),
                rs.getString("licence_plate"),
                VehicleCategory.valueOf(rs.getString("category")),
                rs.getBoolean("is_active"),
                rs.getBigDecimal("kilometers"),
                rs.getDate("last_stk").toLocalDate(),
                rs.getBigDecimal("next_oil_change_kilometers"),
                rs.getDate("next_oil_change_date").toLocalDate()
        );
    }
}
