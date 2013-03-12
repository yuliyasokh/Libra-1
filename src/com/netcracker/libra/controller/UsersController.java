package com.netcracker.libra.controller;

import com.netcracker.libra.dao.AdminJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.User;
import com.netcracker.libra.service.LengthService;
import com.netcracker.libra.util.security.Security;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for administrator
 * 
 * - displaying the employees (HR, Tech.interviewer, Administrator)
 * - sorting by a job title, ID, first name, last name, email, password
 *   in ascending or descending order
 * - filtering by a job title
 * - searching by a full name, first name, last name, email
 * - addition employee
 * - editing employee
 * - removes employee
 * - changes employee's password
 * 
 * @author Alexander Lebed
 */
@Controller
public class UsersController {
 
    List <User> employees;  //outputting list of employees
    String noResults;   //output value in no results case
    String checked;     //selected value in the filter by employee's job title
    String jobTitle;    //job title of employee
    String selected;    //selected value in the sorting by first name/last name/email etc.
    String text;        //the value entered in the text field
    boolean order;      //value of ascending or descending order; true when ascending
    
    @Autowired
    UserPreferences user;
    /**
     * Displays on the page all employees (HR, Tech.interviewer, Administrator)
     */
    @RequestMapping("admin/employees")
    public ModelAndView showEmployees() {
        
        ModelAndView mv = new ModelAndView();
        
        if(user.accessLevel==3) {
            mv.setViewName("admin/employees");
            employees = new AdminJDBC().getAllEmployees();
            checked = "checkedAll";
            selected = "selectedAll";
            
            mv.setViewName("admin/employeesView");
            mv.addObject("employees", employees);
            mv.addObject(checked, "checked");
            mv.addObject(selected, "selected");
            return mv;
        }
        else {
         mv.setViewName("admin/messageView");
         mv.addObject("title", "Ошибка");
         mv.addObject("message","Чтобы получить доступ к следующей информации, пожалуйста, авторизируйтесь как администратор.");
         mv.addObject("link","<a href='/Libra/'>Назад</a>");
         return mv;
        }
    }
    
    /**
     * Displays on the page employees by results of sorting/filtering/searching
     * or throws an appropriate message when no employees
     * and saves chosen values
     * 
     * @param role - job title of employee (0 - all employees, 2 - HR, 3 - Tech, 4 - Admin)
     * @param textValue the value entered in the text field
     * @param byWhat - the value of sorting (by first name/email etc.)
     */
    @RequestMapping("admin/sortedEmployees")
    public ModelAndView showRequiredEmployees(
                @RequestParam("role") int role,
                @RequestParam("textValue") String textValue,
                @RequestParam("byWhat") String byWhat) {
        
        text = textValue;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        
        //defining the job title and radio buttons
        switch(role) {
            case 0: checked = "checkedAll";
                    break;
            case 2: checked = "checkedHR";
                    jobTitle = "HR-менеджер";
                    break;
            case 3: checked = "checkedTech";
                    jobTitle = "Тех.интервьюер";
                    break;
            case 4: checked = "checkedAdmin";
                    jobTitle = "Администратор";
                    break;
        }
        
        mv.addObject(checked, "checked");
        mv.addObject("text", text);
        AdminJDBC jdbc = new AdminJDBC();
        
        //defining the search value and saving this value
        switch(byWhat) {
            case "ALL":
                if(role == 0) {
                        employees = jdbc.getAllEmployees();
                        noResults = "Служащие не найдены <br/>";
                        selected = "selectedAll";
                        break;
                    }
                else {  
                        employees = jdbc.getAllEmployeesByRole(role);
                        noResults = jobTitle+"ы не найдены <br/>";
                        selected = "selectedAll";
                        break;
                    }
                
            case "FULL_NAME":
                if(role == 0) {
                        employees = jdbc.getAllEmployeesByFullName(textValue);
                        noResults = "Служащий(-ие) с именем "+ textValue +" не найден(-ы)";
                        selected = "selectedFull";
                        break;
                    }
                else {
                        employees = jdbc.getAllEmployeesByFullNameAndRole(textValue, role);
                        noResults = jobTitle+"(-ы) с именем "+ textValue +" не найден(-ы)";
                        selected = "selectedFull";
                        break;
                    }
                
            case "FIRST_NAME":
                if(role == 0) {
                        employees = jdbc.getAllEmployeesByFirstName(textValue);
                        noResults = "Служащий(-ие) с именем "+ textValue +" не найден(-ы)";
                        selected = "selectedFirst";
                        break;
                    }
                else {
                        employees = jdbc.getAllEmployeesByFirstNameAndRole(textValue, role);
                        noResults = jobTitle+"(-ы) с именем "+ textValue +" не найден(-ы)";
                        selected = "selectedFirst";
                        break;
                    }
                
            case "LAST_NAME":
                if(role == 0) {
                        employees = jdbc.getAllEmployeesByLastName(textValue);
                        noResults = "Служащий(-ие) с фамилией "+ textValue +" не найден(-ы)";
                        selected = "selectedLast";
                        break;
                    }
                else {
                        employees = jdbc.getAllEmployeesByLastNameAndRole(textValue, role);
                        noResults = jobTitle+"(-ы) с фамилией "+ textValue +" не найден(-ы)";
                        selected = "selectedLast";
                        break;
                    }
                
            case "EMAIL":
                if(role == 0) {
                        employees = jdbc.getAllEmployeesByEmail(textValue);
                        noResults = "Служащий(-ие) с эл.почтой "+ textValue +" не найден(-ы)";
                        selected = "selectedEmail";
                        break;
                    }
                else {
                        employees = jdbc.getAllEmployeesByEmailAndRole(textValue, role);
                        noResults = jobTitle+"(-ы) с эл.почтой "+ textValue +" не найден(-ы)";
                        selected = "selectedEmail";
                        break;
                    }
                
        }
        mv.addObject("employees", employees);
        mv.addObject("noResults", noResults);
        mv.addObject(selected, "selected");
        return mv;
    }
    
