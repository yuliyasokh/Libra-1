package com.netcracker.libra.controller;

import com.netcracker.libra.dao.AdminJDBC;
import com.netcracker.libra.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander Lebed
 */
@Controller
public class UsersController {
    
    @RequestMapping("admin/employees")
    public ModelAndView showEmployees() {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        mv.addObject("employees", new AdminJDBC().getAllEmployees());
        return mv;
    }
    
    /**
     *
     * @param employeeId
     * @return
     */
    @RequestMapping("admin/editEmployee")
    public ModelAndView editEmployee(@RequestParam("employee") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editEmployeeView");
        mv.addObject("value", employeeId);
        mv.addObject("employees", new AdminJDBC().getAllEmployees());
        mv.addObject("emp", (new AdminJDBC()).getEmployee(employeeId));
        return mv;
    }
    
    @RequestMapping(value="done", method= RequestMethod.POST)
    public ModelAndView updateEmployee(
                        @RequestParam("employeeId") int employeeId,
                        @RequestParam("firstName") String firstName, 
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        @RequestParam("roleId") int roleId) {
        ModelAndView mv = new ModelAndView();
        (new AdminJDBC()).updateEmployee(employeeId, firstName, lastName, email, password, roleId);
        
        User employee = (new AdminJDBC()).getEmployee(employeeId);
        String message = "Служащий "+ employee.getFirstName() +" "+ employee.getLastName() +" успешно изменен.";
        String link= "<a href=\"admin/employees\">Список служащих</a>";
        mv.setViewName("resultView");
        mv.addObject("title", "Done");
        mv.addObject("message", message);
        mv.addObject("link", link);
        return mv;
    }
    
}