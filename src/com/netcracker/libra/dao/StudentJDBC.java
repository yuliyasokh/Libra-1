package com.netcracker.libra.dao;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netcracker.libra.model.Student;

@Repository
public class StudentJDBC implements StudentDAO {

   private static JdbcTemplate jdbcTemplateObject;
   private static int userId = 1;
   private final int roleId = 1;
   
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplateObject = new JdbcTemplate(dataSource);
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
   
   public static int verifyLogin(String email, String password)  {
	   String SQL = "select count(*) from users where email=? and password=?";
	   int result;
	   result = jdbcTemplateObject.queryForInt(SQL, email, password);
	   return result;
   }
   
   public int searchByEmail(String email) {
	   String SQL = "select * from users where email=?";
	   return jdbcTemplateObject.queryForInt(SQL, email);
   }

}
