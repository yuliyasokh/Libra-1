/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.TemplateJDBC;
import com.netcracker.libra.dao.TopicJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.InfoForDelete;
import com.netcracker.libra.model.Topic;
import com.netcracker.libra.model.TopicShow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.service.TemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Sashenka
 */
@Controller
public class TopicController
{
    //int id;
    TopicJDBC topicJDBC = new TopicJDBC();
    TemplateJDBC templateJDBC=new TemplateJDBC();
    
    @Autowired
    UserPreferences userPreferences;
    
    /**
     * Обрабатывает страницу по запросы addTopic
     * @param templateId имя get параметра
     * @return 
     */
    @RequestMapping(value="addTopic", method= RequestMethod.GET)
    public ModelAndView processGet(@RequestParam("template") int templateId)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("addTopicView");
            mav.addObject("id",templateId);
            mav.addObject("topics", topicJDBC.getAll(templateId));
            return mav;
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    
    /**
     * Обрабатывает запрос по добавлению темы
     * @param name имя темы
     * @param comments комментарий
     * @param selTopics родительский топик
     * @param require позволительны ли другие ответы
     */
    @RequestMapping(value="SubmitTopic", method= RequestMethod.POST)
    public ModelAndView addPost(@RequestParam("name") String name,
    @RequestParam("comments") String comments,
    @RequestParam("selTopics") int selTopics,
    @RequestParam("require") int require,
    @RequestParam("templateId") int templateId)//selectRequire
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("messageView");
            String message=TemplateService.checkTopic(name);
             message+=TemplateService.checkComment(comments);
             if(!message.equals(""))
             {
                 return message("showTopics.html", message, "Ошибка");
             }
             int t=topicJDBC.addTopic(name, comments, templateId, selTopics, require);
            return showTopics();
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
     
    /**
     *  пост запрос showSubmitTopic. Обрабатывает какую калонку мы хотим отредактировать
     * @param selTopic
     * @return 
     */
    @RequestMapping(value="showSubmitTopic", method= RequestMethod.GET)
    public ModelAndView editPost(
    @RequestParam("selTopic") int selTopic)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {        
            Topic topic=topicJDBC.getTopic(selTopic);
            mav.addObject("topic",topic);//выбранный топик, который хотим отредактировать
            mav.addObject("parentTopic",topic.getParentTopic());
            List<Topic> topics=topicJDBC.getAll(topic.getTemplate());
            mav.addObject("topics",topics);
            mav.addObject("teplateId",topic.getTemplate());
            mav.setViewName("showTopicView");
            return mav;
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Вызывается при заходе по ссылке showTopics.html
     * Переедает информацию о темах
     */
    @RequestMapping("showTopics")
    public ModelAndView showTopics()
    {       
        if(userPreferences.accessLevel==1)
        {
            ModelAndView mav = new ModelAndView();
            List<TopicShow> topicList=(new TopicJDBC()).getTopicsShow();
            mav.addObject("templates",templateJDBC.getAll());
            mav.addObject("topics",topicList);
            mav.addObject("userid",userPreferences.accessLevel);
            mav.setViewName("showTopicsView");
            return mav;
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Обрабатывает запрос по редактированию темы
     * @param name имя темы
     * @param comments комментарий
     * @param selTopics выбраная тема
     * @param require можно ли добавлять свои ответы
     * @param topic тема
     * @param template номер шаблона
     */
    @RequestMapping(value="editSubmitTopic", method= RequestMethod.POST)
    public ModelAndView editSubmitPost(@RequestParam("name") String name,
    @RequestParam("comments") String comments,
    @RequestParam("selTopics") int selTopics,
    @RequestParam("require") int require,
    @RequestParam("topic") int topic,
    @RequestParam("template") int template)//selectRequire
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("messageView");
            String message=TemplateService.checkTopic(name);
             message+=TemplateService.checkComment(comments);
             if(!message.equals(""))
             {
                 return message("<a href='showTopics.html'>Вернуться к топикам</a>", message, "Ошибка");
             }
            topicJDBC.updateTopic(topic, name, comments, template, selTopics, require);
            return showTopics();
        }
        else
        {
            return message("<a href='/Libra/'>Вернуться назад</a>","У Вас нету прав на эту страницу","Ошибка");
        }
    }
    /**
     * Передает информацию для простомра темы перед удалением
     * @param topicId
     */
    @RequestMapping(value="delTopic", method= RequestMethod.POST)
    public ModelAndView delTopic(@RequestParam("topics[]") int[] topics)
    {  
        if(userPreferences.accessLevel==1)
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("delTopicView");
            mav.addObject("topics", topics);
            List<InfoForDelete> info=(new TopicJDBC()).getInfoForDelete(topics);
            int infoSize=info.size();
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
     * Обрабатывает запрос по удалению темы
     * @param topicId номер удаляемой темы. передается POST запросом
     */
     @RequestMapping(value="delSubmitTopic", method= RequestMethod.POST)
    public ModelAndView delSubmitTemplate(@RequestParam("topics[]") int[] topics)
    {
        if(userPreferences.accessLevel==1)
        {
            for(int i=0;i<topics.length;i++)
            {
                topicJDBC.deleteTopic(topics[i]);
            }
            return showTopics();
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
