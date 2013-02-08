package com.netcracker.libra.dao;

import com.netcracker.libra.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Alexander Lebed
 */
public class UserRowMapper implements RowMapper <User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("USERID"));
        user.setFirstName(rs.getString("FIRSTNAME"));
        user.setLastName(rs.getString("LASTNAME"));
        user.setEmail(rs.getString("EMAIL"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setRoleId(rs.getInt("ROLEID"));
        return user;
    }
    
}
