package com.netcracker.libra.model;

/**
 * InterviewResults is filled after interviewing.
 * The class contains ID of interview, ID of interviewer,
 * interviewer's mark and comment for the interview
 * @author Alexander Lebed
 */
public class InterviewResults {
    
    private int interviewId;
    private int userId;
    private int mark;
    private String comments;

    
    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
