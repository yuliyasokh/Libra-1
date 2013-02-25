package com.netcracker.libra.controller;

import com.netcracker.libra.dao.AdminJDBC;
import com.netcracker.libra.model.User;
import com.netcracker.libra.service.LengthService;
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
    
    /**
     * Выводит на страничку со списком всех служащих (Hr, Tech, Admin),
     * возможностью сортировки, фильтра, поиска сотрудников и
     * ссылкой на добавление нового сотрудника
     */
    @RequestMapping("admin/employees")
    public ModelAndView showEmployees() {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        mv.addObject("employees", new AdminJDBC().getAllEmployees());
        mv.addObject("selectedAll", "selected");
        mv.addObject("checkedAll", "checked");
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

        String checked = null;
        String title = null;
        
        switch(role) {
            case 0: checked = "checkedAll";
                    break;
            case 2: checked = "checkedHR";
                    title = "HR-менеджер";
                    break;
            case 3: checked = "checkedTech";
                    title = "Тех.интервьюер";
                    break;
            case 4: checked = "checkedAdmin";
                    title = "Администратор";
                    break;
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/employeesView");
        //сохраняет выбранное значение в фильтре по должности служащего
        mv.addObject(checked, "checked");
        //сохраняет введенное значение в текстовом поле
        mv.addObject("text", textValue);
   
        AdminJDBC jdbc = new AdminJDBC();
        
        switch(byWhat) {
            case "ALL":
                if(role == 0) {
                        mv.addObject("employees", jdbc.getAllEmployees());
                        mv.addObject("noResults", "Служащие не найдены <br/>");
                        //сохраняет выбранное значение сортировки по имени/фамилии и т.д.
                        mv.addObject("selectedAll", "selected");
                        break;
                    }
                else {
                        mv.addObject("employees", jdbc.getAllEmployeesByRole(role));
                        mv.addObject("noResults", title+"ы не найдены <br/>");
                        mv.addObject("selectedAll", "selected");
                        break;
                    }
                
            case "FULL_NAME":
                if(role == 0) {
                        mv.addObject("employees", jdbc.getAllEmployeesByFullName(textValue));
                        mv.addObject("noResults", "Служащий(-ие) с именем "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedFull", "selected");
                        break;
                    }
                else {
                        mv.addObject("employees", jdbc.getAllEmployeesByFullNameAndRole(textValue, role));
                        mv.addObject("noResults", title+"(-ы) с именем "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedFull", "selected");
                        break;
                    }
                
            case "FIRST_NAME":
                if(role == 0) {
                        mv.addObject("employees", jdbc.getAllEmployeesByFirstName(textValue));
                        mv.addObject("noResults", "Служащий(-ие) с именем "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedFirst", "selected");
                        break;
                    }
                else {
                        mv.addObject("employees", jdbc.getAllEmployeesByFirstNameAndRole(textValue, role));
                        mv.addObject("noResults", title+"(-ы) с именем "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedFirst", "selected");
                        break;
                    }
                
            case "LAST_NAME":
                if(role == 0) {
                        mv.addObject("employees", jdbc.getAllEmployeesByLastName(textValue));
                        mv.addObject("noResults", "Служащий(-ие) с фамилией "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedLast", "selected");
                        break;
                    }
                else {
                        mv.addObject("employees", jdbc.getAllEmployeesByLastNameAndRole(textValue, role));
                        mv.addObject("noResults", title+"(-ы) с фамилией "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedLast", "selected");
                        break;
                    }
                
            case "EMAIL":
                if(role == 0) {
                        mv.addObject("employees", jdbc.getAllEmployeesByEmail(textValue));
                        mv.addObject("noResults", "Служащий(-ие) с эл.почтой "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedEmail", "selected");
                        break;
                    }
                else {
                        mv.addObject("employees", jdbc.getAllEmployeesByEmailAndRole(textValue, role));
                        mv.addObject("noResults", title+"(-ы) с эл.почтой "+ textValue +" не найден(-ы)");
                        mv.addObject("selectedEmail", "selected");
                        break;
                    }
        }
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