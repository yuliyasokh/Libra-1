/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class InterviewResult 
{
    String fio;
    int mark;
    String comments;
    int userId;

    public int getUserId() 
    {
        return userId;
    }

    public void setUserId(int userId) 
    {
        this.userId = userId;
    }
    
    
    public String getComments() 
    {
        return comments;
    }

    public String getFio() 
    {
        return fio;
    }

    public int getMark() 
    {
        return mark;
    }

    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public void setMark(int mark) 
    {
        this.mark = mark;
    }

    public void setFio(String fio) 
    {
        this.fio = fio;
    }
    
}
