package com.netcracker.libra.controller;

import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.registration.RegistrationService;
import com.netcracker.libra.model.registration.regData;
import com.netcracker.libra.util.security.Security;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author MorrDeck
 */
public class RegistrationController extends SimpleFormController {
    
    private RegistrationService RegService;

    public void setRegService(RegistrationService RegService) {
        this.RegService = RegService;
    }
    
    public RegistrationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(regData.class);
        setCommandName("regData");
        setSuccessView("RegsuccessView");
        setFormView("RegView");
        
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        regData data = (regData) command;
        StudentJDBC student = new StudentJDBC();
        if (RegistrationService.checkName(data.getName())
                && RegistrationService.checkSurname(data.getSurname())
                && RegistrationService.checkEmail(data.getEmail())
                && RegistrationService.checkPassword(data.getPassword())) {
            student.create(data.getName(), data.getSurname(), data.getEmail(), Security.getMD5hash(data.getPassword()));
            mv.setViewName("RegsuccessView");
            mv.addObject("Name", data.getName());
            mv.addObject("Surname", data.getSurname());
            mv.addObject("Email", data.getEmail());            
        }else{
            mv.setViewName("RegFailedView");
            String err = "";
            if(!RegistrationService.checkName(data.getName())){
                err += "Неправильно указано имя!\n";
            }
            if(!RegistrationService.checkSurname(data.getSurname())){
                err += "Неправильно указана фамилия!\n";
            }
            if(!RegistrationService.checkEmail(data.getEmail())){
                err += "Неправильно указан почтовый адрес!\n";
            }
            if(!RegistrationService.checkPassword(data.getPassword())){
                err += "Пароль не отвечает требованиям!\n";
            }
            mv.addObject("error",err);
        }
        

        return mv;
    }
     
}
