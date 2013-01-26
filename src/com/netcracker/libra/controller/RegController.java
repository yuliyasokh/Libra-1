package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.registration.regData;

@Controller
public class RegController {
	
	 StudentJDBC st = new StudentJDBC();
		
	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public ModelAndView register() {
	      return new ModelAndView("registration", "command", new Student());
	   }
	   
	   @RequestMapping(value = "/registration", method = RequestMethod.POST)
	   public String createUser(@ModelAttribute("Student") Student regData, BindingResult result) {
		  
		  st.create(regData.getName(), regData.getLastName(), regData.getEmail(), regData.getPassword());
		  return "RegsuccessView";
	   }
	
}
