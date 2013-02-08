package com.netcracker.libra.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.libra.model.RegisterForm;

@Controller
@RequestMapping("register")
public class RegController {
	
    @ModelAttribute("registerForm")
    public RegisterForm getLoginForm() {
        return new RegisterForm();
    }

		
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		return("/signup/personal");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validateForm(@ModelAttribute("registerForm") @Valid RegisterForm form, BindingResult result, ModelMap model) {
		
		 if (result.hasErrors()) {
	            return "signup/personal";
	        }   
		 	
		 model.put("registerForm", form);
	        return "/signup/verify";
	    }
	}