    /**
     * The sorting in ascending or descending order 
     * by the job title, ID, first name, last name, email and password.
     * 
     * @param orderBy the value of sorting (like by the "ID" or "FIRST_NAME")
     */
    @RequestMapping("admin/sortEmployees")
    public ModelAndView sortEmployees(@RequestParam("orderBy") String orderBy) {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        mv.addObject("noResults", noResults);
        mv.addObject(selected, "selected");
        mv.addObject(checked, "checked");
        mv.addObject("text", text);
        
        if(employees.size() > 1) {
            switch(orderBy) {
            case "ROLE":
                Collections.sort(employees, new RoleComparator(order));
                break;
                
            case "ID":
                Collections.sort(employees, new IdComparator(order));
                break;
                
            case "FIRST_NAME":
                Collections.sort(employees, new FirstNameComparator(order));
                break;
                
            case "LAST_NAME":
                Collections.sort(employees, new LastNameComparator(order));
                break;
                
            case "EMAIL":
                Collections.sort(employees, new EmailComparator(order));
                break;
            }
        }
        
        order = (order==true) ? false : true;
        mv.addObject("employees", employees);
        return mv;
    }
    
    /**
     * Displays the page for edit the data of certain employee by his or her ID
     */
    @RequestMapping("admin/editEmployee")
    public ModelAndView editEmployee(@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editEmployeeView");
        mv.addObject("emp", (new AdminJDBC()).getEmployee(employeeId));
        return mv;
    }
    
