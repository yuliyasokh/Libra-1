package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import com.netcracker.libra.model.Student;

@Controller
public class LoginController {

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("login", "command", new Student());
   }
   
   @RequestMapping(value = "/loginProceed", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, 
   ModelMap model) {
      model.addAttribute("email", student.getName());
      model.addAttribute("password", student.getPassword());
      
      return "loginProceed";
   }
}
