
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.HrJDBC;
import com.netcracker.libra.model.DateAndInterviewer;
import com.netcracker.libra.model.DateAndInterviewerResults;
import com.netcracker.libra.model.Department;
import com.netcracker.libra.model.Faculty;
import com.netcracker.libra.model.InterviewResults;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.University;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ModelAndView mav = new ModelAndView();
        mav.addObject("Model", std);
        mav.addObject("direction","asc");
        mav.addObject("orderBy","appId");
        mav.setViewName("hr/showStudentbyIdView");
        return mav;
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
      public ModelAndView showStudentByIdView(@RequestParam("textBox") String textBox, 
      @RequestParam("filter") int filter){
          ModelAndView mav = new ModelAndView();
          mav.setViewName("hr/showStudentbyIdView");
          mav.addObject("textBox", textBox);
          mav.addObject("direction","asc");
          mav.addObject("orderBy","appId");
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
            if (filter==6){
                std = hr.getStudentsByAllFields(textBox);
            }
            mav.addObject("Model",std);
          }
          catch(Exception ex){
            mav.addObject("msg","Input data is not in correct format! Try again!");   
         }
       /*   if (std.isEmpty()){
              mav.addObject("msg1", "Студенты не найдены.");
          }*/
          return mav;
    }
      
      @RequestMapping(value = "/hr/sortedBy", method = RequestMethod.GET)
      public ModelAndView sortedby( 
      org.springframework.web.context.request.WebRequest webRequest
       ){
          String orderBy = webRequest.getParameter("orderBy");
          String direction = webRequest.getParameter("direction");
          String textBox = webRequest.getParameter("textBox");
          String filter = webRequest.getParameter("filter");
          ModelAndView mav = new ModelAndView();
          List<Student> std=null;
          switch(filter){
              case("2"): 
                  std = hr.getOrderStudent("appId", textBox, orderBy);
                            break;
              case("3"): std = hr.getOrderStudent("firstName", textBox, orderBy);
                            break;
              case("4"): std = hr.getOrderStudent("lastName", textBox, orderBy);
                            break;
              case("5"): std = hr.getOrderStudent("email", textBox, orderBy);
                            break;
              case("6"): std = hr.getOrderStudent("allFields", textBox, orderBy);
                            break;
              default: std = hr.getOrderStudent("getAll", textBox, orderBy);   
                            break;
          } 
          mav.addObject("textBox", textBox);
          mav.addObject("filterInt", filter);
          mav.addObject("Model", std);
          mav.setViewName("hr/showStudentbyIdView");
          return mav;
      }
      
      @RequestMapping(value = "/hr/sortedByEducation", method = RequestMethod.GET)
      public ModelAndView sortedbyEdu( 
      org.springframework.web.context.request.WebRequest webRequest
       ){
          String orderBy = webRequest.getParameter("orderBy");
          String direction = webRequest.getParameter("direction");
          String universityId = webRequest.getParameter("universityId");
          String facultyId = webRequest.getParameter("facultyId");
          String departmentId = webRequest.getParameter("departmentId");
          ModelAndView mav = new ModelAndView();
          List<Student> std=null;
          if (universityId.equals("")){
              std = hr.getOrderStudent("getAll", "bla", orderBy);
          }
          else{ 
          if ((!universityId.equals("0")) && (facultyId.equals("0"))){
               std = hr.getOrderedStudentByEdu("universityId", universityId, orderBy);
            } else {
              if ((!facultyId.equals("0")) && (departmentId.equals("0"))){
                  std = hr.getOrderStudent("facultyId", facultyId, orderBy);
              }
              else {
                  if (!departmentId.equals("0")){
                      std = hr.getOrderStudent("departmentId", departmentId, orderBy);
                  }
                  else {
                      std = hr.getOrderStudent("getAll", "bla", orderBy);
                  }
              }        
          }
          }
          mav.addObject("Model", std);
          mav.setViewName("hr/showStudentByEducation");
          return mav;
      }
      

      /**
       * Displays information about the student's interview.
       * @author Alexander Lebed
       */
      @RequestMapping("hr/showStudentInterview")
      public ModelAndView showStudentInterview(
                            @RequestParam("appId") int appId,
                            @RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("view") int view) {
          
          //these values will be passed to the results page
          String notAssigned = "";
          String wasAbsent = "";
          List dateAndInterviewerList = new ArrayList();
          List dateAndInterviewerResultsList = new ArrayList();
          
          HrJDBC hrjdbc = new HrJDBC();
          List <Integer> interviewIds = hrjdbc.getInterviewIds(appId);
          
          if(interviewIds.isEmpty()) {
              //if no any information about the interview, displayed the message
              notAssigned = "Студент "+ firstName +" "+ lastName +" не записался на интервью";
          }
          
          for(Integer id : interviewIds) {
              
              int interviewId = id;
              //string of interview's finish date and time
              String interviewDateFinish = hrjdbc.getInterviewFinishDate(interviewId);
              boolean wasInterviewed = hrjdbc.getInterviewResults(interviewId);
              
              if(actualInterview(interviewDateFinish)) {
                  //else if the student will be interviewed, diplayed application's form ID, 
                  //interview's date and time, assigned interviewers
                  List <DateAndInterviewer> resultList = hrjdbc.getDateAndInterviewer(interviewId);
                  dateAndInterviewerList.addAll(resultList);
              }
              else if(wasInterviewed) {
                  //else if the student was interviewed, displayed the application's form ID, date and time of the interview, 
                  //assigned interviewers, results of the interview (marks, comments)
                  List <DateAndInterviewerResults> resultList = hrjdbc.getDateAndInterviewerResults(interviewId);
                  dateAndInterviewerResultsList.addAll(resultList);
              }
              else {
                  //else if the interview have been assigned but the student didn't come, displayed the corresponding message
                  wasAbsent += "Студент "+ firstName +" "+ lastName +" не явился на интервью\n";
              }
          }

          ModelAndView mv = new ModelAndView();
          mv.setViewName("hr/showStudentInterviews");
          mv.addObject("view", view); // 0 if redirected from showStudentbyIdView.jsp, 1 - from showStudentByEducation.jsp
          mv.addObject("notAssigned", notAssigned);
          mv.addObject("dateAndInterviewerList", dateAndInterviewerList);
          mv.addObject("dateAndInterviewerResultsList", dateAndInterviewerResultsList);
          mv.addObject("wasAbsent", wasAbsent);
          return mv;
      }

      /**
       * @return true if the interview will be; false - if it was
       */
      public boolean actualInterview(String interviewDateFinish) {
          SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
          Date sqlDate = null;
          try {
             //forms the date based on the date-string and date-format
             sqlDate = df.parse(interviewDateFinish);
          } catch (ParseException ex) {
              Logger.getLogger(HRController.class.getName()).log(Level.SEVERE, null, ex);
          }
          Date current = new Date();
          return current.before(sqlDate);
      }
      
      /**
       * @return true if the interview was conducted
       */
      public boolean wasInterviewed(List <InterviewResults> interviewResults) {
          System.out.println("- wasInterviewed method started");
          return interviewResults.isEmpty() ? false : true;
      }
      

     
    

}