    /**
     * Changes the employee's data by his or her ID 
     * and displays the statement of changes
     */
    @RequestMapping(value="admin/doneEdit", method = RequestMethod.POST)
    public ModelAndView updateEmployee (
                        @RequestParam("roleId") int roleId,
                        @RequestParam("employeeId") int employeeId,
                        @RequestParam("firstName") String firstName, 
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/messageView");
        //returns an empty string if the input value is ok (satisfies DB); otherwise - the message with the restriction
        String message = LengthService.checkFirstNameLength(firstName) + LengthService.checkLastNameLength(lastName) +
                        LengthService.checkEmailLength(email);

        //checks the duplicate emails, true if there are
        if(checkDublicateValues(email, employeeId, employees)){
            String link= "<a href=\"editEmployee.html?employeeId="+ employeeId +"\">Назад</a>";
            mv.addObject("title", "Ошибка");
            mv.addObject("message", "Адрес эл.почты должен быть уникальным");
            mv.addObject("link", link);
            return mv;
        }
        else if(message.equals("")) {
            
            (new AdminJDBC()).updateEmployee(employeeId, firstName, lastName, email, roleId);
            User employee = (new AdminJDBC()).getEmployee(employeeId);
            String link= "<a href=\"employees.html\">Список служащих</a>";
            mv.addObject("title", "Готово");
            mv.addObject("message", "Служащий "+ employee.getFirstName() +" "+ employee.getLastName() +" успешно изменен.");
            mv.addObject("link", link);
            return mv;
        }
        else {
            String link= "<a href=\"editEmployee.html?employeeId="+ employeeId +"\">Назад</a>";
            mv.addObject("title", "Ошибка");
            mv.addObject("message", message);
            mv.addObject("link", link);
            return mv;
        }
    }
    
