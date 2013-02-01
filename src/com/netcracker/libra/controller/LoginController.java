package com.netcracker.libra.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.util.security.Security;

@Controller
public class LoginController {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login() {
      return new ModelAndView("login", "command", new Student());
   }
   
   @RequestMapping(value = "/submit", method = RequestMethod.POST)
   public String verify(@ModelAttribute("Student") Student student) {
 
	   if (StudentJDBC.verifyLogin(student.getEmail(), Security.getMD5hash(student.getPassword())) == 1)
		   return "loginSuccesful";
	   else
		   return "loginFailed";
	   
     }
}

