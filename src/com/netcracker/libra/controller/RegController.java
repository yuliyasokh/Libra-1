package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.registration.RegistrationService;
import org.springframework.ui.ModelMap;

/**
 * 
 * @author MorrDeck
 */

@Controller
public class RegController {
		
	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public ModelAndView register() {
	      return new ModelAndView("RegView", "command", new Student());
	   }
	   
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("Student") Student regData, ModelMap model) {
        if (RegistrationService.checkName(regData.getName())
                && RegistrationService.checkSurname(regData.getLastName())
                && RegistrationService.checkEmail(regData.getEmail())
                && RegistrationService.checkPassword(regData.getPassword())) {
            String MD5Password = com.netcracker.libra.util.security.Security.getMD5hash(regData.getPassword());
            StudentJDBC st = new StudentJDBC();
            st.create(regData.getName(), regData.getLastName(), regData.getEmail(), MD5Password);
            model.addAttribute("name", regData.getName());
            model.addAttribute("lastname", regData.getLastName());
            model.addAttribute("email", regData.getEmail());
            model.addAttribute("password", regData.getPassword());
            return "RegsuccessView";
        } else {
            String err = "";
            if(!RegistrationService.checkName(regData.getName())){
                err += "Неправильно указано имя!\n";
            }
            if(!RegistrationService.checkSurname(regData.getLastName())){
                err += "Неправильно указана фамилия!\n";
            }
            if(!RegistrationService.checkEmail(regData.getEmail())){
                err += "Неправильно указан почтовый адрес!\n";
            }
            if(!RegistrationService.checkPassword(regData.getPassword())){
                err += "Пароль не отвечает требованиям!\n";
            }
            model.addAttribute("error", err);
            return "RegFailedView";
            
        }
    }
	
}
