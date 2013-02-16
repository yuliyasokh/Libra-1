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
        return department;
    }
    
}
