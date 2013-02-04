package com.netcracker.libra.dao;

import com.netcracker.libra.model.SignupForm;
import com.netcracker.libra.model.Student;
import java.util.List;
/**
 * 
 * @author Yuliya
 */

public interface HrDAO extends CommonDAO {  
/**
 * Удаление анкеты студента по ID анкеты
 * @param id Id анкеты
 */
public void deleteFormById(Integer id);

/**
 * Изменение анкеты студента
 * @param form 
 */
public void updateStudent(SignupForm form);

/**
 * Получение студента
 * @param id - номер анкеты студента
 * @return список студентов
 */
public List<Student> getStudent(Integer id);

/**
 * Получение всех студентов
 * @return список студентов
 */
public List<Student> listStudents();

/**
 * Получение студентов по имени
 * @param lName - имя студентов
 * @return список студентов
 */
public List<Student> getStudentsByLastName(String lName);

/**
 * получение студетов по фамилии
 * @param fName - фамилия студентов
 * @return  список студентов
 */
public List<Student> getStudentsByFirstName(String fName);

/**
 * Получение студетов по email-у
 * @param mail- эмайл студента
 * @return список студентов
 */
public List<Student> getStudentsByEmail(String mail);


}
