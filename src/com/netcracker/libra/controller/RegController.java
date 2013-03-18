package com.netcracker.libra.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.model.Fieldset;
import com.netcracker.libra.model.FilledAppForm;
import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.service.RegformService;
import com.netcracker.libra.service.RegisterService;
import com.netcracker.libra.util.security.ConfirmationCodeGenerator;
import com.netcracker.libra.util.security.Security;

@Controller
@RequestMapping("register")
@SessionAttributes({"confirmationCode", "regForm"})
public class RegController {
	
    @ModelAttribute("regForm")
    public RegisterForm getRegisterForm() {
        return new RegisterForm();
    }
    
    @ModelAttribute("confirmationCode")
    public String generateCode() {
    	return ConfirmationCodeGenerator.generateCode();
    }
 
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@ModelAttribute("regForm") RegisterForm form, ModelMap model) {
		model.put("regForm", form);
		model.put("uniList", RegformService.getUniversityList());
		model.put("facList", RegformService.getFacultyList());
		model.put("deptList", RegformService.getDepartmentList());
		return "/signup/appform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validateForm(MultipartFile photo, 
			@ModelAttribute("regForm") @Valid RegisterForm form,
							BindingResult result, 
							ModelMap model) {
		
		String orgName = photo.getOriginalFilename();
		String filePath = (Security.getMD5hash(((RegisterForm) model.get("regForm")).getEmail())+".png");
        File dest = new File(filePath);
        
        try {
            photo.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "File uploaded failed:" + orgName;
        } catch (IOException e) {
            e.printStackTrace();
            return "File uploaded failed:" + orgName;
        }
		
		 if (result.hasErrors()) {
			 for (ObjectError x : result.getAllErrors())
			 System.out.println(x.toString());
	            return "redirect:register.html";
	        }
		 else
		 //MailService.sendMessage(form.getEmail(), form.getEmail(), code);
		 model.put("regForm", form);
	        return "redirect:/register/step2.html";
	    }

}
