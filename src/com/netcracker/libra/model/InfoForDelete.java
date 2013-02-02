/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class InfoForDelete 
{
    String firstname;
    String lastname;
    String patronymic;
    int appId;
    int userId;
    
    public int getAppId() 
    {
        return appId;
    }
    public String getFirstname() 
    {
        return firstname;
    }
    public String getLastname() 
    {
        return lastname;
    }
    public String getPatronymic() 
    {
        return patronymic;
    }
    public int getUserId() 
    {
        return userId;
    }
    public void setAppId(int appId) 
    {
        this.appId = appId;
    }
    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) 
    {
        this.lastname = lastname;
    }
    public void setPatronymic(String patronymic) 
    {
        this.patronymic = patronymic;
    }
    public void setUserId(int userId) 
    {
        this.userId = userId;
    }   
}
