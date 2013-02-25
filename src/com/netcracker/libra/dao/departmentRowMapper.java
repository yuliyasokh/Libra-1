/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Yuliya
 */
public class departmentRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Department department=new Department();
        department.setDepartmentId(rs.getInt("departmentId"));
        department.setDepartmentName(rs.getString("departmentName"));
        department.setFacId(rs.getInt("facultyId"));
        department.setFacultyName(rs.getString("facultyName"));
        department.setUniversityId(rs.getInt("universityId"));
        department.setUniversityName(rs.getString("universityName"));
        return department;
    }
    
}
