package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.netcracker.libra.model.SignupForm;

@Controller
@RequestMapping("/signup")
@SessionAttributes("appForm")
public class ApplicationFormController {
	
/*	
 * @RequestMapping("")
	public String start(ModelMap model) {
		model.put("appForm", new SignupForm());
		return "redirect:/signup/personal.html";
	}
	
	@RequestMapping("personal")
	public String collectPersonalData(@ModelAttribute("appForm") SignupForm form) {
		return "/signup/personal";
	}
	
	@RequestMapping(value = "personal", method=RequestMethod.PUT)
	public String savePersonalData(@ModelAttribute("appForm") SignupForm form, BindingResult result) {
		result.recordSuppressedField("name");
		result.recordSuppressedField("lastName");
		result.recordSuppressedField("email");
		result.recordSuppressedField("phoneNumber");
		if (result.hasErrors()) 
			return "/signup/personal";
		
		return "redirect:/contacts"; 
	}
*/	
	@RequestMapping("contacts")
	public String collectContactsData(@ModelAttribute("appForm") SignupForm form) {
		return "/signup/contacts";
	}
	
	@RequestMapping(value = "contacts", method=RequestMethod.PUT)
	public String saveContactsData(@ModelAttribute("appform") SignupForm form, BindingResult result) {

		if (result.hasErrors()) 
			return "/signup/contacts";
		
		return "redirect: /signup/interests.html"; 
	}
	
	@RequestMapping("interests")
	public String collectInterestsData(@ModelAttribute("appForm") SignupForm form) {
		return "/signup/interests";
	}
	
	@RequestMapping(value = "interests", method=RequestMethod.PUT)
	public String saveInterestsData(@ModelAttribute("appform") SignupForm form, BindingResult result) {

		if (result.hasErrors()) 
			return "/signup/interests";
		
		return "redirect: /signup/advantages.html"; 
	}
	
	@RequestMapping("advantages")
	public String collectAdvantagesData(@ModelAttribute("appForm") SignupForm form) {
		return "/signup/advantages";
	}
	
	@RequestMapping(value = "advantages", method=RequestMethod.PUT)
	public String saveAdvantagesData(@ModelAttribute("appform") SignupForm form, BindingResult result) {

		if (result.hasErrors()) 
			return "/signup/advantages";
		
		return "redirect: /signup/review.html"; 
	}
	
	@RequestMapping("review")
	public String submit(@ModelAttribute("appForm") SignupForm form, SessionStatus status) {
		status.setComplete();
		return("/signup/review");
	}
	
	/*@ExceptionHandler(HttpSessionRequiredException.class)
	public String restart() {
		return "redirect:/signup/step1.html";
	}
	
	*/
	
	
	
	/*
	 * DEPRECATED
	 * 
	 * @RequestMapping(value= "/signup", method = RequestMethod.GET)
    public ModelAndView editAppForm() {
		
        return new ModelAndView("application", "signupForm", new SignupForm());
 
	}
	
	@RequestMapping(value= "/appform", method = RequestMethod.GET)
    public ModelAndView createAppform() {
		
        return new ModelAndView("appform_templated", "signupForm", new SignupForm());
 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String nextStep(Model model, SignupForm form, BindingResult result) {
		model.addAllAttributes(form.getAppForm());
		return "step2";
	}
	
	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public String success(Model model, SignupForm form, BindingResult result) {
		model.addAllAttributes(form.getAppForm());
		return "success";
	}
	*/
}
