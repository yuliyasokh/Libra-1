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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Yuliya
 */
@Controller
public class InterviewDateController 
{    
   
    InterviewDate iDate=new InterviewDate();
    InterviewDateJDBC iDateJdbc = new InterviewDateJDBC();
    
    @RequestMapping("/hr/interviewDate")
    public ModelAndView interDate()
    {
        ModelAndView mav = new ModelAndView();
        List<InterviewDate> id=iDateJdbc.getAllInterviewDatesWithInterviewers();  
        List<Map<String,Object>> inters=iDateJdbc.getInterviewers();
        mav.setViewName("hr/interviewDate");
        mav.addObject("Model",id);
        mav.addObject("Inters",inters);
        return mav;
     }
    /**
     * 
     * @param begin
     * @param end
     * @param duration
     * @param interviewers
     * @return 
     */
      @RequestMapping(value="hr/interviewDate", method= RequestMethod.POST)
      public ModelAndView addInterviewDate(@RequestParam("begin") String begin,
      @RequestParam("end") String end,  
      @RequestParam("timeStart") String timeStart,
      @RequestParam("duration") int duration,
      @RequestParam("checkInterviewers[]") int [] interviewers){
            ModelAndView mav=new ModelAndView(); 
            iDateJdbc.createInterviewDate(begin+" "+timeStart,begin+" "+end, duration);
            for (int i=0;i<interviewers.length;i++){
                iDateJdbc.insertInterviewers(interviewers[i]);
            }
            List<InterviewDate> id=iDateJdbc.getAllInterviewDatesWithInterviewers();  
            List<Map<String,Object>> inters=iDateJdbc.getInterviewers();
            mav.addObject("Model",id);
            mav.addObject("Inters",inters);      
            mav.setViewName("hr/interviewDate");
            return mav;
      }
      
    @RequestMapping(value="hr/editInterviewDate", method= RequestMethod.GET)
    public ModelAndView editDate(@RequestParam("interviewDateId") int interviewDateId
            ){
        ModelAndView mav = new ModelAndView();
        try{
        List<Map<String,Object>> uncheckedInters=iDateJdbc.getInterviewersNotInInterview(interviewDateId);
        List<Map<String,Object>> checkedInters = iDateJdbc.getInterviewersById(interviewDateId);
        mav.addObject("d", iDateJdbc.getInterviewDateById(interviewDateId));
        mav.addObject("uncheckedInters",uncheckedInters);  
        mav.addObject("checkedInters", checkedInters);    
        mav.setViewName("hr/editInterviewDate");
        iDateJdbc.deleteFromInterviewerList(interviewDateId);
        }
        catch(Exception e){}
        return mav;
    }
   /**
    * 
    * @param interviewDateId
    * @param dateInter
    * @param timeInter
    * @param interviewDuration
    * @param interviewers
    * @return 
    */

    @RequestMapping(value="hr/doneDate",method= RequestMethod.POST)
    public ModelAndView doneDate(@RequestParam("interviewDateId") int interviewDateId,
    @RequestParam("dateInter") String dateInter,
    @RequestParam("timeInter") String timeInter,
    @RequestParam("interviewDuration") int interviewDuration,
    @RequestParam("checkInterviewers[]") int[] interviewers){
       
        ModelAndView mav = new ModelAndView();
         try{
        String[] str_time=timeInter.split(" - ");
        iDateJdbc.deleteFromInterviewerList(interviewDateId);
        iDateJdbc.updateInterviewDateByDateId(interviewDateId, dateInter+" "+str_time[0], dateInter+" "+str_time[1], interviewDuration);
        for (int i=0;i<interviewers.length;i++){
                iDateJdbc.insertInterviewersAndDates(interviewers[i],interviewDateId);
            }
         }
         catch(Exception e){}
        return mav;
    }    

    @RequestMapping(value="hr/delInterviewDate", method= RequestMethod.GET)
    public ModelAndView delDate(@RequestParam("interviewDateId") int interviewDateId){
        ModelAndView mav = new ModelAndView();
        iDateJdbc.deleteInterviewDateByAppId(interviewDateId);
        return mav;
    } 

    
}
