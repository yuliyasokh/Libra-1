package com.netcracker.libra.model;

import java.sql.Timestamp;
import java.util.Date;


public class InterviewDate {
    
    private int interviewDateId;
    private Timestamp dateStart;
    private Timestamp dateFinish;
    private int interviewDuration;
    private String listInterviewers;
    
    public void setListInterviewers(String listInterviewers){
        this.listInterviewers=listInterviewers;
    }
    public String getListInterviewers(){
        return listInterviewers;
    }

    public int getInterviewDateId() {
        return interviewDateId;
    }

    public void setInterviewDateId(int interviewDateId) {
        this.interviewDateId = interviewDateId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Timestamp dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getInterviewDuration() {
        return interviewDuration;
    }

    public void setInterviewDuration(int interviewDuration) {
        this.interviewDuration = interviewDuration;
    }
    
}
