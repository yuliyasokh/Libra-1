package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netcracker.libra.model.SignupForm;

@Controller
public class ApplicationFormController {
	
	@RequestMapping(value= "/application", method = RequestMethod.GET)
    public ModelAndView editAppForm() {
		
        return new ModelAndView("application", "signupForm", new SignupForm());
 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String success(Model model, SignupForm form, BindingResult result) {
		
		model.addAllAttributes(form.getAppForm());
		return "success";
	}
}
