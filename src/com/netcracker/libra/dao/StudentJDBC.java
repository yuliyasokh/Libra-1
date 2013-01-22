package com.netcracker.libra.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.netcracker.libra.model.Student;

public class StudentJDBC implements StudentDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   private static int userId = 1;
   private final int roleId = 1;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(String name, String lastName, String email, String password) {
      String SQL = "insert into Users (USERID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLEID) values (?,?,?,?,?,?)";
      
      jdbcTemplateObject.update(SQL, userId, name, lastName, email, password, roleId);
      System.out.println("Created Record Name = " + name + " Lastname = " + lastName + " Id = " +userId);
      userId++;
      return;
   }

   public Student getStudent(Integer id) {
      String SQL = "select * from Users where userid = ?";
      Student student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new StudentRowMapper());
      return student;
   }

   public List<Student> listStudents() {
      String SQL = "select * from Users where roleid=1";
      List <Student> students = jdbcTemplateObject.query(SQL, new StudentRowMapper());
      return students;
   }

   public void delete(Integer id){
      String SQL = "delete from Users where id = ?)";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, String name, String lastName, String email, String password) {
      String SQL = "update Users set firstname = ?, lastname = ?, email = ?, password = ? where userid = ?";
      jdbcTemplateObject.update(SQL, name, lastName, email, password, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}
