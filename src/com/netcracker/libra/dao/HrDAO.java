package com.netcracker.libra.dao;

import com.netcracker.libra.model.SignupForm;
import com.netcracker.libra.model.Student;

public interface HrDAO extends CommonDAO {
    
/**
 * Удаление анкеты студента по ID анкеты
 * @param id Id анкеты
 */
public void deleteFormById(Integer id);

public void updateStudent(SignupForm form);

}
