/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Department;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Yuliya
 */
public class DepartmentJDBC implements DepartmentDAO{
    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            jdbcTemplateObject = new JdbcTemplate(dataSource);	
	} 

    @Override
    public void addDepartment(String departmentName, int facId) {
        String query="insert into department values(Department_seq.NEXTVAL,?,?)";
        jdbcTemplateObject.update(query,departmentName,facId);
    }

    @Override
    public void deleteDepartment(int departemtnId) {
        String query="delete from department where departmentID=?";
        jdbcTemplateObject.update(query,departemtnId);
    }

    @Override
    public void updateDepartment(int departmentId, String departmentName, int facId) {
        String query="update department set departmentName=?, facultyId=? where departmentId=?";
        jdbcTemplateObject.update(query, departmentName, facId,departmentId);
    }

    @Override
    public List<Department> getAllDepartments(int facId) {
        String query="select departmentName, departmentId from department where facultyid=?";
        List<Department> departments = jdbcTemplateObject.query(query,new departmentRowMapper(),facId);
        return departments;
    }
    
}
