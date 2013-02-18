/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class Interview 
{
    int interviewId;
    int interviewDateId;
    int appId;
    int status;

    public int getAppId() 
    {
        return appId;
    }

    public int getInterviewDateId() 
    {
        return interviewDateId;
    }

    public int getInterviewId() 
    {
        return interviewId;
    }

    public int getStatus() 
    {
        return status;
    }

    public void setAppId(int appId) 
    {
        this.appId = appId;
    }

    public void setInterviewDateId(int interviewDateId) 
    {
        this.interviewDateId = interviewDateId;
    }

    public void setInterviewId(int interviewId) 
    {
        this.interviewId = interviewId;
    }

    public void setStatus(int status) 
    {
        this.status = status;
    }
}
