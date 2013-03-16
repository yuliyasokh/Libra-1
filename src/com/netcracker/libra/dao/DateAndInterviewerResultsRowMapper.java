package com.netcracker.libra.dao;

import com.netcracker.libra.model.DateAndInterviewerResults;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * works of mapping each row of DateAndInterviewerResults to a result object
 * @author Alexander Lebed
 */
public class DateAndInterviewerResultsRowMapper implements RowMapper <DateAndInterviewerResults> {
    @Override
    public DateAndInterviewerResults mapRow(ResultSet rs, int rowNum) throws SQLException {
        DateAndInterviewerResults obj = new DateAndInterviewerResults();
        obj.setAppId(rs.getInt("APPID"));
        obj.setInterviewDate(rs.getString("INTERVIEWDATE"));
        obj.setInterviewTime(rs.getString("INTERVIEWTIME"));
        obj.setInterviewerName(rs.getString("INTERVIEWERNAME"));
        obj.setInterviewerRole(rs.getInt("INTERVIEWERROLE"));
        obj.setInterviewerMark(rs.getInt("INTERVIEWERMARK"));
        obj.setInterviewerComments(rs.getString("INTERVIEWERCOMMENTS"));
        return obj;
    }
    
}
