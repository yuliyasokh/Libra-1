package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class InterviewDateRowMapper implements RowMapper <InterviewDate> {
    public InterviewDate mapRow(ResultSet rs, int rowNum) throws SQLException {
        InterviewDate interviewDate = new InterviewDate();
        interviewDate.setInterviewDateId(rs.getInt("InterviewDateId"));
        interviewDate.setDateStart(rs.getDate("DateStart"));
        interviewDate.setDateFinish(rs.getDate("DateFinish"));
        interviewDate.setInterviewDuration(rs.getInt("InterviewDuration"));
        return interviewDate;
    }
    
}
