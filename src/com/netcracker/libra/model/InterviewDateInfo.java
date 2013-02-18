/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class InterviewDateInfo 
{
    String day;
    String hTime;
    int id;
    int freePlaces;
    int correct;

    public int getCorrect() 
    {
        return correct;
    }

    public void setCorrect(int correct) 
    {
        this.correct = correct;
    }
    
    
    public String getDay() 
    {
        return day;
    }

    public int getFreePlaces() 
    {
        return freePlaces;
    }

    public int getId() 
    {
        return id;
    }

    public String gethTime() 
    {
        return hTime;
    }

    public void sethTime(String hTime) 
    {
        this.hTime = hTime;
    }

    public void setDay(String day) 
    {
        this.day = day;
    }

    public void setFreePlaces(int freePlaces) 
    {
        this.freePlaces = freePlaces;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
}
