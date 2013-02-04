/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.HrJDBC;

import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.Student;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Yuliya
 */
@Controller
public class HRController {
           
     HrJDBC hr=new HrJDBC();
     Student s=new Student();
     /* 
     * Метод показывает всех студентов в БД
     */    
    @RequestMapping("/hr/showStudentbyIdView")
    public ModelAndView showStudentbyId()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showStudentbyIdView");
        List<Student> std=hr.listStudents();
        Iterator itr = std.iterator();
        while(itr.hasNext()){
            s = (Student) itr.next();
           }
        return new ModelAndView("hr/showStudentbyIdView","Model",std);
      }
  
    
    /**
     * Метод для осуществления поиска студентов по различным полям
     * @param textBox - строка поиска
     * @param filter - номер поля 
     * @return 
     */
      @RequestMapping(value="/hr/showStudentbyIdView", method= RequestMethod.POST)
      public ModelAndView showStudentByIdView(@RequestParam("textBox") String textBox, @RequestParam("filter") int filter){
      ModelAndView mav=new ModelAndView();
      if (filter==1){
                mav.setViewName("showStudentbyIdView");
                List<Student> std=hr.listStudents();
                Iterator itr = std.iterator();
                while(itr.hasNext()){
                    s = (Student) itr.next();
                }
                return new ModelAndView("hr/showStudentbyIdView","Model",std);
            }
      if (filter==2){
          try{
                int i=Integer.parseInt(textBox);
                List<Student> std =hr.getStudent(i);
                Iterator itr = std.iterator();
                while(itr.hasNext()){
                    s = (Student) itr.next();
                }
                return new ModelAndView("hr/showStudentbyIdView","Model",std);
                }
          catch(Exception ex){
              
          }
      }
      if (filter==3){
          try{
                List<Student> std =hr.getStudentsByFirstName(textBox);
                Iterator itr = std.iterator();
                while(itr.hasNext()){
                    s = (Student) itr.next();
                }
                return new ModelAndView("hr/showStudentbyIdView","Model",std);
            }
          catch(Exception ex){  
          }
      }
      
      if (filter==4){
          try{
                List<Student> std =hr.getStudentsByLastName(textBox);
                Iterator itr = std.iterator();
                while(itr.hasNext()){
                    s = (Student) itr.next();
                }
                return new ModelAndView("hr/showStudentbyIdView","Model",std);
            }
          catch(Exception ex){
              
          }
      }
      if (filter==5){
          try{
                List<Student> std =hr.getStudentsByEmail(textBox);
                Iterator itr = std.iterator();
                while(itr.hasNext()){
                    s = (Student) itr.next();
                }
                return new ModelAndView("hr/showStudentbyIdView","Model",std);
          }
          catch(Exception ex){
              
          }
      }
      return null;
        
    }

}

