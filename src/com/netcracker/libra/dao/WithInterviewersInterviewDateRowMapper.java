/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Yuliya
 */
public class WithInterviewersInterviewDateRowMapper implements RowMapper <InterviewDate> {
    public InterviewDate mapRow(ResultSet rs, int rowNum) throws SQLException {
        InterviewDate interviewDate = new InterviewDate();
        interviewDate.setInterviewDateId(rs.getInt("InterviewDateId"));
        interviewDate.setDateInter(rs.getString("dateInter"));
        interviewDate.setTimeInter(rs.getString("timeInter"));
        interviewDate.setInterviewDuration(rs.getInt("InterviewDuration"));
        interviewDate.setListInterviewers(rs.getString("listInterviewers"));

        return interviewDate;
    }
    
}