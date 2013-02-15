/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Department;
import java.util.List;

/**
 *
 * @author Yuliya
 */
public interface DepartmentDAO {
    
    public void addDepartment(String departmentName, int facId);
    public void deleteDepartment(int departemtnId);
    public void updateDepartment(int departmentId, String departmentName, int facId);
    
    public List<Department> getAllDepartments(int facId);
}
