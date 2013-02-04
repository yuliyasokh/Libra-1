/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.InterviewDateJDBC;
import com.netcracker.libra.model.InterviewDate;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Yuliya
 */
@Controller
public class InterviewDateController {
    InterviewDate iDate=new InterviewDate();
    InterviewDateJDBC iDateJdbc = new InterviewDateJDBC();
    
    @RequestMapping("/hr/interviewDate")
    public ModelAndView interDate()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("interviewDate");
        List<InterviewDate> id=iDateJdbc.getAllInterviewDates();
        Iterator itr = id.iterator();
        while(itr.hasNext()){
            iDate = (InterviewDate) itr.next();
           }
        return new ModelAndView("hr/interviewDate","Model",id);
      }
}
