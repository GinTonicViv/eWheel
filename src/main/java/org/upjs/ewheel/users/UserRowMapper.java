package org.upjs.ewheel.users;

import org.springframework.jdbc.core.RowMapper;
import org.upjs.ewheel.UuidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                UuidUtil.toUuid(rs.getBytes("uuid")),
                rs.getString("email"),
                rs.getString("name"),
                rs.getString("last_name"),
                Role.valueOf(rs.getString("role")),
                rs.getString("password"),
                rs.getInt("is_active") > 0 ? true : false,
                rs.getDate("birthdate"),
                rs.getTimestamp("timestamp")
        );
    }
}
