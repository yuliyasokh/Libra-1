/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewResult;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class InterviewResultRowMapper implements RowMapper<InterviewResult>
{
    public InterviewResult mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        InterviewResult interviewResult = new InterviewResult();
        interviewResult.setComments(rs.getString("comments"));
        interviewResult.setFio(rs.getString("fio"));
        interviewResult.setMark(rs.getInt("Mark"));
        interviewResult.setUserId(rs.getInt("UserId"));
        return interviewResult;
    }
}
