/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netcracker.libra.dao.TopicJDBC;
import com.netcracker.libra.dao.ColumnsJDBC;
import com.netcracker.libra.model.Topic;
import com.netcracker.libra.dao.TypeJDBC;
import com.netcracker.libra.model.Columns;
import com.netcracker.libra.model.ColumnsShow;
import com.netcracker.libra.model.InfoForDelete;
import com.netcracker.libra.model.Type;
import com.netcracker.libra.service.TemplateService;
import java.util.List;
/**
 *
 * @author Sashenka
 */
@Controller
public class ColumnController 
{
    TypeJDBC typeJDBC=new TypeJDBC();
    ColumnsJDBC columnsJDBC=new ColumnsJDBC();
    TopicJDBC topicJDBC=new TopicJDBC();
    int topicId;
    /**
     * Метод который передает данные на страничку для
     * формирования странички добавления колонки
     * @param topic номер темы
     */
    @RequestMapping(value="addColumn", method= RequestMethod.GET)    
    public ModelAndView processGet(@RequestParam("topic") int topic)
    {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addColumnView");
        List<Type> types=typeJDBC.getAll();
        if(topicJDBC.existTopic(topic)==0)
        {
            mav.addObject("link","<a href='showColumns.html?topic="+topicId+"'>Посмотреть все типы</a>");
            mav.addObject("message","Такой темы нету");
            mav.addObject("title","Ошибка");
            return mav; 
        }
        mav.addObject("topic",topicJDBC.getTopic(topic));
        topicId=topic;
        mav.addObject("id",topic);
        mav.addObject("types",types);
        return mav;
    }
    
    /**
     * Обрабатывает запрос по добавлению новой колонки
     * @param name имя колонки
     * @param selType номер типа колонки
     */
    @RequestMapping(value="SubmitColumn", method= RequestMethod.POST)
    public ModelAndView processPost(@RequestParam("name") String name,
    @RequestParam("selType") int selType)
    {    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageView");
        String message=TemplateService.checkColumn(name);
         if(!message.equals(""))
         {
             mav.addObject("link","addColumn.html?topic="+topicId);
             mav.addObject("message",message);
             mav.addObject("title","Ошибка");
             return mav;
         }
         if(typeJDBC.existType(selType)==0)
         {
            mav.addObject("link","<a href='addColumn.html?topic="+topicId+"'>Вернуться назад</a>");
             mav.addObject("message","Нету такого типа");
             mav.addObject("title","Ошибка");
             return mav;   
         }
        Columns col=columnsJDBC.getColumn(columnsJDBC.add(topicId, name, selType, 1));
        mav.addObject("link","<a href='showColumns.html?topic="+topicId+"'>Вернуться назад</a>");
        mav.addObject("message","Колонка с именем "+col.getName()+" успешно добавлена");
        mav.addObject("title","Успех!");
        return mav;
    }
    
    /**
     * Метод передает данные о существубщих колонках
     * Вызывается при запросе по ссылке "showColumns.html"
     */
   /* @RequestMapping("showColumns")
    public ModelAndView showTopics()
    {
        ModelAndView mav = new ModelAndView();
        List<ColumnsShow> columns=columnsJDBC.getColumnsShow(topicId);
        mav.addObject("columns",columns);
        mav.addObject("topics",topicJDBC.getAllTopics());
        mav.setViewName("showColumnsView");       
        return mav;
    }
    */
    @RequestMapping(value="showColumns", method= RequestMethod.GET)
    public ModelAndView showGetTopics(@RequestParam("topic") int topic)
    {
        topicId=topic;
        ModelAndView mav = new ModelAndView();
        List<ColumnsShow> columns=columnsJDBC.getColumnsShow(topicId);
        mav.addObject("columns",columns);
        mav.addObject("topic", topicJDBC.getTopic(topic));
        
        List<Type> types=typeJDBC.getAll();
        mav.addObject("types",types);
        mav.setViewName("showColumnsView");       
        return mav;
    }
    
