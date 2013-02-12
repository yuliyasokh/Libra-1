/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.model.Student;
import com.netcracker.libra.util.mail.MailService;
import com.netcracker.libra.util.mail.data;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author MorrDeck
 */
@Controller

public class SendMailController  {
    
           @RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	   public ModelAndView sendView() {
	      return new ModelAndView("SendMailView", "command", new data());
	   }
           
           @RequestMapping(value = "/sendmailsubmit", method = RequestMethod.POST)
           public String sendMail(@ModelAttribute("data") data Data, ModelMap model){
               
               MailService.sendConfirmRegistrationMessage(Data.getAdress(), Data.getUser(), Data.getCode());
               MailService.sendSuccessRegistrationMessage(Data.getAdress(), Data.getUser());
               MailService.sendFormMessage(Data.getAdress(), Data.getUser(),3);
               return "SuccessSendView";
           }
}
