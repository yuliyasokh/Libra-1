/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.model.Template;
import com.netcracker.libra.dao.TemplateJDBC;
import com.netcracker.libra.dao.TopicJDBC;
import com.netcracker.libra.dao.UserPreferences;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netcracker.libra.service.TemplateService;
import org.springframework.web.bind.annotation.RequestParam;
import com.netcracker.libra.model.InfoForDelete;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Sashenka
 */
@Controller
public class TemplateController
{    
    TemplateJDBC templateJDBC=new TemplateJDBC();
    TopicJDBC topicJDBC = new TopicJDBC();
    
    @Autowired
    UserPreferences userPreferences;
    /**
     * Метод обрабатывает запрос по добавлению нового шаблона.
     * @param name имя нового шаблона
     */
    @RequestMapping(value="SubmitTemplate", method= RequestMethod.POST)
    public ModelAndView addPost(@RequestParam("name") String name)
    {
        ModelAndView mv = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mv.setViewName("messageView");
            String message=TemplateService.checkTemplate(name);
            if(!message.equals(""))
            {
                 return message("template.html", message, "Ошибка");
            }
            Template lastTemplate=templateJDBC.getTemplate(templateJDBC.add(name));
            return showTemplate();
        } 
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
      
    /**
     * Устанавливает активный шаблон
     * @param activeTemplate номер шаблона, который мы хотим установить активным
     */
    @RequestMapping(value="ActiveTemplate", method= RequestMethod.POST)
    public ModelAndView addActivePost(@RequestParam("activeTemplate") int activeTemplate)
    {
        if(userPreferences.accessLevel==1)
        {
            templateJDBC.setActive(activeTemplate);
            return showTemplate();
        } 
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Метод для отображения всех шаблонов. Он передает в вид список шаблонов.
     * При введение ссылки showTemplates.html вызывается этот метод.
     */
    @RequestMapping("showTemplates")
    public ModelAndView showTemplate()
    {
       if(userPreferences.accessLevel==1)
        { 
            ModelAndView mav = new ModelAndView();
            mav.setViewName("showTemplatesView");
            mav.addObject("activeTemplate",templateJDBC.getActive());
            mav.addObject("templates", templateJDBC.getAll());
            return mav;
        } 
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    /**
     * Метод который обрабатывает запрос на редактирование шаблона.
     * @param name новое имя шаблона, которое передается POST запросом
     * @param selTemplate номер шаблона, который мы хотим отредактировать, 
     * который передается POST запросом
     */
    @RequestMapping(value="showTemplates", method= RequestMethod.POST)
    public ModelAndView editPost(@RequestParam("name") String name,
    @RequestParam("selTemplate") int selTemplate)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("messageView");
            String message=TemplateService.checkTemplate(name);
            if(!message.equals(""))
            {
                return message("<a href='showTemplates.html'>Назад</a>", message, "Ошибка");
            }
            if(templateJDBC.existTemplate(selTemplate)==0)
            {
                return message("<a href='showTemplates.html'>Посмотреть все типы</a>", "Такого шаблона нету", "Ошибка"); 
            }
            templateJDBC.update(selTemplate, name);
            return showTemplate();
        } 
         else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Метод, который передает в вид информацию о шаблоне(для предварительного просмотра),
     * перед удаленим удалить
     * @param templateId номер шаблона, который хотим удалить. Передается GET запросом
     */
    @RequestMapping(value="delTemplate", method= RequestMethod.POST)
    public ModelAndView delTemplate(@RequestParam("templates[]") int[] templates)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {        
            for(int i=0; i<templates.length;i++)
            {
                if(templateJDBC.existTemplate(templates[i])==0)
                {                
                    return message("<a href='showTemplates.html'>Назад</a>", "Нету такого шаблона", "Ошибка"); 
                }  
            }
            List<InfoForDelete> info=templateJDBC.getInfoForDelete(templates);
            int infoSize=info.size();
            mav.setViewName("delTemplateView");
            mav.addObject("templates", templates);
            mav.addObject("info", info);
            mav.addObject("infoSize",infoSize);
            return mav;
          } 
         else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Обрабатывает запрос по удалению шаблона
     * @param templateId номер шаблона, который удаляется. передается POST запросом 
     */
     @RequestMapping(value="delSubmitTemplate", method= RequestMethod.POST)
    public ModelAndView delSubmitTemplate(@RequestParam("templates[]") int[] templates)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            for(int i=0;i<templates.length;i++)
            {
                if(templateJDBC.existTemplate(templates[i])==0)
                {
                    return message("<a href='showTemplates.html'>Посмотреть все типы</a>", "Такого шаблона нету", "Ошибка"); 
                }
                templateJDBC.delete(templates[i]);
            }
            return showTemplate();
        } 
         else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
     
     public ModelAndView message(String link,String message,String title)
     {
         ModelAndView mav=new ModelAndView();
         mav.setViewName("messageView");
         mav.addObject("link",link);
         mav.addObject("message",message);
         mav.addObject("title",title);
         return mav;
     }
}
