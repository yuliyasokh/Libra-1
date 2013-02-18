/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Interview;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class InterviewRowMapper implements RowMapper <Interview> 
{
    public Interview mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        Interview interview = new Interview();
        interview.setAppId(rs.getInt("AppId"));
        interview.setInterviewDateId(rs.getInt("InterviewDateId"));
        interview.setInterviewId(rs.getInt("InterviewId"));
        interview.setStatus(rs.getInt("Status"));
        return interview;
    }
    
}