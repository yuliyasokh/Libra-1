package com.netcracker.libra.controller;

import com.netcracker.libra.dao.AdminJDBC;
import com.netcracker.libra.model.User;
import com.netcracker.libra.service.LengthService;
import com.netcracker.libra.service.SortService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для Админа
 * 
 * @author Alexander Lebed
 */
@Controller
public class UsersController {

    
    List <User> employees;  //выводимый список служащих
    String noResults;   //выводимое значение в случае нулевого результата
    String checked;     //выбранное значение в фильтре по должности служащего
    String jobTitle;
    String selected;    //выбранное значение сортировки по имени/фамилии и т.д.
    String text;        //введенное значение в текстовом поле
    boolean ASC;        //переключатель сортировки; true - в алфавитном порядке/от меньшого к большему, false - наоборот
    
    /**
     * Выводит на страничку со списком всех служащих (Hr, Tech, Admin),
     * возможностью сортировки, фильтра, поиска сотрудников и
     * ссылкой на добавление нового сотрудника
     */
    @RequestMapping("admin/employees")
    public ModelAndView showEmployees() {
        
        employees = new AdminJDBC().getAllEmployees();
        checked = "checkedAll";
        selected = "selectedAll";
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        mv.addObject("employees", employees);
        mv.addObject(checked, "checked");
        mv.addObject(selected, "selected");
        return mv;
    }
    
    /**
     * Выводит на страничку со списком служащих (Hr, Tech, Admin)
     * по результатам сортировки/фильтра/поиска
     * и ссылкой на добавление нового сотрудника
     * 
     * @param role - должность сотрудника (RoleId в таблице Users (БД)), где
     * 0 - все сотрудники (Hr, Tech, Admin),
     * 2 - Hr,
     * 3 - Tech,
     * 4 - Admin
     * @param textValue - вводимое пользователем значение (имя/email)
     * @param byWhat - сортировка по... (по имени/по email)
     */
    @RequestMapping("admin/sortedEmployees")
    public ModelAndView showRequiredEmployees(
                @RequestParam("role") int role,
                @RequestParam("textValue") String textValue,
                @RequestParam("byWhat") String byWhat) {
        
        text = textValue;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        
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
     * Соритровка слухащих по ID, должности, имени, фамилии, email, паролю.
     * Сортировка строк в алфавитном/обратном алфавитном порядке, числел  - 
     * от меньшего к большему или наоборот.
     * @param orderBy - строка с названием элемента сортировки
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
                if(ASC) {
                    SortService.orderByRoleASC(employees);
                }
                else {
                    SortService.orderByRoleDESC(employees);
                }
                break;
                
            case "ID":
                if(ASC) {
                    SortService.orderByIdASC(employees);
                }
                else {
                    SortService.orderByIdDESC(employees);
                }
                break;
                
            case "FIRST_NAME":
                if(ASC) {
                    SortService.orderByFirstNameASC(employees);
                }
                else {
                    SortService.orderByFirstNameDESC(employees);
                }
                break;
                
            case "LAST_NAME":
                if(ASC) {
                    SortService.orderByLastNameASC(employees);
                }
                else {
                    SortService.orderByLastNameDESC(employees);
                }
                break;
                
            case "EMAIL":
                if(ASC) {
                    SortService.orderByEmailASC(employees);
                }
                else {
                    SortService.orderByEmailDESC(employees);
                }
                break;
                
            case "PASSWORD":
                if(ASC) {
                    SortService.orderByPasswordASC(employees);
                }
                else {
                    SortService.orderByPasswordDESC(employees);
                }
                break;
            }
        }
        
        ASC = (ASC==true) ? false : true;
        mv.addObject("employees", employees);
        return mv;
    }
    
    /**
     * Выводит страничку для редактирования данных о служащем по его ID
     */
    @RequestMapping("admin/editEmployee")
    public ModelAndView editEmployee(@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editEmployeeView");
        mv.addObject("emp", (new AdminJDBC()).getEmployee(employeeId));
        return mv;
    }
    
    /**
     * Производит изменения о служащем в таблице Users
     * Возвращает страничку с отчетом об изменении
     */
    @RequestMapping(value="admin/doneEdit", method = RequestMethod.POST)
    public ModelAndView updateEmployee (
                        @RequestParam("roleId") int roleId,
                        @RequestParam("employeeId") int employeeId,
                        @RequestParam("firstName") String firstName, 
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, 
                        @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/doneView");
        // воздращает пустую строку, если вводимое значение удоблетворяет условиям БД
        String message = LengthService.checkFirstNameLength(firstName) + LengthService.checkLastNameLength(lastName) +
                        LengthService.checkEmailLength(email) + LengthService.checkPasswordLength(password);
        
        if(message.equals("")) {
            (new AdminJDBC()).updateEmployee(employeeId, firstName, lastName, email, password, roleId);
            
            User employee = (new AdminJDBC()).getEmployee(employeeId);
            message = "Служащий "+ employee.getFirstName() +" "+ employee.getLastName() +" успешно изменен.";
            String link= "<a href=\"employees.html\">Список служащих</a>";
            mv.addObject("title", "Готово");
            mv.addObject("message", message);
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
     * Выводит страничку со списком всех служащих (Hr, Tech, Admin) и
     * возможностью внесения информации о новом сотруднике
     */
    @RequestMapping("admin/addEmloyee")
    public ModelAndView addEmployeeView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/addEmployeeView");
        mv.addObject("employees", new AdminJDBC().getAllEmployees());
        return mv;
    }
    
    /**
     * Добавляет нового служащего в таблицу Users и выводит
     * отчет о его добавлении
     */
    @RequestMapping(value="admin/doneAdd", method = RequestMethod.POST)
    public ModelAndView addEmployee (
                        @RequestParam("roleId") int roleId,
                        @RequestParam("firstName") String firstName, 
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, 
                        @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/doneView");
        // воздращает пустую строку, если вводимое значение удоблетворяет условиям БД
        String message = LengthService.checkFirstNameLength(firstName) + LengthService.checkLastNameLength(lastName) +
                        LengthService.checkEmailLength(email) + LengthService.checkPasswordLength(password);
        
        if(message.equals("")) {
            (new AdminJDBC()).addEmployee(firstName, lastName, email, password, roleId);

            message = "Служащий "+ firstName +" "+ lastName +" успешно добавлен.";
            String link= "<a href=\"employees.html\">Список служащих</a>";
            mv.addObject("title", "Готово");
            mv.addObject("message", message);
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
     * Выводит страничку о потверждении удаления служащего (Y/N)
     */
    @RequestMapping("admin/deleteSure")
    public ModelAndView deleteSure(@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/deleteSureView");
        mv.addObject("emp", (new AdminJDBC()).getEmployee(employeeId));
        return mv;
    }
    
    /**
     * Удаляет данные о служащем из всех таблиц, в которых есть информация о нем
     * Возвращает страничку с отчетом об удалении
     */
    @RequestMapping(value="admin/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee (@RequestParam("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView();
        User employee = (new AdminJDBC()).getEmployee(employeeId);
        // удаляет служащего во всех таблицах с ним
        (new AdminJDBC()).deleteEmployee(employeeId);
        
        String message = "Служащий "+ employee.getFirstName() +" "+ employee.getLastName() +" успешно удален.";
        String link= "<a href=\"employees.html\">Список служащих</a>";
        mv.setViewName("admin/doneView");
        mv.addObject("title", "Готово");
        mv.addObject("message", message);
        mv.addObject("link", link);
        return mv;
    }
    
}