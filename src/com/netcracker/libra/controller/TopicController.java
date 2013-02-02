/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.TemplateJDBC;
import com.netcracker.libra.dao.TopicJDBC;
import com.netcracker.libra.dao.TypeJDBC;
import com.netcracker.libra.model.InfoForDelete;
import com.netcracker.libra.model.Template;
import com.netcracker.libra.model.Topic;
import com.netcracker.libra.model.TopicShow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.service.TemplateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Sashenka
 */
@Controller
public class TopicController
{
    int id;
 
    /**
     * Обрабатывает страницу по запросы addTopic
     * @param templateId имя get параметра
     * @return 
     */
    @RequestMapping(value="addTopic", method= RequestMethod.GET)
    public ModelAndView processGet(@RequestParam("template") int templateId)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addTopicView");
        id=templateId;
        mav.addObject("id",id);
        mav.addObject("topics", (new TopicJDBC()).getAll(templateId));
        return mav;
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
    @RequestParam("require") int require)//selectRequire
    {
        TopicJDBC topicJDBC=new TopicJDBC();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageView");
        String message=TemplateService.checkTopic(name);
         message+=TemplateService.checkComment(comments);
         if(!message.equals(""))
         {
             mav.addObject("link","showTopics.html");
             mav.addObject("message",message);
             mav.addObject("title","Ошибка");
             return mav;
         }
        Topic tt=topicJDBC.getTopic(topicJDBC.addTopic(name, comments, id, selTopics, require));
        mav.addObject("link","<a href='showTopics.html'>Просмотреть топики</a>");
        mav.addObject("message","Тема с именем "+tt.getName()+" успешно добавлена");
        mav.addObject("title","Успех!");
        return mav;
    }
    
    
    /**
     *  пост запрос showSubmitTopic. Обрабатывает какую калонку мы хотим отредактировать
     * @param selTopic
     * @return 
     */
    @RequestMapping(value="showSubmitTopic", method= RequestMethod.POST)
    public ModelAndView editPost(
    @RequestParam("selTopic") int selTopic)
    {
        TopicJDBC topicJDBC=new TopicJDBC();
        Topic topic=topicJDBC.getTopic(selTopic);
        ModelAndView mav = new ModelAndView();
        mav.addObject("topic",topic);//выбранный топик, который хотим отредактировать
        mav.addObject("parentTopic",topic.getParentTopic());
        
        List<Topic> topics=topicJDBC.getAll(topic.getTemplate());
        mav.addObject("topics",topics);
        int t=topic.getTemplate();
        mav.addObject("teplateId",t);
        mav.setViewName("showTopicView");
        return mav;
    }
    /**
     * Вызывается при заходе по ссылке showTopics.html
     * Переедает информацию о темах
     */
    @RequestMapping("showTopics")
    public ModelAndView showTopics()
    {
        TemplateJDBC templateJDBC=new TemplateJDBC();
        ModelAndView mav = new ModelAndView();
        List<TopicShow> topicList=(new TopicJDBC()).getTopicsShow();
        mav.addObject("templates",templateJDBC.getAll());
        mav.addObject("topics",topicList);
        mav.setViewName("showTopicsView");
        
        return mav;
    }
    /**
     * Передает информацию о теме
     * @param topicId номер темы
     */
    @RequestMapping(value="showTopic", method= RequestMethod.GET)
    public ModelAndView showGet(@RequestParam("topic") int topicId)
    {
        TopicJDBC topicJDBC=new TopicJDBC();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showTopicView");
        Topic t=topicJDBC.getTopic(topicId);
        mav.addObject("topics",topicJDBC.getAll(t.getTemplate()));
        mav.addObject("parentTopic",t.getParentTopic());
        mav.addObject("template",t.getTemplate());
        mav.addObject("topic", (new TopicJDBC()).getTopic(topicId));
        return mav;
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
        TopicJDBC topicJDBC=new TopicJDBC();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageView");
        String message=TemplateService.checkTopic(name);
         message+=TemplateService.checkComment(comments);
         if(!message.equals(""))
         {
             mav.addObject("link","showTopics.html");
             mav.addObject("message",message);
             mav.addObject("title","Ошибка");
             return mav;
         }
        topicJDBC.updateTopic(topic, name, comments, template, selTopics, require);
        mav.addObject("message","Топик успешно изменен");
        mav.addObject("link","<a href='showTopics.html'>Просмотреть топики</a>");
        return mav;
    }
    /**
     * Передает информацию для простомра темы перед удалением
     * @param topicId
     */
    @RequestMapping(value="delTopic", method= RequestMethod.GET)
    public ModelAndView delTopic(@RequestParam("topic") int topicId)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("delTopicView");
        mav.addObject("topic", topicId);
        //getInfoUsers
        List<InfoForDelete> info=(new TopicJDBC()).getInfoForDelete(topicId);
        int infoSize=info.size();
        mav.addObject("info", info);
        mav.addObject("infoSize",infoSize);
        return mav;
    }
    /**
     * Обрабатывает запрос по удалению темы
     * @param topicId номер удаляемой темы. передается POST запросом
     */
     @RequestMapping(value="delSubmitTopic", method= RequestMethod.POST)
    public ModelAndView delSubmitTemplate(@RequestParam("topic") int topicId)
    {
        ModelAndView mav = new ModelAndView();
       (new TopicJDBC()).deleteTopic(topicId);
        TemplateJDBC templateJDBC=new TemplateJDBC();
        List<TopicShow> topicList=(new TopicJDBC()).getTopicsShow();
        mav.addObject("templates",templateJDBC.getAll());
        mav.addObject("topics",topicList);
        mav.setViewName("showTopicsView");
        return mav;
    }
}
