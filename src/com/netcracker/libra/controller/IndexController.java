package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netcracker.libra.model.SignupForm;
 
@Controller
public class IndexController {
 
	@RequestMapping(value= "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
		
        return new ModelAndView("signup", "signupForm", new SignupForm());
 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String success(Model model, SignupForm form, BindingResult result) {
		
		model.addAttribute("name", form.getName());
		model.addAttribute("lastName", form.getLastName());
		model.addAttribute("email", form.getEmail());
		return "success";
	}
	
	/*@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model model, BindingResult result) {
		
		model.addAttribute("id", result.getFieldValue("id"));
		return "result";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public String get(Model model, BindingResult result) {
		
		model.addAttribute("id", result.getFieldValue("id"));
		return "result";
	}
 */
}