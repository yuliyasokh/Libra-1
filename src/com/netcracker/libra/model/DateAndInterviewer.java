package com.netcracker.libra.model;

/**
 * This model conteins the information about interview's date and assigned interviewers
 * @author Alexander Lebed
 */
public class DateAndInterviewer {
    
    private Integer appId;
    private String interviewDate;
    private String interviewTime;
    private String interviewerName;
    private Integer interviewerRole;

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
    
}
