/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.University;
import java.util.List;

/**
 *
 * @author Yuliya
 */
public interface UniversityDAO {
 
    public void addUniversity(String universityName);
    public void deleteUniversity(int universityID);
    public void updateUniversity(int universityID, String universityName);
    
    public List<University> getAllUniversity();
}
