/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class Columns 
{
    private int columnId;
    private int topicId;
    private String name;
    private int TypeId;
    private int required;

    /**
     * Метод для получения Id колонки
     * @return целое число
     */
    public int getColumnId() 
    {
        return columnId;
    }

    public void setColumnId(int columnId) 
    {
        this.columnId = columnId;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getTopicId() 
    {
        return topicId;
    }

    public void setTopicId(int topicId) 
    {
        this.topicId = topicId;
    }

    public int getRequired() 
    {
        return required;
    }

    public void setRequired(int required) 
    {
        this.required = required;
    }

    public int getTypeId() 
    {
        return TypeId;
    }

    public void setTypeId(int TypeId) 
    {
        this.TypeId = TypeId;
    }
    
}