    /**
     * Передает информацию о колонке перед ее редактированием
     * @param column номер колонки
     */
    @RequestMapping(value="editColumn", method= RequestMethod.GET)
    public ModelAndView editColumn(@RequestParam("column") int column)
    {
        ModelAndView mav = new ModelAndView();
        if(columnsJDBC.existColumn(column)==0)
        {
            mav.addObject("link","<a href='showColumns.html?topic="+topicId+"'>Посмотреть все типы</a>");
            mav.addObject("message","Такой темы нету");
            mav.addObject("title","Ошибка");
            return mav; 
        }
        Columns c=columnsJDBC.getColumn(column);
        Topic topic=topicJDBC.getTopic(c.getTopicId());
        mav.setViewName("showColumnView");
        List<Type> types=typeJDBC.getAll();
        mav.addObject("types",types);
        mav.addObject("topic",topic);
        mav.addObject("column",c);
        mav.addObject("type",c.getTypeId());
        return mav;
    }
    /**
     * Метод обрабатывает запрос по редактированию колонки.
     * @param name новое имя колонки
     * @param selType номер типа
     * @param topic номер темы
     * @param column колонка
     * @param require кем добавлена
     */
    @RequestMapping(value="showColumns", method= RequestMethod.POST)
    public ModelAndView editPost(@RequestParam("name") String name,
    @RequestParam("selType") int selType,
            @RequestParam("topic") int topic,
            @RequestParam("column") int column,
            @RequestParam("require") int require)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageView");
        String message=TemplateService.checkColumn(name);
         if(!message.equals(""))
         {
             mav.addObject("link","addColumn.html?topic="+topicId);
             mav.addObject("message",message);
             mav.addObject("title","Ошибка");
             return mav;
         }
         //update(int id, int topicId,String name, int typeId, int require) 
         if(typeJDBC.existType(selType)==0)
         {
            mav.addObject("link","<a href='addColumn.html?topic="+topicId+"'>Вернуться назад</a>");
             mav.addObject("message","Нету такого типа");
             mav.addObject("title","Ошибка");
             return mav;   
         }
         if(topicJDBC.existTopic(topic)==0)
         {
            mav.addObject("link","<a href='addColumn.html?topic="+topicId+"'>Вернуться назад</a>");
             mav.addObject("message","Нету такой темы");
             mav.addObject("title","Ошибка");
             return mav;   
         }
        columnsJDBC.update(column, topic, name, selType, require);
        List<ColumnsShow> columns=columnsJDBC.getColumnsShow(topicId);
        mav.addObject("columns",columns);
        //mav.addObject("topics",topicJDBC.getAllTopics());
        mav.setViewName("showColumnsView");
        return mav;
    }
    /**
     * Метод передает информацию о колнке для 
     * предварительно просмотра ее колонки перед удалением
     * @param columnId номер колонки
     */
    @RequestMapping(value="delColumn", method= RequestMethod.GET)
    public ModelAndView delType(@RequestParam("column") int columnId)
    {
        ModelAndView mav = new ModelAndView();
        if(columnsJDBC.existColumn(columnId)==0)
        {
            mav.setViewName("messageView");
            mav.addObject("link","<a href='showColumns.html?topic="+topicId+"'>Посмотреть все типы</a>");
            mav.addObject("message","Такой темы нету");
            mav.addObject("title","Ошибка");
            return mav; 
        }
        mav.setViewName("delColumnView");          
        mav.addObject("column", columnId);
        //getInfoUsers
        //            List<InfoForDelete> info=columnsJDBC.getInfoForDelete(columnId);
        //int infoSize=info.size();
        //mav.addObject("info", info);
        //mav.addObject("infoSize",infoSize);
        return mav;
    }
    /**
     * Обрабатывает запрос по удалению колонки.
     * @param column номер колонки, который хотим удалить. Передается в POST запросе.
     */
    @RequestMapping(value="delSubmitColumn", method= RequestMethod.POST)
    public ModelAndView delSubmitType(@RequestParam("column") int column)
    {     
        ModelAndView mav = new ModelAndView();
        if(columnsJDBC.existColumn(column)==0)
        {
            mav.setViewName("messageView");
            return message("<a href='showColumns.html?topic="+topicId+"'>Посмотреть все типы</a>","Такой темы нету","Ошибка"); 
        }
        columnsJDBC.delete(column);
        List<ColumnsShow> columns=columnsJDBC.getColumnsShow(topicId);
        mav.addObject("columns",columns);
      //  mav.addObject("topics",topicJDBC.getAllTopics());
        mav.setViewName("showColumnsView");
        return mav;
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