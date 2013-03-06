
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.HrJDBC;
import com.netcracker.libra.model.Department;
import com.netcracker.libra.model.Faculty;
import com.netcracker.libra.model.Interview;
import com.netcracker.libra.model.InterviewDate;
import com.netcracker.libra.model.InterviewResults;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.University;
import com.netcracker.libra.model.User;
import com.netcracker.libra.model.UserResult;
import com.netcracker.libra.service.TimeService;
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
       * @author Alexander Lebed
       * @param appId
       * @param firstName
       * @param lastName
       * @return 
       */
      
      
      @RequestMapping("hr/showStudentInterview")
      public ModelAndView showStudentInterview(
                            @RequestParam("appId") int appId,
                            @RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {

          ModelAndView mv = new ModelAndView();
          HrJDBC hrjdbc = new HrJDBC();
          
          Interview interview = hrjdbc.getInterview(appId);
          System.out.println("- got the inteview with");
          InterviewDate interviewDate = hrjdbc.getInterviewDate(interview.getInterviewDateId());
          System.out.println("- got the inteviewDate");
          List <InterviewResults> interviewResults = hrjdbc.getInterviewResults(interview.getInterviewId());
          System.out.println("- got the List of inteviewResults");
          
          
          
          //CASE 1
          if(!sheduledInterview(interview)) {
              System.out.println("- case 1");
              mv.setViewName("hr/messageView");
              mv.addObject("message", "Студент "+ firstName +" "+ lastName +" не записался на интервью");
          }
          
          //CASE 2
          else if(actual(interviewDate.getDateFinish())) {
              System.out.println("- case 2 (дата будущего интервью, время и интервьюеры)");
              //дата интервью, время и интервьюеры;
              List <User> employees = hrjdbc.getInterviewersFromInterviewerList(interview.getInterviewDateId());              
              TimeService timeService = new TimeService();
              
              System.out.println("- got the List of inteviewers");

              mv.setViewName("hr/showStudentInterviewInfo");
              mv.addObject("appId", interview.getAppId());
              mv.addObject("employees", employees);
              mv.addObject("interviewDate", interviewDate);
              mv.addObject("timeService", timeService);
          }
          
          //CASE 3
          else if(wasInterviewed(interviewResults)) {
              System.out.println("- case 3 (результаты интервью)");
              //результаты интервью, интервьюеры и дата пройденного интервью;
              List <UserResult> userResults = hrjdbc.getUserResults(interview.getInterviewId());
              TimeService timeService = new TimeService();
              System.out.println("- first interviewer's name " + userResults.get(0).getFirstName());
              mv.setViewName("hr/showStudentInterviewResults");
              mv.addObject("appId", interview.getAppId());
              mv.addObject("userResults", userResults);
              mv.addObject("interviewDate", interviewDate);
              mv.addObject("timeService", timeService);
          }
          
          //CASE 4
          else {
              System.out.println("- case 4");
              mv.setViewName("hr/messageView");
              mv.addObject("message", "Студент "+ firstName +" "+ lastName +" не явился на интервью");
          }
          
          return mv;
      }
      
      
      
      /**
       * @return true если интервью было назначено
       */
      public boolean sheduledInterview(Interview interview) {
          System.out.println("- sheduledInterview method started");
          //return interview != null ? true : false;
          if(interview != null) {
              System.out.println("- interview is not null - true");
              return true;
          }
          else {
              System.out.println("- interview is null - false");
              return false;
          }
      }
      
      /**
       * @return true если интервью состоялось
       */
      public boolean wasInterviewed(List <InterviewResults> interviewResults) {
          System.out.println("- wasInterviewed method started");
          return interviewResults.isEmpty() ? false : true;
      }
      
      /**
       * @return true если собеседование БУДЕТ; false - если БЫЛО
       */
      public boolean actualInterview(InterviewDate interviewDate) {
          System.out.println("- actualInterview method started");
          return interviewDate != null ? true : false;
      }
      
      public boolean actual(java.util.Date interviewDate) {
        java.util.Date currentDate = new java.util.Date();
        return (currentDate.before(interviewDate)) ? true : false;
      }
      
      

     
    

}

