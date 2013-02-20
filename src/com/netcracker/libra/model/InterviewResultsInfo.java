/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class InterviewResultsInfo 
{
    String fio;
    double avgMark;
    int appId;
    String iDate;
    int interviewId;

    public int getInterviewId() 
    {
        return interviewId;
    }

    public void setInterviewId(int interviewId) 
    {
        this.interviewId = interviewId;
    }
    
    public double getAvgMark() 
    {
        return avgMark;
    }

    public String getFio() 
    {
        return fio;
    }

    public String getiDate() 
    {
        return iDate;
    }

    public int getAppId() 
    {
        return appId;
    }

    public void setiDate(String iDate) 
    {
        this.iDate = iDate;
    }

    public void setFio(String fio) 
    {
        this.fio = fio;
    }

    public void setAvgMark(double avgMark) 
    {
        this.avgMark = avgMark;
    }

    public void setAppId(int appId) 
    {
        this.appId = appId;
    }    
}
