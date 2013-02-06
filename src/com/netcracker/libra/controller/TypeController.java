/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.TypeJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.InfoForDelete;
import com.netcracker.libra.model.Type;
import com.netcracker.libra.service.TemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sashenka
 */
@Controller
public class TypeController 
{
    TypeJDBC typeJDBC=new TypeJDBC();
    
    @Autowired
    UserPreferences userPreferences;
    /**
     * Обрабатывает запрос по добавлению нового типа.
     * @param name имя типа, который мы хотим добавить. Передается в POST запросе.
     */
    @RequestMapping(value="SubmitType", method= RequestMethod.POST)
    public ModelAndView processPost(@RequestParam("name") String name)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
                mav.setViewName("messageView");
                    String message=TemplateService.checkType(name);
                if(!message.equals(""))
                     {
                         mav.addObject("link","<a href='addType.html'>Вернуться назад</a>");
                         mav.addObject("message",message);         
                         mav.addObject("title","Ошибка");
                         return mav;
                    }
                mav.setViewName("showTypeView");    
                    Type t=typeJDBC.getType(typeJDBC.add(name));
                    List<Type> types=typeJDBC.getAll();
                    mav.addObject("types", types);
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
     * Метод передает данные о существующих типах
     * Вызывается при запросе по ссылке "showTypes.html"
     */
    @RequestMapping("showTypes")
    public ModelAndView showTypes()
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            mav.setViewName("showTypeView");
            List<Type> types=typeJDBC.getAll();
            mav.addObject("types", types);
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
     * Обрабатывает запрос по редактированию типа
     * @param name новое имя типа
     * @param selType номер типа, который мы хотим отредактировать. передается POST запросом.
     */
    @RequestMapping(value="showTypes", method= RequestMethod.POST)
    public ModelAndView editSummitPost(@RequestParam("name") String name,
    @RequestParam("selType") int selType)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            if(typeJDBC.existType(selType)==0)
                 {
                     mav.addObject("link","<a href='showTypes.html'>Посмотреть типы</a>");
                     mav.addObject("message","Такого типа нету");
                     mav.addObject("title","Ошибка");
                     return mav;
                 }
                Type t=(new TypeJDBC()).getType(selType);       
                mav.setViewName("messageView");
                String message=TemplateService.checkType(name);
                 if(!message.equals(""))
                 {
                     mav.addObject("link","<a href='showTypes.html'>Посмотреть типы</a>");
                     mav.addObject("message",message);
                     mav.addObject("title","Ошибка");
                     return mav;
                 }
                 typeJDBC.update(selType, name);
                 mav.setViewName("showTypeView");
                 mav.addObject("types", typeJDBC.getAll());
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
     * Перредается информацию на страницу для
     * предварительного просмотра типа перед удалением.
     * @param typeId номер типа
     */
    @RequestMapping(value="delType", method= RequestMethod.GET)
    public ModelAndView delType(@RequestParam("type") int typeId)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            if(typeJDBC.existType(typeId)==0)
                {
                    mav.addObject("link","<a href='showTypes.html'>Посмотреть все типы</a>");
                    mav.addObject("message","Нету такого типа");
                    mav.addObject("title","Ошибка");
                    return mav; 
                }
                mav.setViewName("delTypeView");
                mav.addObject("type", typeId);
                //getInfoUsers
                List<InfoForDelete> info=typeJDBC.getInfoForDelete(typeId);
            int infoSize=info.size();
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
     * Обрабатывает запрос по удалению типа
     * @param typeId номер типа, который удаляем. Он передается POST запросм
     */
     @RequestMapping(value="delSubmitType", method= RequestMethod.POST)
    public ModelAndView delSubmitType(@RequestParam("type") int typeId)
    {
        ModelAndView mav = new ModelAndView();
        if(userPreferences.accessLevel==1)
        {
            if(typeJDBC.existType(typeId)==0)
                {
                    mav.addObject("link","<a href='showTypes.html'>Посмотреть все типы</a>");
                    mav.addObject("message","Нету такого типа");
                    mav.addObject("title","Ошибка");
                    return mav; 
                }        
                typeJDBC.delete(typeId);
                mav.setViewName("showTypeView");
                List<Type> types=typeJDBC.getAll();
                mav.addObject("types", types);
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
