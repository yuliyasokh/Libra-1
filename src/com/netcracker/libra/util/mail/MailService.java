package com.netcracker.libra.util.mail;

import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static  JavaMailSender mailSender;
    private static VelocityEngine velocityEngine;

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public  JavaMailSender getmailSender() {
        return mailSender;
    }

    public  void setmailSender(JavaMailSender mailSender) {
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
    
    private static String getTemplateText(int index, Map model){
        switch (index) {
            case 0: 
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_1.vm", "UTF-8", model);
            case 1:
                return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template_2.vm", "UTF-8", model);
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
            MimeMessageHelper message = new MimeMessageHelper(mm);
                message.setTo((String) model.get("adress"));
                message.setText(getTemplateText((int)model.get("index"),model), true);
        }        
    }
}
