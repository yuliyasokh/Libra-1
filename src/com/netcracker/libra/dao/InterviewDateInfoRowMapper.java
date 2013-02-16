/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDateInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class InterviewDateInfoRowMapper implements RowMapper <InterviewDateInfo> 
{
    public InterviewDateInfo mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        InterviewDateInfo interviewDateInfo = new InterviewDateInfo();
        //rs.getInt("InterviewDateId")
        interviewDateInfo.setDay(rs.getString("day"));
        interviewDateInfo.sethTime(rs.getString("hTime"));//.setDateFinish(rs.getDate("dateFinish"));
        //interviewDateInfo.sethStart(rs.getString("hSatrt"));//.setDateStart(rs.getDate("dateStart"));
        interviewDateInfo.setFreePlaces(rs.getInt("freePlaces"));
        interviewDateInfo.setId(rs.getInt("interviewDateId"));
        interviewDateInfo.setCorrect(rs.getInt("Correct"));
        return interviewDateInfo;
    }
    
}