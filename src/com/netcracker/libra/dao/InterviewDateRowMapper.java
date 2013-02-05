package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewDateRowMapper implements RowMapper <InterviewDate> {
    public InterviewDate mapRow(ResultSet rs, int rowNum) throws SQLException {
        InterviewDate interviewDate = new InterviewDate();
        interviewDate.setInterviewDateId(rs.getInt("InterviewDateId"));
        interviewDate.setDateStart(rs.getTimestamp("DateStart"));
        interviewDate.setDateFinish(rs.getTimestamp("DateFinish"));
        interviewDate.setInterviewDuration(rs.getInt("InterviewDuration"));
        return interviewDate;
    }
    
}