    /**
     * Displays on the page all employees (HR, Tech.interviewer, Administrator)
     * and the ability to add the new one
     */
    @RequestMapping("admin/addEmployee")
    public ModelAndView addEmployeeView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/addEmployeeView");
        mv.addObject("employees", new AdminJDBC().getAllEmployees());
        return mv;
    }
    
    /**
     * Adds a new employee and displays the statement of changes
     */
    @RequestMapping(value="admin/doneAdd", method = RequestMethod.POST)
    public ModelAndView addEmployee (
                        @RequestParam("roleId") int roleId,
                        @RequestParam("firstName") String firstName, 
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, 
                        @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/messageView");
        //returns an empty string if the input value satisfies DB; otherwise - the message with the restriction
        String message = LengthService.checkFirstNameLength(firstName) + LengthService.checkLastNameLength(lastName) +
                        LengthService.checkEmailLength(email) + LengthService.checkPasswordLength(password);
        
        if(message.equals("")) {
            (new AdminJDBC()).addEmployee(firstName, lastName, email, Security.getMD5hash(password), roleId);
            String link= "<a href=\"employees.html\">Список служащих</a>";
            mv.addObject("title", "Готово");
            mv.addObject("message", "Служащий "+ firstName +" "+ lastName +" успешно добавлен.");
            mv.addObject("link", link);
            return mv;
        }
        else {
            String link= "<a href=\"addEmloyee.html\">Назад</a>";
            mv.addObject("title", "Ошибка");
            mv.addObject("message", message);
            mv.addObject("link", link);
            return mv;
        }
    }
    
    /**
     * Displays the page with confirmation about deleting the employee (Y/N)
     */
    @RequestMapping("admin/deleteSure")
    public ModelAndView deleteSure(@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/deleteSureView");
        mv.addObject("emp", (new AdminJDBC()).getEmployee(employeeId));
        return mv;
    }
    
    /**
     * Deleting of employee from all database tabels
     * and displays the statement of changes
     */
    @RequestMapping(value="admin/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee (@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        User employee = (new AdminJDBC()).getEmployee(employeeId);
        //deleting of employee from all database tabels
        (new AdminJDBC()).deleteEmployee(employeeId);
        
        String message = "Служащий "+ employee.getFirstName() +" "+ employee.getLastName() +" успешно удален.";
        String link= "<a href=\"employees.html\">Список служащих</a>";
        mv.setViewName("admin/messageView");
        mv.addObject("title", "Готово");
        mv.addObject("message", message);
        mv.addObject("link", link);
        return mv;
    }
    
    /**
     * Displays the page with changing the password of employee
     */
    @RequestMapping("admin/changeEmployeePassword")
    public ModelAndView changeEmployeePassword (@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/changeEmployeePasswordView");
        
        mv.addObject("id", employeeId);
        mv.addObject(checked, "checked");
        mv.addObject(selected, "selected");
        mv.addObject("text", text);
        mv.addObject("employees", employees);
        return mv;
    }
    
    /**
     * Changes the password of employee, goes to the page with employees
     * and displays the message of changing
     */
    @RequestMapping("admin/changedEmployeePassword")
    public ModelAndView changedEmployeePassword (@RequestParam("employeeId") int employeeId,
                                                 @RequestParam("passwordValue") String passwordValue) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        mv.addObject(checked, "checked");
        mv.addObject(selected, "selected");
        mv.addObject("text", text);
        mv.addObject("employees", employees);
        
        //returns an empty string if the input value satisfies DB; otherwise - the message with the restriction
        String message = LengthService.checkPasswordLength(passwordValue);
        
        if(message.equals("")) {
            String password = Security.getMD5hash(passwordValue);
            new AdminJDBC().changePassword(password, employeeId);
            mv.addObject("message", "Пароль был изменен");
        }
        else {
            mv.addObject("message", message);
        }
        
        return mv;
    }
    
    /**
     * Comparator has been created to be passed to a method Collections.sort to sort of objects list
     * in ascending or descending order by the ID (look the sortEmployees method in UsersController class).
     */
    public static class IdComparator implements Comparator <User> {
        private boolean asc; // true - sorts in ascending order, fasle - descending
        public IdComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User user1, User user2) {
            if(asc) {
                return (user1.getUserId() > user2.getUserId()) ? 1 
                    : (user1.getUserId() == user2.getUserId()) ? 0 : -1;
            }
            else {
                return (user2.getUserId() > user1.getUserId()) ? 1 
                    : (user2.getUserId() == user1.getUserId()) ? 0 : -1;
            }
        }
    }
    
    /**
     * Comparator has been created to be passed to a method Collections.sort to sort of objects list
     * in ascending or descending order by the first name (look the sortEmployees method in UsersController class).
     */
    public static class FirstNameComparator implements Comparator <User> {
        private boolean asc; //true - sorts in ascending order, fasle - descending
        public FirstNameComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User o1, User o2) {
            return asc ? (o1.getFirstName().compareToIgnoreCase(o2.getFirstName())) 
                       : (o2.getFirstName().compareToIgnoreCase(o1.getFirstName()));
        }
    }
    
    /**
     * Comparator has been created to be passed to a method Collections.sort to sort of objects list
     * in ascending or descending order by the last name (look the sortEmployees method in UsersController class).
     */
    public static class LastNameComparator implements Comparator <User> {
        private boolean asc; //true - sorts in ascending order, fasle - descending
        public LastNameComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User o1, User o2) {
            return asc ? (o1.getLastName().compareToIgnoreCase(o2.getLastName())) 
                       : (o2.getLastName().compareToIgnoreCase(o1.getLastName()));
        }
    }
    
    /**
     * Comparator has been created to be passed to a method Collections.sort to sort of objects list
     * in ascending or descending order by the email (look the sortEmployees method in UsersController class).
     */
    public static class EmailComparator implements Comparator <User> {
        private boolean asc; //true - sorts in ascending order, fasle - descending
        public EmailComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User o1, User o2) {
            return asc ? (o1.getEmail().compareToIgnoreCase(o2.getEmail())) 
                       : (o2.getEmail().compareToIgnoreCase(o1.getEmail()));
        }
    }
    
    /**
     * Comparator has been created to be passed to a method Collections.sort to sort of objects list
     * in ascending or descending order by the role (look the sortEmployees method in UsersController class).
     */
    public static class RoleComparator implements Comparator <User> {
        private boolean asc; //true - sorts in ascending order, fasle - descending
        public RoleComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User user1, User user2) {
            if(asc) {
                return (user1.getRoleId() > user2.getRoleId()) ? 1 
                    : (user1.getRoleId() == user2.getRoleId()) ? 0 : -1;
            }
            else {
                return (user2.getRoleId() > user1.getRoleId()) ? 1 
                    : (user2.getRoleId() == user1.getRoleId()) ? 0 : -1;
            }
        }
    }
    
    /**
     * Checks for duplicates of emails by employee's ID
     * Returns true if there are duplicates, false - otherwise
     */
    public boolean checkDublicateValues(String email, Integer employeeId, List <User> users) {
        
        List <User> list = users;
        Set set = new TreeSet();
        //add the changed email first
        set.add(email);
        boolean dublicate = false;
        //check all emails except for the old employee's email
        for(User user : list) {
            if(user.getUserId()!= employeeId) {
                if(!set.add(user.getEmail())) {
                dublicate = true;
                }
            }
        }
        return dublicate;
    }
    
}