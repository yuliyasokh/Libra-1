package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewerList;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * work of mapping each row of InterviewerList to a result object
 * @author Alexander Lebed
 */
public class InterviewerListRowMapper implements RowMapper <InterviewerList>  {
    
    @Override
    public InterviewerList mapRow(ResultSet rs, int rowNum) throws SQLException {
        InterviewerList interviewerList = new InterviewerList();
        interviewerList.setUserId(rs.getInt("USERID"));
        interviewerList.setInterviewDateId(rs.getInt("INTERVIEWDATEID"));
        return interviewerList;
        
    }
    
}
