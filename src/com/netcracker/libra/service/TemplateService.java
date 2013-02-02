/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.service;

/**
 * 
 * @author Sashenka
 */
public class TemplateService 
{
    /**
     * Метод выдает текс ошибки, если вводить 
     * имя шаблона длинной больше 100 символов или не вводить имя.
     * Если ошибки нету, то возвращает пустую строку
     * @param name имя шаблона
     * @return возвращает текст ошибки
     */
    public static String checkTemplate(String name) 
    {
        if(name.length()>100)
        {
            return "<p>Имя шаблона должно быть меньше 100 символов</p>";
        }
        if(name.length()==0)
        {
            return  "<p>Введите имя шаблона</p>";
        }
        return "";
    }
    /**
     * Метод выдает текс ошибки, если вводить 
     * имя темы вопросы длинной больше 100 символов или не вводить имя.
     * Если ошибки нету, то возвращает пустую строку
     * @param name имя темы вопроса
     * @return возвращает текст ошибки
     */
    public static String checkTopic(String name) 
    {
        if(name.length()>100)
        {
            return "<p>Имя темы вопроса должно быть меньше 100 символов</p>";
        }
        if(name.length()==0)
        {
                return "<p>Введите имя темы</p>";
        }
        return "";
    }
    /**
     * Метод выдает текс ошибки, если вводить 
     * коментарий к вопросу длинной больше 500 символов или не вводить имя.
     * Если ошибки нету, то возвращает пустую строку
     * @param name комментарий
     * @return возвращает текст ошибки
     */
    public static String checkComment(String name) 
    {
        if(name.length()>100)
        {
            return "<p>Комментарий к теме вопроса должен быть меньше 500 символов</p>";
        }
        return "";
    }
    /**
     * Метод выдает текс ошибки, если вводить 
     * колонку с именем длина которого больше 50 символов или не вводить имя.
     * Если ошибки нету, то возвращает пустую строку
     * @param name имя колонки
     * @return возвращает текст ошибки
     */
    public static String checkColumn(String name) 
    {
        if(name.length()>100)
        {
            return "<p>Имя колонки должно быть меньше 50 символов</p>";
        }
        if(name.length()==0)
        {
            return "<p>Введите имя колонки</p>";
        }
        return "";
    }
    /**
     * Метод выдает текс ошибки, если вводить 
     * длинной названия типа больше 15 символов или не вводить имя.
     * Если ошибки нету, то возвращает пустую строку
     * @param name тип
     * @return возвращает текст ошибки
     */
    public static String checkType(String name)
    {
        if(name.length()>15)
        {
            return "<p>Должно быть меньше 15 символов</p>";
        }
        if(name.length()==0)
        {
            return "<p>Должно быть больше 0</p>";
        }
        return "";
    }
}
