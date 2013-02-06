/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.dao.InterviewDateJDBC;
import com.netcracker.libra.model.InterviewDate;
import com.netcracker.libra.model.InterviewDateInfo;
//import com.netcracker.libra.model.InterviewDate;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sashenka
 */
@Controller
public class InterviewDateController 
{
    InterviewDateJDBC interviewDateJDBC=new InterviewDateJDBC();
    
    @RequestMapping("showInterviewDate")
    public ModelAndView showTopics()
    {
        ModelAndView mav = new ModelAndView();
        List<InterviewDateInfo> ilist=interviewDateJDBC.getFreePlaces();
//        Format dateFormat;
  //      dateFormat = new SimpleDateFormat("dd MMM yyyy HH mm ss Z");
//Date date = new Date();
//String newDateString = dateFormat.format(date);
        //String ds=ilist.get(1).getDatestart().getMonth();
   //     int i= ilist.get(1).getDateStart().getMonth();
        mav.addObject("interviewDates", ilist);
        mav.setViewName("showInterviewDateView");       
        return mav;
    }
    
   /**
 *
 * @author Yuliya
 */
    
    InterviewDate iDate=new InterviewDate();
    InterviewDateJDBC iDateJdbc = new InterviewDateJDBC();
    
    @RequestMapping("/hr/interviewDate")
    public ModelAndView interDate()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("interviewDate");
        List<InterviewDate> id=iDateJdbc.getAllInterviewDatesWithInterviewers();  
        return new ModelAndView("hr/interviewDate","Model",id);
      }
}
