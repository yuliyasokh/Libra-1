package com.netcracker.libra.dao;

import com.netcracker.libra.model.Student;
import java.util.List;
/**
 * 
 * @author Yuliya
 */

public interface HrDAO extends CommonDAO {  

public void deleteFormById(Integer id);

public List<Student> listStudents();

public List<Student> getStudentsByLastName(String lName);


public List<Student> getStudentsByFirstName(String fName);


public List<Student> getStudentsByEmail(String mail);


}
