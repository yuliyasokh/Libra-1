package com.netcracker.libra.util.mail;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author MorrDeck
 */
@Service("mailService")

public class MailService implements IMailService {
    private static JavaMailSender mailSender;
    private static VelocityEngine velocityEngine;
    private static ServletContext servletContext;

    public  void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public  ServletContext getServletContext() {
        return servletContext;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public  JavaMailSender getMailSender() {
        return mailSender;
    }

    public  void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    
    public static void sendConfirmRegistrationMessage(String adress, String user, String code){
        Map model = new HashMap();
        model.put("index",0);
        model.put("adress", adress);        
        model.put("user", user);        
        model.put("code", code);  
        
        MimeMessagePreparator preparator = new message(model);
        mailSender.send(preparator);        
    }
    
    public static void sendSuccessRegistrationMessage(String adress, String user){
        Map model = new HashMap();
        model.put("index",1);
        model.put("adress", adress);        
        model.put("user", user);      
        
        MimeMessagePreparator preparator = new message(model);
        mailSender.send(preparator); 
    }
    
    public static void sendFormMessage(String adress, String user, int id){
        Map model = new HashMap();
        model.put("index",2);
        model.put("adress", adress);        
        model.put("user", user);
        model.put("id", id);
        MimeMessagePreparator preparator = new messageWithAttachment(model);
        mailSender.send(preparator); 
    }
    
    public static void sendNotificationMessageForInterviewers(int id[]){
        Map model = new HashMap();
        String adress[]= null;
        
        
        model.put("index",3);
        model.put("adress", adress); 
        model.put("date", adress);
        model.put("startTime", adress);
        model.put("finishTime", adress);
        MimeMessagePreparator preparator = new messageForInterviewers(model);
        mailSender.send(preparator); 
    }
    
    public static void sendNoticeMessage(int[] id){
        
    }
    
    private static String getTemplateText(int index, Map model){
        switch (index) {
            case 0: 
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_1.vm", "UTF-8", model);
            case 1:
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_2.vm", "UTF-8", model);
            case 2:
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_3.vm", "UTF-8", model);
            case 3:
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_4.vm", "UTF-8", model);
            default:
                return null;
        }        
    }
    
    
    private static class message implements  MimeMessagePreparator {
        Map model = null;

        public message(Map model) {
            this.model = model;
        }        

        @Override
        public void prepare(MimeMessage mm) throws Exception {
            
            MimeMessageHelper message = new MimeMessageHelper(mm,"UTF-8");
                message.setTo((String) model.get("adress"));   
                message.setText(getTemplateText((int)model.get("index"),model), true);
        }        
    }
    
    private static class messageWithAttachment implements  MimeMessagePreparator {
        Map model = null;

        public messageWithAttachment(Map model) {
            this.model = model;
        }        

        @Override
        public void prepare(MimeMessage mm) throws Exception {
            MimeMessageHelper message = new MimeMessageHelper(mm, true,"UTF-8");
                message.setTo((String) model.get("adress"));                
                message.setText(getTemplateText((int)model.get("index"),model), true);
                File file = new  File(servletContext.getRealPath("WEB-INF/forms/form"+model.get("id")+".pdf"));
                message.addAttachment("Your_completed_questionnaire",file) ;
        }        
    }
    
    private static class messageForInterviewers implements MimeMessagePreparator{
        Map model = null;

        public messageForInterviewers(Map model) {
            this.model = model;
        }     

        @Override
        public void prepare(MimeMessage mm) throws Exception {
            MimeMessageHelper message = new MimeMessageHelper(mm,"UTF-8");
            message.setTo((String[]) model.get("adress"));
            message.setText(getTemplateText((int)model.get("index"),model), true);
        }
        
    }
}
