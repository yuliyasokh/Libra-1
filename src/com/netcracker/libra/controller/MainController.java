package com.netcracker.libra.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.model.Fieldset;
import com.netcracker.libra.service.RegformService;

@Controller
public class MainController {
	
	@RequestMapping(value = "showAppForm/{userID}", method=RequestMethod.GET)
	public String showAppForm(@PathVariable Integer userID, ModelMap map) {
		map.addAttribute("form",RegformService.showAppFormById(userID));
		return "showAppForm";
	}
	
	@RequestMapping("main")
	public String showMainPage() {
		return "index2";
	}

	@RequestMapping(value = "/register/step2.html", method=RequestMethod.GET)
	public String test(ModelMap map, Fieldset fieldset) {
		AppFormJDBC app = new AppFormJDBC();
		map.put("form",app.queryForActiveTemplate());
		map.addAttribute("fieldset", new Fieldset());
		return "test";
	}
	
	@RequestMapping(value = "/register/step2.html", method=RequestMethod.POST)
	public String testPost(@ModelAttribute("fieldset") Fieldset fieldset) {
		
		return "test2";
	}
}
