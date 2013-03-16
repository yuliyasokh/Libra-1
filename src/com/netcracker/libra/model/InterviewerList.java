package com.netcracker.libra.model;

/**
 * InterviewerList contains the ID of InterviewDate (which has an information about
 * the date, time and duration) and ID of interviewers (HR, Tech.interviewer)
 * @author Alexander Lebed
 */
public class InterviewerList {
    
    private int userId;
    private int InterviewDateId;

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInterviewDateId() {
        return InterviewDateId;
    }

    public void setInterviewDateId(int InterviewDateId) {
        this.InterviewDateId = InterviewDateId;
    }
    
}
