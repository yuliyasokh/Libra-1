package com.netcracker.libra.model;

/**
 * This model conteins the information about interview's results
 * @author Alexander Lebed
 */
public class DateAndInterviewerResults {
    
    private Integer appId;
    private String interviewDate;
    private String interviewTime;
    private String interviewerName;
    private Integer interviewerRole; 
    private Integer interviewerMark;
    private String interviewerComments;

    /**
     * @return the appId
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * @return the interviewDate
     */
    public String getInterviewDate() {
        return interviewDate;
    }

    /**
     * @param interviewDate the interviewDate to set
     */
    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    /**
     * @return the interviewTime
     */
    public String getInterviewTime() {
        return interviewTime;
    }

    /**
     * @param interviewTime the interviewTime to set
     */
    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    /**
     * @return the interviewerName
     */
    public String getInterviewerName() {
        return interviewerName;
    }

    /**
     * @param interviewerName the interviewerName to set
     */
    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    /**
     * @return the interviewerRole
     */
    public Integer getInterviewerRole() {
        return interviewerRole;
    }

    /**
     * @param interviewerRole the interviewerRole to set
     */
    public void setInterviewerRole(Integer interviewerRole) {
        this.interviewerRole = interviewerRole;
    }

    /**
     * @return the interviewerMark
     */
    public Integer getInterviewerMark() {
        return interviewerMark;
    }

    /**
     * @param interviewerMark the interviewerMark to set
     */
    public void setInterviewerMark(Integer interviewerMark) {
        this.interviewerMark = interviewerMark;
    }

    /**
     * @return the interviewerComments
     */
    public String getInterviewerComments() {
        return interviewerComments;
    }

    /**
     * @param interviewerComments the interviewerComments to set
     */
    public void setInterviewerComments(String interviewerComments) {
        this.interviewerComments = interviewerComments;
    }
    
}
