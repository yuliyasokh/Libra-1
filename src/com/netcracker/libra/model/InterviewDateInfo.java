/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

import java.util.Date;

/**
 *
 * @author Sashenka
 */
public class InterviewDateInfo 
{
    String day;
    String hStart;
    String hFinish;
    int id;
    int freePlaces;

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

    public String gethFinish() 
    {
        return hFinish;
    }

    public String gethStart() 
    {
        return hStart;
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

    public void sethFinish(String hFinish) 
    {
        this.hFinish = hFinish;
    }

    public void sethStart(String hStart) 
    {
        this.hStart = hStart;
    } 
    
}
