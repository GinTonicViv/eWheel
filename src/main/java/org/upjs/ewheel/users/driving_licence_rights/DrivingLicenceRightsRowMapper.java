package org.upjs.ewheel.users.driving_licence_rights;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrivingLicenceRightsRowMapper implements RowMapper<DrivingLicenseRights> {
    @Override
    public DrivingLicenseRights mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DrivingLicenseRights(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                Category.valueOf(rs.getString("category")),
                UuidUtil.toUuid(rs.getBytes("user_id"))
        );
    }
}
