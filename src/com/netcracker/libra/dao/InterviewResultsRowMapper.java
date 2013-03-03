package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewResults;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Alexander Lebed
 */
public class InterviewResultsRowMapper implements RowMapper <InterviewResults> {
    
    @Override
    public InterviewResults mapRow(ResultSet rs, int rowNum) throws SQLException {
        InterviewResults interviewResults = new InterviewResults();
        interviewResults.setInterviewId(rs.getInt("INTERVIEWID"));
        interviewResults.setUserId(rs.getInt("USERID"));
        interviewResults.setMark(rs.getInt("MARK"));
        interviewResults.setComments(rs.getString("COMMENTS"));
        return interviewResults;
    }
    
}
