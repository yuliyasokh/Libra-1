package com.netcracker.libra.model;
import java.sql.Date;

public class InterviewDate {
    
    private int interviewDateId;
    private Date dateStart;
    private Date dateFinish;
    private int interviewDuration;
    private String listInterviewers;
    private String timeInter;
    private String dateInter;

    
    public void setListInterviewers(String listInterviewers){
        this.listInterviewers=listInterviewers;
    }
    public String getListInterviewers(){
        return listInterviewers;
    }
    public void setTimeInter(String timeInter){
        this.timeInter=timeInter;
    }
    public String getTimeInter(){
        return timeInter;
    }
    public void setDateInter(String dateInter){
        this.dateInter=dateInter;
    }
    public String getDateInter(){
        return dateInter;
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

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getInterviewDuration() {
        return interviewDuration;
    }

    public void setInterviewDuration(int interviewDuration) {
        this.interviewDuration = interviewDuration;
    }
    
}
