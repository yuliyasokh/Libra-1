/*package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.netcracker.libra.model.FilledAppForm;
import com.netcracker.libra.service.BlockService;
import com.netcracker.libra.service.RegisterService;

@Controller
@RequestMapping("test")
@SessionAttributes("filledAppForm")
public class MainController {
	
	@ModelAttribute("filledAppForm")
	public void createEmptyForm(Model map) {
		map.addAttribute("filledAppForm", new FilledAppForm());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String renderTestPage(@ModelAttribute("filledAppForm") FilledAppForm form, Model map) {
	
		map.addAttribute("checkbox", BlockService.retrieveCheckboxBlocks());
		map.addAttribute("textFields", BlockService.retrieveTextFieldBlocks());
		map.addAttribute("grade", BlockService.retrieveGradeBlocks());
		
		return "test";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showAnswers(@ModelAttribute("filledAppForm") FilledAppForm form, BindingResult result) {
		System.out.println("Send to Service");
		System.out.println(form.getTextFieldsAnswers().values().toString());
		RegisterService.fillAppForm(form);
		return "showAnswers";
	}
}
*/