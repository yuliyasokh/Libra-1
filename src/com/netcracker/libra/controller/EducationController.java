/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.HrJDBC;
import com.netcracker.libra.model.Department;
import com.netcracker.libra.model.Faculty;
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
public class EducationController {
    
    HrJDBC hr = new HrJDBC();
    
    @RequestMapping("/hr/showUniversities")
    public ModelAndView showUnivers(){
        ModelAndView mav = new ModelAndView();
        List<University> univers = hr.getAllUniversity();
        mav.addObject("univers", univers);
        mav.setViewName("/hr/showUniversities");
        return mav;
    }
    
    @RequestMapping("/hr/showFaculties")
    public ModelAndView showFact(){
        ModelAndView mav = new ModelAndView();
        List<Faculty> facts = hr.getAllFaculties();
        mav.addObject("facts", facts);
        mav.setViewName("/hr/showFaculties");
        return mav;
    }
    
    @RequestMapping("/hr/showDepartments")
    public ModelAndView showDepts(){
        ModelAndView mav = new ModelAndView();
        List<Department> depts = hr.gelAllDepartemtns();
        mav.addObject("depts",depts);
        mav.setViewName("/hr/showDepartments");
        return mav;
    }
    @RequestMapping(value="/hr/delUniversity", method=RequestMethod.GET)
    public ModelAndView delUniver(@RequestParam("universityId") int universityId){
        List<University> univers = hr.getUniversityById(universityId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("univers", univers);
        return mav;
    }
    @RequestMapping(value="/hr/delFaculty", method=RequestMethod.GET)
    public ModelAndView delFact(@RequestParam("facultyId") int facultyId){
        List<Faculty> facts = hr.getAllFacultiesById(facultyId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("facts", facts);
        return mav;
    }
    @RequestMapping(value="/hr/delDepartment", method=RequestMethod.GET)
    public ModelAndView delDept(@RequestParam("departmentId") int departmentId){
        List<Department> depts = hr.getAllDepartments("d.departmentId", departmentId);
        ModelAndView mav= new ModelAndView();
        mav.addObject("depts", depts);
        return mav;
    }
    @RequestMapping(value="/hr/deletedUniversities", method=RequestMethod.POST)
    public ModelAndView deletedUnivers(@RequestParam("universityId") int universityId){
       hr.deleteUniversity(universityId);
       ModelAndView mav = new ModelAndView();
       List<University> univers = hr.getAllUniversity();
       mav.addObject("univers", univers);
       mav.addObject("msg", "University successfully deleted!");
       mav.setViewName("/hr/showUniversities");
       return mav;
    }
    @RequestMapping(value="/hr/deletedFaculties", method=RequestMethod.POST)
    public ModelAndView deletedFact(@RequestParam("facultyId") int facultyId){
       hr.deleteFaculty(facultyId);
       ModelAndView mav = new ModelAndView();
       List<Faculty> facts = hr.getAllFaculties();
       mav.addObject("facts", facts);
       mav.addObject("msg", "Faculty successfully deleted!");
       mav.setViewName("/hr/showFaculties");
       return mav;
    }
    @RequestMapping(value="hr/deletedDepartments", method = RequestMethod.POST)
    public ModelAndView deleteDept(@RequestParam("departmentId") int departmentId){
        hr.deleteDepartment(departmentId);
        ModelAndView mav = new ModelAndView();
        List<Department> depts = hr.gelAllDepartemtns();
        mav.addObject("depts", depts);
        mav.addObject("msg", "Department successfully deleted!");
        mav.setViewName("/hr/showDepartments");
        return mav;
    }
    @RequestMapping(value="hr/editUniversity", method = RequestMethod.GET)
    public ModelAndView editUniversity(@RequestParam("universityId") int universityId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("u", hr.getUniversityById(universityId));
        return mav;
    }
    @RequestMapping(value="hr/editFaculty", method=RequestMethod.GET)
    public ModelAndView editFact(@RequestParam("facultyId") int facultyId){
        ModelAndView mav = new ModelAndView();
        List<Faculty> facts = hr.selectedUniversity(facultyId);
        mav.addObject("f", facts);
        int i = 0;
        for(Faculty f:facts){
            i=f.getUniverId();
        }
        List<University> unsUniv = hr.selectedUniversit(i);
        List<University> univ = hr.unselectedUniversity(i);
        mav.addObject("selectedUniv", unsUniv);
        mav.addObject("unselectedUniv", univ);
        return mav;
    }
    
    @RequestMapping(value="hr/editDepartment", method = RequestMethod.GET)
    public ModelAndView editFaculty(@RequestParam("departmentId") int departmentId){
        ModelAndView mav = new ModelAndView();
        List<Department> depts = hr.getAllDepartments("d.departmentId", departmentId);
        mav.addObject("depts", depts);
        int f=1; 
        int u=0;
        for(Department d:depts){
             u =hr.getUniversityIdByName(d.getUniversityName());
             f=d.getFacId();
        }
        List<University> unsUniv = hr.selectedUniversit(u);
        List<University> univ = hr.unselectedUniversity(u);
        List<Faculty> selFacts = hr.getAllFacultiesById(f);
        List<Faculty> unselFacts = hr.getUnselectedFaculties(f,u);
        mav.addObject("selFacts", selFacts);
        mav.addObject("unselFacts", unselFacts);
        mav.addObject("selectedUniv", unsUniv);
        mav.addObject("unselectedUniv", univ);
        return mav;        
    }
    
    @RequestMapping(value="hr/editedUniversity", method = RequestMethod.POST)
    public ModelAndView editedUniversity(@RequestParam("universityId")int universityId,
    @RequestParam("universityName") String universityName){
        ModelAndView mav = new ModelAndView();
        try{
            if (universityName.equals("")){
                mav.addObject("u", hr.getUniversityById(universityId));
                mav.addObject("msg", "Editing failed, university name has uncorrect format");
                mav.setViewName("/hr/editUniversity"); 
                return mav;
                }
            hr.updateUniversity(universityId, universityName);
            List<University> univers = hr.getAllUniversity();
            mav.addObject("univers", univers);
            mav.addObject("msg", "University successfully edited!");
            mav.setViewName("hr/showUniversities");
            return mav;
        }
            catch(Exception ex){
                mav.addObject("msg", "Editing failed");
                mav.setViewName("/hr/editUniversity"); 
                return mav;
            }
    }
    
    @RequestMapping(value="hr/editedFaculty", method = RequestMethod.POST)
    public ModelAndView editedFaculty(@RequestParam("facultyId") int facultyId,
    @RequestParam("facultyName") String facultyName,
    @RequestParam("univ") int universityId){
        ModelAndView mav = new ModelAndView();
        try{
            if (facultyName.equals("")){
                List<Faculty> facts = hr.selectedUniversity(facultyId);
                mav.addObject("f", facts);
                int i = 0;
                for(Faculty f:facts){
                    i=f.getUniverId();
                }
                List<University> unsUniv = hr.selectedUniversit(i);
                List<University> univ = hr.unselectedUniversity(i);
                mav.addObject("selectedUniv", unsUniv);
                mav.addObject("unselectedUniv", univ);
                mav.addObject("msg", "Editing failed!");
                mav.setViewName("hr/editFaculty");
                return mav;
            }
            hr.updateFaculty(facultyId, facultyName, universityId);
            List<Faculty> faculty = hr.getAllFaculties();
            mav.addObject("facts", faculty);
            mav.addObject("msg", "Faculty successfully edited!");
            mav.setViewName("hr/showFaculties");
            return mav;
            }
            catch(Exception ex){
                mav.addObject("msg", "Editing failed");
                mav.setViewName("/hr/editFaculty"); 
                return mav;
            }
    
    }
    
    @RequestMapping(value="/hr/editedDepartment", method=RequestMethod.POST)
    public ModelAndView editedDepartment(
            @RequestParam("departmentId") int departmentId,
            @RequestParam("departmentName") String departmentName,
            @RequestParam("fact") int facultyId){
        ModelAndView mav = new ModelAndView();
        try{
            if ((departmentName.equals("")) || (facultyId==0)) {
                List<Department> depts = hr.getAllDepartments("d.departmentId", departmentId);
                mav.addObject("depts", depts);
                int f=1; 
                int u=0;
                for(Department d:depts){
                    u =hr.getUniversityIdByName(d.getUniversityName());
                    f=d.getFacId();
                    }
                List<University> unsUniv = hr.selectedUniversit(u);
                List<University> univ = hr.unselectedUniversity(u);
                List<Faculty> selFacts = hr.getAllFacultiesById(f);
                List<Faculty> unselFacts = hr.getUnselectedFaculties(f,u);
                mav.addObject("selFacts", selFacts);
                mav.addObject("unselFacts", unselFacts);
                mav.addObject("selectedUniv", unsUniv);
                mav.addObject("unselectedUniv", univ);
                mav.addObject("msg", "Editing failed!");
                mav.setViewName("hr/editDepartment");
                return mav;
            }
            hr.updateDepartment(departmentId, departmentName, facultyId);
            List<Department> depts = hr.gelAllDepartemtns();
            mav.addObject("depts",depts);
            mav.setViewName("/hr/showDepartments");
            return mav;
            }
            catch(Exception ex){
                mav.addObject("msg", "Editing failed");
                mav.setViewName("/hr/editDepartment"); 
                return mav;
            }
    }
            
            
    @RequestMapping(value="/hr/addUniversities", method= RequestMethod.GET)
    public ModelAndView addUniver(){
        ModelAndView mav = new ModelAndView();
        List<University> univers = hr.getAllUniversity();
        mav.addObject("univers", univers);
        mav.setViewName("/hr/addUniversities");
        return mav;
    }
    @RequestMapping(value="/hr/addFaculties", method=RequestMethod.GET)
    public ModelAndView addFac(){
        ModelAndView mav = new ModelAndView();
        List<University> univers = hr.getAllUniversity();
        mav.addObject("univers", univers);
        List<Faculty> facts = hr.getAllFaculties();
        mav.addObject("facts", facts);
        mav.setViewName("/hr/addFaculties");
        return mav;
    }
    @RequestMapping(value="/hr/addDepartments", method=RequestMethod.GET)
    public ModelAndView addDept(){
        ModelAndView mav = new ModelAndView();
        List<University> univers = hr.getAllUniversity();
        mav.addObject("univers", univers);
        List<Faculty> facts = hr.getAllFaculties();
        mav.addObject("facts", facts);
        List<Department> dept = hr.gelAllDepartemtns();
        mav.addObject("depts", dept);
        mav.setViewName("/hr/addDepartments");
        return mav;
    }
    
    @RequestMapping(value="hr/addUniversitiesAdded", method= RequestMethod.GET)
    public ModelAndView addedUniver(
    @RequestParam("univerName") String name){
        ModelAndView mav = new ModelAndView();
        if (name.equals("")) {
            mav.addObject("msg", "University name is not correct! Try again");
            mav.setViewName("/hr/addUniversities");
            List<University> univers = hr.getAllUniversity();
            mav.addObject("univers", univers);
            return mav;
        }
        hr.addUniversity(name);
        List<University> univers = hr.getAllUniversity();
        mav.addObject("univers", univers);
        mav.addObject("msg", "University successfully added!");
        mav.setViewName("/hr/showUniversities");
        return mav;
    }
    
    @RequestMapping(value="hr/addFacultiesAdded", method=RequestMethod.GET)
    public ModelAndView addFaculty(
    @RequestParam("facultyName") String name,
    @RequestParam("univ") int universityId){
        ModelAndView mav = new ModelAndView();
        hr.addFaculty(name, universityId);
        List<Faculty> facts = hr.getAllFaculties();
        mav.addObject("facts", facts);
        mav.addObject("msg", "Faculty successfully added!");
        mav.setViewName("/hr/showFaculties");
        return mav;
    }

    @RequestMapping(value="/hr/addDepartmentAdded", method=RequestMethod.GET)
    public ModelAndView addDept(
    @RequestParam("deptName") String name,
    @RequestParam("fact") int facultyId){
        ModelAndView mav=new ModelAndView();
        hr.addDepartment(name, facultyId);
        List<Department> depts = hr.gelAllDepartemtns();
        mav.addObject("depts", depts);
        mav.addObject("msg", "Department successfully added!");
        mav.setViewName("/hr/showDepartments");
        return mav;
    
    }
    
    @RequestMapping(value ="/hr/showDepartmentsSearch", method= RequestMethod.GET)
    public ModelAndView searchDept(
    @RequestParam("textBox")String name,
    @RequestParam("departmentSearch") int departmentSearchInt){
        ModelAndView mav = new ModelAndView();
        mav.addObject("textBoxString", name);
        mav.addObject("departmentSearchInt", departmentSearchInt);
        if (departmentSearchInt==1){
            int n = Integer.parseInt(name);
            List<Department> depts = hr.getAllDepartments("d.departmentId", n);
            mav.addObject("depts", depts);
        }
        if (departmentSearchInt==2){
            List<Department> depts = hr.getAllDepartments("d.departmentName", name);
            mav.addObject("depts", depts);
        }
        if (departmentSearchInt==3){
            List<Department> depts = hr.getAllDepartments("f.facultyName", name);
            mav.addObject("depts", depts);
        }
        if (departmentSearchInt==4){
            List<Department> depts = hr.getAllDepartments("u.universityName", name);
            mav.addObject("depts", depts);
        }
        if (departmentSearchInt==0){
            List<Department> depts = hr.gelAllDepartemtns();
            mav.addObject("depts", depts);
        }
        return mav;
        
    }
    
    @RequestMapping(value="hr/showFacultiesSearch", method= RequestMethod.GET)
    public ModelAndView searchFacts(
    @RequestParam("textBox")String name,
    @RequestParam("facultySearch") int facultySearchInt){
        ModelAndView mav = new ModelAndView();
        mav.addObject("textBoxString", name);
        mav.addObject("facultySearchInt", facultySearchInt);
        if (facultySearchInt==1){
            try{
            int n=Integer.parseInt(name);
            List<Faculty> facts = hr.getAllFacultiesById(n);
            mav.addObject("facts", facts);
            }
            catch(Exception e){
                mav.addObject("msg", "№ faculty has not correct format!");
                List<Faculty> facts = hr.getAllFaculties();
                mav.addObject("facts", facts);
                }
        }
        if (facultySearchInt==2){
            List<Faculty> facts = hr.getAllFaculties("facultyName", name);
            mav.addObject("facts", facts);
        }
        if (facultySearchInt==3){
            List<Faculty> facts = hr.getAllFaculties("universityName", name);
            mav.addObject("facts", facts);
        }
        if (facultySearchInt==0){
            List<Faculty> facts = hr.getAllFaculties();
            mav.addObject("facts", facts);
        }
        
        return mav;
    }
    
    @RequestMapping(value="hr/showUniversitiesSearch", method= RequestMethod.GET)
    public ModelAndView searchUnivs(
    @RequestParam("textBox") String name, 
    @RequestParam("univerSearch") int univerSearchInt){
        ModelAndView mav = new ModelAndView();
        mav.addObject("textBoxString", name);
        mav.addObject("univerSearchInt", univerSearchInt);
        if (univerSearchInt==1){
            try{
            int n=Integer.parseInt(name);
            List<University> univers = hr.getUniversityById(n);
            mav.addObject("univers", univers);
            }
            catch(Exception e){
                mav.addObject("msg", "№ university has not correct format!");
                List<University> univers = hr.getAllUniversity();
                mav.addObject("univers", univers);
            }
        }
        if (univerSearchInt==2){
            List<University> univers = hr.getUniversityByName(name);
            mav.addObject("univers", univers);
        }
        if(univerSearchInt==0){
            List<University> univers = hr.getAllUniversity();
            mav.addObject("univers", univers);
        }
        return mav;
    }
    
}
