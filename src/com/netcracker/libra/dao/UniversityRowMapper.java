/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.University;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Yuliya
 */
public class UniversityRowMapper implements RowMapper<University>{

    @Override
    public University mapRow(ResultSet rs, int i) throws SQLException {
        University university=new University();
        university.setUniversityId(rs.getInt("UniversityId"));
        university.setUniversityName(rs.getString("UniversityName"));
        return university;
    }
    
}
