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

import com.netcracker.libra.model.AppForm;
import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.service.RegisterService;
import com.netcracker.libra.util.mail.MailService;
import com.netcracker.libra.util.security.ConfirmationCodeGenerator;

@Controller
@RequestMapping("register")
@SessionAttributes({"confirmationCode", "registerForm", "appForm"})
public class RegController {
	
    @ModelAttribute("registerForm")
    public RegisterForm getRegisterForm() {
        return new RegisterForm();
    }
    
    @ModelAttribute("confirmationCode")
    public String generateCode() {
    	return ConfirmationCodeGenerator.generateCode();
    }
    
    @ModelAttribute("appForm") 
    public AppForm getAppForm() {
    	return new AppForm();
    }
 
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@ModelAttribute("registerForm") RegisterForm form, Map model) {
		model.put("registerForm", form);
		return "/signup/personal";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validateForm(@ModelAttribute("registerForm") @Valid RegisterForm form, @ModelAttribute("confirmationCode") String code, BindingResult result, ModelMap model) {
		
		 if (result.hasErrors()) {
	            return "redirect:/signup/personal";
	        }   
		 //MailService.sendMessage(form.getEmail(), form.getEmail(), code);
		 model.put("registerForm", form);
	        return "/signup/verify";
	    }
	
	@RequestMapping(value="proceed", method = RequestMethod.POST)
	public String verify(@ModelAttribute("confirmationCode") String code, @ModelAttribute("registerForm") RegisterForm form, BindingResult result) {
		System.out.println("Comparing "+code+" and "+ form.getEnteredCode());
		if (code.equals(form.getEnteredCode())) {
			//RegisterService.registerUser(form);
				return "/signup/appform";
		}
		else
			return "redirect:/signup/verify";
	}
	
	@RequestMapping(value = "appform", method = RequestMethod.GET)
	public String showAppform(@ModelAttribute("appForm") AppForm form, Map model) {
		model.put("appForm", form);
		return "/signup/appform";
	}
	
	@RequestMapping(value = "appform2", method = RequestMethod.POST)
	public String showNextForm(@ModelAttribute("appForm") AppForm form, Map model) {
		model.put("appForm", form);
		return "/signup/appform2";
	}
	
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("appForm") AppForm form, Map model, BindingResult result) {
		model.put("appForm", form);
		return "/signup/success";
	}
	
}
