/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.InterviewDateJDBC;
import com.netcracker.libra.dao.InterviewJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.InterviewDateInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Сашенька
 */
@Controller
public class InterviewController
{
    InterviewDateJDBC interviewDateJDBC=new InterviewDateJDBC();
    InterviewJDBC interviewJDBC=new InterviewJDBC();
    
    @Autowired
    UserPreferences userPreferences;
        
    @RequestMapping("showInterviewDate")
    public ModelAndView showInterviewDate()
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==0)
        {
            List<InterviewDateInfo> ilist=interviewDateJDBC.getFreePlaces();
            mav.addObject("interviewDates", ilist);
            try
            {
                mav.addObject("requestDate", interviewJDBC.getRequestInterviewDate(userPreferences.UserId));
            }
            catch(EmptyResultDataAccessException e)
            {                
            }
            try
            {
                mav.addObject("interviewDate", interviewJDBC.getInterviewDateByAppId(userPreferences.UserId));
            }
            catch(EmptyResultDataAccessException e)
            {
                mav.addObject("interviewDate",-1);
            }
            mav.setViewName("showInterviewDateView");       
            return mav;
        }
        else
        {
          return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");        
        }
    }
    
    @RequestMapping(value="chooseDate", method= RequestMethod.POST)
    public ModelAndView chooseDatePost(@RequestParam("selDate") int selDate)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==0)
        {
            if(interviewDateJDBC.exists(selDate)>0)
            {
                interviewJDBC.add(selDate, userPreferences.UserId, 1);
                List<InterviewDateInfo> ilist=interviewDateJDBC.getFreePlaces();
                mav.addObject("interviewDates", ilist);
                try
                {
                    mav.addObject("requestDate", interviewJDBC.getRequestInterviewDate(userPreferences.UserId));
                }
                catch(EmptyResultDataAccessException e)
                {
                    mav.addObject("interviewDate",-1);
                }
                try
                {
                    mav.addObject("interviewDate", interviewJDBC.getInterviewDateByAppId(userPreferences.UserId));
                }
                catch(EmptyResultDataAccessException e)
                {
                    mav.addObject("interviewDate",-1);
                }
                mav.setViewName("showInterviewDateView");       
                return mav;
            }
            else
            {
                return message("<a href='/Libra/'>Вернуться назад</a>","Такой даты не существует","Ошибка");      
            }
        } 
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");       
        }
    }
    
    @RequestMapping(value="changeDate", method= RequestMethod.POST)
    public ModelAndView changeDatePost(@RequestParam("selDate") int selDate)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==0)
        {
            if(interviewDateJDBC.exists(selDate)>0)
            {
                //If exists request
                int c=interviewJDBC.exists0(userPreferences.UserId);
                if(c>0)
                {
                    //if selDate=InterviewDateId whith statys=1
                    if(interviewJDBC.exists(selDate, userPreferences.UserId)>0)
                    {
                        //delete request
                        interviewJDBC.deleteRequest(userPreferences.UserId);
                    }
                    else
                    {
                        //update request
                        interviewJDBC.updateRequest(userPreferences.UserId,selDate);
                    }
                }
                else// if doesn't exist request
                {
                    //if selDate != current date
                    if(interviewJDBC.exists(selDate, userPreferences.UserId)==0)
                    {
                        //addRequest
                        interviewJDBC.add(selDate, userPreferences.UserId, 0);
                    }
                }
                List<InterviewDateInfo> ilist=interviewDateJDBC.getFreePlaces();
                mav.addObject("interviewDates", ilist);
                try
                {
                    mav.addObject("requestDate", interviewJDBC.getRequestInterviewDate(userPreferences.UserId));
                }
                catch(EmptyResultDataAccessException e)
                {
                    mav.addObject("interviewDate",-1);
                }
                try
                {
                    mav.addObject("interviewDate", interviewJDBC.getInterviewDateByAppId(userPreferences.UserId));
                }
                catch(EmptyResultDataAccessException e)
                {
                    mav.addObject("interviewDate",-1);
                }
                mav.setViewName("showInterviewDateView");       
                return mav;
            }
            else
            {
                mav.setViewName("messageView");
                mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
                mav.addObject("message","У Вас нету прав на эту страницу");
                mav.addObject("title","Ошибка");
                return mav;
            }
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
