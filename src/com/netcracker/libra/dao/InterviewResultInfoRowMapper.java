/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewResultsInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class InterviewResultInfoRowMapper implements RowMapper<InterviewResultsInfo>
{
    public InterviewResultsInfo mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        InterviewResultsInfo interviewResults = new InterviewResultsInfo();
        interviewResults.setAppId(rs.getInt("appId"));
        interviewResults.setAvgMark(rs.getDouble("avgMark"));
        interviewResults.setFio(rs.getString("fio"));
        interviewResults.setiDate(rs.getString("iDate"));
        interviewResults.setInterviewId(rs.getInt("interviewId"));
        return interviewResults;
    }
}
