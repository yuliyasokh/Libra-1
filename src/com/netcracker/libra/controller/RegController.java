package com.netcracker.libra.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.util.security.ConfirmationCodeGenerator;

@Controller
@RequestMapping("register")
@SessionAttributes({"confirmationCode", "registerForm"})
public class RegController {
	
    @ModelAttribute("registerForm")
    public RegisterForm getLoginForm() {
        return new RegisterForm();
    }
    
    @ModelAttribute("confirmationCode")
    public String generateCode() {
    	return ConfirmationCodeGenerator.generateCode();
    }

		
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@ModelAttribute("registerForm") RegisterForm form, Map model) {
		model.put("registerForm", form);
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
	
	@RequestMapping(value="validate", method = RequestMethod.POST)
	public String verify(@ModelAttribute("confirmationCode") String code, @ModelAttribute("registerForm") RegisterForm form, BindingResult result) {
		System.out.println("Comparing "+code+" and "+ form.getEnteredCode());
		if (code.equals(form.getEnteredCode()))
				return "/signup/interests";
		else
			return "redirect:/signup/verify";
	}
}
