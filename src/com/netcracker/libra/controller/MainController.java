package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.libra.service.FormService;

@Controller
public class MainController {
	
	@RequestMapping(value = "showAppForm/{userID}", method=RequestMethod.GET)
	public String showAppForm(@PathVariable Integer userID, ModelMap map) {
		map.addAttribute("form",FormService.showAppFormById(userID));
		return "showAppForm";
	}
	
	@RequestMapping("main")
	public String showMainPage() {
		return "index2";
	}
}
