/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Faculty;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Yuliya
 */
public class FacultyRowMapper implements RowMapper<Faculty> {

    @Override
    public Faculty mapRow(ResultSet rs, int i) throws SQLException {
        Faculty faculty=new Faculty();
        faculty.setFacultyId(rs.getInt("facultyId"));
        faculty.setFacultyName(rs.getString("facultyName"));
        return faculty;
    }
    
}
