/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Faculty;
import java.util.List;

/**
 *
 * @author Yuliya
 */
public interface FacultyDAO {
    
    public void addFaculty(String facultyName, int univerId);
    public void deleteFaculty(int facultyId);
    public void updateFaculty(int faclutyId, String facultyName, int univerId);
    
    public List<Faculty> getAllFaculties(int univerId);
}
