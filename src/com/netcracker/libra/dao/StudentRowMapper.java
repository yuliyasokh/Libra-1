package com.netcracker.libra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.netcracker.libra.model.Student;

public class StudentRowMapper implements RowMapper<Student> {
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setId(rs.getInt("USERID"));
      student.setName(rs.getString("FIRSTNAME"));
      student.setLastName(rs.getString("LASTNAME"));
      student.setEmail(rs.getString("EMAIL"));
      student.setPassword(rs.getString("PASSWORD"));
      student.setRoleId(rs.getInt("ROLEID"));
      return student;
   }
}
