/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.InterviewResultsJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.InterviewResult;
import com.netcracker.libra.model.InterviewResultsInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sashenka
 */
@Controller
public class InterviewResultsController 
{
    @Autowired
    UserPreferences userPreferences;
    InterviewResultsJDBC iresults=new InterviewResultsJDBC();
    int InterviewId;
    @RequestMapping(value="addResult", method= RequestMethod.GET)
    public ModelAndView addResult(@RequestParam("InterviewId") int InterviewId)
    {
        if(userPreferences.accessLevel==1 || userPreferences.accessLevel==2 )
        {
            if(iresults.exists(InterviewId)==0)
            {
                return message("<a href='/Libra/'>Вернуться назад</a>","Такого интервью нету","Ошибка");
            }
            this.InterviewId=InterviewId;
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addResultView");       
            List<InterviewResult> intres=iresults.getResult(InterviewId);
            mav.addObject("existsComment", iresults.existsComment(userPreferences.UserId, InterviewId));
            mav.addObject("userId", userPreferences.UserId);
            mav.addObject("interviewResult",intres);
            mav.addObject("InterviewId", InterviewId);
            return mav; 
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    @RequestMapping(value="addResultSubmit", method= RequestMethod.POST)
    public ModelAndView addResultSubmit(@RequestParam("mark") int mark,
    @RequestParam("comment") String comment)
    {
        if(userPreferences.accessLevel==1 || userPreferences.accessLevel==2)
        { 
            iresults.addResult(InterviewId, userPreferences.UserId, mark, comment);        
            return showResults();  
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    @RequestMapping(value="updateResultSubmit", method= RequestMethod.POST)
    public ModelAndView updateResultSubmit(@RequestParam("mark") int mark,
    @RequestParam("comment") String comment)
    {
        if(userPreferences.accessLevel==1 || userPreferences.accessLevel==2)
        {         
            iresults.updateResult(InterviewId, userPreferences.UserId, mark, comment);
            return  showResults();
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    @RequestMapping("showResults")
    public ModelAndView showResults()
    {
        if(userPreferences.accessLevel==1 || userPreferences.accessLevel==2)
        {
            ModelAndView mav = new ModelAndView();
            List<InterviewResultsInfo> inf=iresults.getInfo();
            mav.addObject("showStudents", inf);
            mav.setViewName("showResultsView");        
            return mav; 
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    @RequestMapping(value="deleteResult", method= RequestMethod.GET)
    public ModelAndView delResultSubmit(@RequestParam("interviewId") int interviewId)
    {
        if(userPreferences.accessLevel==1 || userPreferences.accessLevel==2)
        {
            iresults.deleteResult(interviewId,userPreferences.UserId);
            return  showResults();
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    public ModelAndView message(String link,String message,String title)
    {
         ModelAndView mav=new ModelAndView();
         mav.setViewName("messageView");
         mav.addObject("link",link);
         mav.addObject("message",message);
         mav.addObject("title",title);
         return mav;
    }
}
