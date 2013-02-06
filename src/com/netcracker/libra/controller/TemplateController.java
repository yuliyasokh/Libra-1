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
//import com.netcracker.libra.model.UserPreferences;
import com.netcracker.libra.model.Topic;
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
                 mv.addObject("link","template.html");
                 mv.addObject("message",message);
                 mv.addObject("title","Ошибка");
                 return mv;
             }
            Template lastTemplate=templateJDBC.getTemplate(templateJDBC.add(name));
            message="Тема с названием "+lastTemplate.getName()+" добавлена успешно";
            String link="<a href='addTopic.html?template="+lastTemplate.getTemplateId()+"'>Добавить тему вопросов к шаблону</a></br>"+
                    "<a href='showTemplates.html'>Вернуться к шаблонам</a>";
            mv.addObject("link",link);
            mv.addObject("message",message);
            mv.addObject("title","Успех!");
            return mv;
        } 
        else
        {
            mv.setViewName("messageView");
            mv.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mv.addObject("message","У Вас нету прав на эту страницу");
            mv.addObject("title","Ошибка");
            return mv;
        }
    }
      
    /**
     * Устанавливает активный шаблон
     * @param activeTemplate номер шаблона, который мы хотим установить активным
     */
    @RequestMapping(value="ActiveTemplate", method= RequestMethod.POST)
    public ModelAndView addActivePost(@RequestParam("activeTemplate") int activeTemplate)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            templateJDBC.setActive(activeTemplate);
            mav.setViewName("showTemplatesView");
            mav.addObject("activeTemplate",templateJDBC.getActive());
            mav.addObject("templates", templateJDBC.getAll());
            return mav;
        } 
        else
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mav.addObject("message","У Вас нету прав на эту страницу");
            mav.addObject("title","Ошибка");
            return mav;
        }
    }
    /**
     * Метод для отобпажения всех шаблонов. Он передает в вид список шаблонов.
     * При введение ссылки showTemplates.html вызывается этот метод.
     */
    @RequestMapping("showTemplates")
    public ModelAndView editTemplate()
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            //userPreferences.setUserId(12);
            mav.setViewName("showTemplatesView");
            mav.addObject("activeTemplate",templateJDBC.getActive());
            mav.addObject("templates", templateJDBC.getAll());
            return mav;
        } 
        else
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mav.addObject("message","У Вас нету прав на эту страницу");
            mav.addObject("title","Ошибка");
            return mav;
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
        Template aldt=templateJDBC.getTemplate(selTemplate);
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("messageView");
            String message=TemplateService.checkTemplate(name);
            if(!message.equals(""))
            {
                mav.addObject("link","editTemplate.html");
                mav.addObject("message",message);
                mav.addObject("title","Ошибка");
                return mav;
            }
            if(templateJDBC.existTemplate(selTemplate)==0)
            {
                mav.addObject("link","<a href='showTemplates.html'>Посмотреть все типы</a>");
                mav.addObject("message","Такого шаблона нету");
                mav.addObject("title","Ошибка");
                return mav; 
            }
            templateJDBC.update(selTemplate, name);
            mav.setViewName("showTemplatesView");
            List<Template> templates=templateJDBC.getAll();
            mav.addObject("templates", templates);
            return mav;
        } 
        else
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mav.addObject("message","У Вас нету прав на эту страницу");
            mav.addObject("title","Ошибка");
            return mav;
        }
    }
    /**
     * Метод, который передает в вид информацию о шаблоне(для предварительного просмотра),
     * перед удаленим удалить
     * @param templateId номер шаблона, который хотим удалить. Передается GET запросом
     */
    @RequestMapping(value="delTemplate", method= RequestMethod.GET)
    public ModelAndView delTemplate(@RequestParam("template") int templateId)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("delTemplateView");
            mav.addObject("template", templateId);
            List<Topic> topics=topicJDBC.getAll(templateId);
            int topicLength=topics.size();
            //getInfoUsers
            List<InfoForDelete> info=templateJDBC.getInfoForDelete(templateId);
            int infoSize=info.size();
            mav.addObject("topics", topics);
            mav.addObject("info", info);
            mav.addObject("infoSize",infoSize);
            return mav;
          } 
        else
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mav.addObject("message","У Вас нету прав на эту страницу");
            mav.addObject("title","Ошибка");
            return mav;
        }
    }
    /**
     * Обрабатывает запрос по удалению шаблона
     * @param templateId номер шаблона, который удаляется. передается POST запросом 
     */
     @RequestMapping(value="delSubmitTemplate", method= RequestMethod.POST)
    public ModelAndView delSubmitTemplate(@RequestParam("template") int templateId)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            if(templateJDBC.existTemplate(templateId)==0)
            {
                mav.addObject("link","<a href='showTemplates.html'>Посмотреть все типы</a>");
                mav.addObject("message","Такого шаблона нету");
                mav.addObject("title","Ошибка");
                return mav; 
            }
           templateJDBC.delete(templateId);
            mav.setViewName("showTemplatesView");
            mav.addObject("activeTemplate",templateJDBC.getActive());
            mav.addObject("templates", templateJDBC.getAll());
            return mav;
        } 
        else
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='/Libra/'>Вернуться назад</a>");
            mav.addObject("message","У Вас нету прав на эту страницу");
            mav.addObject("title","Ошибка");
            return mav;
        }
    }
}
