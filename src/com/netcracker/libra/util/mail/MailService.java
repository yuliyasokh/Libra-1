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
    
    
    public static void sendMessage(final String adress, final String user, final String code){
        MimeMessagePreparator preparator = new MimeMessagePreparator(){

            @Override
            public void prepare(MimeMessage mm) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mm);
                message.setTo(adress);
                Map model = new HashMap();
                model.put("user", user);
                model.put("code", code);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                            velocityEngine, "/template_1.vm", "UTF-8", model);
                message.setText(text);
                System.out.println(adress);
            }            
        };
        mailSender.send(preparator);        
    }
}
