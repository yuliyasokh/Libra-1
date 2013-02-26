
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.HrJDBC;
import com.netcracker.libra.model.Department;
import com.netcracker.libra.model.Faculty;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.University;
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
     
    @RequestMapping(value="hr/faculty", method= RequestMethod.POST)
     public ModelAndView myTest(@RequestParam("universityId") int universityId){
        List<Faculty> fact=hr.getAllFaculties(universityId);
            return new ModelAndView("hr/faculty","fact",fact);
        }
     
    @RequestMapping(value="hr/department", method= RequestMethod.POST)
     public ModelAndView myDept(@RequestParam("facultyId") int facultyId){
            List<Department> departments=hr.getAllDepartments("f.facultyId", facultyId);
            return new ModelAndView("hr/department","dept",departments);
        }
    
    @RequestMapping("/hr/showStudentbyIdView")
    public ModelAndView showStudentbyId(){
        List<Student> std=hr.listStudents();
        return new ModelAndView("hr/showStudentbyIdView","Model",std);
      }
  
    /**
     *
     * @return
     */
    /*
     * Show all students of All Universities
     */
   @RequestMapping(value = "/hr/showStudentByEducation")
    public ModelAndView showAllStudent(){
        ModelAndView mav = new ModelAndView();
        List<Student> std=hr.listStudents();
        List<University> universities;
        universities= hr.getAllUniversity();
        mav.addObject("Model",std);
        mav.addObject("univers",universities);
        mav.setViewName("hr/showStudentByEducation");
        return mav;
    }
   
   /**
    * Find students by University, Faculty or Department
    * @param universityId
    * @param facultyId
    * @param departmentId
    * @return list os Students and list of University
    */
    @RequestMapping(value="/hr/showStudentByEducation", method=RequestMethod.POST)
    public ModelAndView showStudentsByEd(@RequestParam("univ") int universityId,
    @RequestParam("fact") int facultyId,
    @RequestParam("dept") int departmentId){
        ModelAndView mav = new ModelAndView();
       
        List<University> universities= hr.getAllUniversity();
        mav.addObject("univers",universities);
        List<Student> std=null;
        if (facultyId==0){
           std = hr.getStudentByUniversity(universityId);
        }
        else 
            if (departmentId==0){
                std = hr.getStudentByFaculty(facultyId);
            }
            else{ 
                std = hr.getStudentByDepartment(departmentId);
            }
        mav.addObject("Model",std);
        mav.setViewName("hr/showStudentByEducation");
        return mav;
       
        }   
    
    /**
     * Find students by ID, email, firstname or lastname
     * @param textBox - key phrase
     * @param filter - search criteria
     * @return list of Students
     */
      @RequestMapping(value="/hr/showStudentbyIdView", method= RequestMethod.POST)
      public ModelAndView showStudentByIdView(@RequestParam("textBox") String textBox, @RequestParam("filter") int filter){
          ModelAndView mav = new ModelAndView();
          mav.setViewName("hr/showStudentbyIdView");
          mav.addObject("textBox", textBox);
          mav.addObject("filterInt", filter);
          if (textBox.equals("") && (filter!=1)){
              mav.addObject("msg", "Input data for search!");
              return mav;
          }
          List<Student> std=null;
          try{
            if (filter==1){
                    std=hr.listStudents();              
                    }
            if (filter==2){
                    int i=Integer.parseInt(textBox);
                    std=hr.getStudent(i);
                    } 
            if (filter==3){
                   std =hr.getStudentsByFirstName(textBox);
                    }
            if (filter==4){
                   std =hr.getStudentsByLastName(textBox);
                    }
            if (filter==5){
                   std =hr.getStudentsByEmail(textBox);
                    }
            mav.addObject("Model",std);
          }
          catch(Exception ex){
            mav.addObject("msg","Input data is not in correct format! Try again!");   
          }
          if (std.isEmpty()){
              mav.addObject("msg1", "Студенты не найдены.");
          }
          return mav;
    }
     
    

}

