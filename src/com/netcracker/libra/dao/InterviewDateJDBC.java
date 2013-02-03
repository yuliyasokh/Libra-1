package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDateJDBC implements InterviewDateDAO {
    
    private static JdbcTemplate jdbcTemplateObject;
    private static int interviewDateId = 100;
    
    public InterviewDateJDBC() {
        
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    // Забито под конкретный формат даты и времени DD/MM/YYYY hh24:mi
    @Override
    public void createInterviewDate(String startDateAndTime, String finishDateAndTime, Integer duration) {
        String SQL = "INSERT INTO InterviewDate VALUES "+
                "(?, TO_DATE(?, 'DD/MM/YYYY hh24:mi'), TO_DATE(?, 'DD/MM/YYYY hh24:mi'), ?)";
        jdbcTemplateObject.update(SQL, interviewDateId, startDateAndTime, finishDateAndTime, duration);
        interviewDateId++;
    }
    
    @Override
    public void updateInterviewDateByAppId(Integer appId, String startDateAndTime, String finishDateAndTime, Integer duration) {
        String SQL = "UPDATE InterviewDate SET DateStart = ?, DateFinish = ?, InterviewDuration = ? "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, startDateAndTime, finishDateAndTime, duration, appId);
    }
    
    @Override
    public void deleteInterviewDateByAppId(Integer appId) {
        String SQL = "DELETE FROM InterviewDate "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, appId);
    }
    
    @Override
    public void addExtraTimeByAppId(Integer appId, Integer minutes) {
        String SQL = "UPDATE InterviewDate SET InterviewDuration = InterviewDuration + ? "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, minutes, appId);
    }
    
    @Override
    public InterviewDate getInterviewDateByAppId(Integer appId) {
        String SQL = "SELECT * FROM InterviewDate WHERE InterviewDateId = "+
                "(SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        InterviewDate interviewDate = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{appId}, new InterviewDateRowMapper());
        return interviewDate;
    }
    
    @Override
    public List <InterviewDate> getAllInterviewDates() {
        String SQL = "SELECT * FROM InterviewDate";
        List <InterviewDate> interviewDates;
        interviewDates = jdbcTemplateObject.query(SQL, new InterviewDateRowMapper());
        return interviewDates;
    }
    
    
}
