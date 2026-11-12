package org.upjs.ewheel.trips.addresses;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Address(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                rs.getString("street"),
                rs.getString("Number"),
                rs.getString("City"),
                rs.getString("zip"),
                Region.valueOf(rs.getString("region"))
        );
    }
}
