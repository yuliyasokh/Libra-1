package com.netcracker.libra.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.Student;

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
   public String verify(@RequestParam String email, @RequestParam String password) {
 
	   if (StudentJDBC.verifyLogin(email, password) > 0)
		   return "loginSuccesful";
	   else
		   return "loginFailed";
	   
     }
}

