package com.netcracker.libra.model;

import java.util.Date;


public class InterviewDate {
    
    private int interviewDateId;
    private Date dateStart;
    private Date dateFinish;
    private int interviewDuration;

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
