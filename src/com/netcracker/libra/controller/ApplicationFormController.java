/*package com.netcracker.libra.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.netcracker.libra.model.AppForm;

@Controller
@RequestMapping("signup")
@SessionAttributes("appForm")
public class ApplicationFormController {
	
	@RequestMapping("")
	public String start(ModelMap model) {
		model.put("appForm", new AppForm());
		return "redirect:/signup/interests.html";
	}
	
	@RequestMapping("interests")
	public String collectData(@ModelAttribute("appForm") AppForm form) {
		return "/signup/interests";
	}
	
	@RequestMapping(value = "interests", method=RequestMethod.PUT)
	public String savePersonalData(@ModelAttribute("appForm") @Valid AppForm form, BindingResult result) {

		if (result.hasErrors()) 
			return "/signup/interests";
		
		return "redirect:/signup/contacts"; 
	}
	
}*/
