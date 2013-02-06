/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.netcracker.libra.model.Student;
/**
 *
 * @author Yuliya
 */
public class ShortStudentRowMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setAppId(rs.getInt("APPID"));
      student.setName(rs.getString("FIRSTNAME"));
      student.setLastName(rs.getString("LASTNAME"));
      student.setEmail(rs.getString("EMAIL"));
      return student;
   }
}
