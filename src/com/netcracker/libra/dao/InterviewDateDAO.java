package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import java.util.List;
import javax.sql.DataSource;

public interface InterviewDateDAO {
    
    void setDataSource(DataSource dataSource);
    void createInterviewDate(String startDateAndTime, String finishDateAndTime, Integer duration);
    void updateInterviewDateByDateId(Integer appId, String startDateAndTime, 
                                                   String finishDateAndTime, Integer duration);
    void deleteInterviewDateByAppId(Integer appId);
    void addExtraTimeByAppId(Integer appId, Integer minutes);
    InterviewDate getInterviewDateById(Integer Id);
    List <InterviewDate> getAllInterviewDates();
    void insertInterviewers(Integer userId);
    
    
}
