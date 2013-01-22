package com.netcracker.libra.model;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.netcracker.libra.dao.StudentJDBC;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans.xml");

      StudentJDBC studentJDBC = 
      (StudentJDBC)context.getBean("studentJDBC");
      
      System.out.println("------Records Creation--------" );
      studentJDBC.create("Konstantin", "Kuyun", "disapp0int@gmail.com", "password");
      studentJDBC.create("Alexander", "Lebed", "lebed.alexander90@gmail.com", "password");
      studentJDBC.create("Alexandra", "Poletaeva", "poletaeva.sasha@gmail.com", "password");

      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = studentJDBC.listStudents();
      for (Student record : students) {
         System.out.print("ID: " + record.getId() );
         System.out.print(", Name: " + record.getName() );
         System.out.println(" " + record.getLastName());
         System.out.println("email: " + record.getEmail());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      studentJDBC.update(2, "Yuliya", "Sokhrannaya", "yuliya.sokh@gmail.com", "pass");

      System.out.println("----Listing Record with ID = 2 -----" );
      Student student = studentJDBC.getStudent(2);
      System.out.print("ID: " + student.getId() );
      System.out.print(", Name: " + student.getName() );
      System.out.println(" " + student.getLastName());
      System.out.println("email: " + student.getEmail());
	  
   }
}