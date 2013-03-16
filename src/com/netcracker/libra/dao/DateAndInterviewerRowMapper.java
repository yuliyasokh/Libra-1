package com.netcracker.libra.dao;

import com.netcracker.libra.model.DateAndInterviewer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * works of mapping each row of DateAndInterviewer to a result object
 * @author Alexander Lebed
 */
public class DateAndInterviewerRowMapper implements RowMapper <DateAndInterviewer> {

    @Override
    public DateAndInterviewer mapRow(ResultSet rs, int rowNum) throws SQLException {
        DateAndInterviewer obj = new DateAndInterviewer();
        obj.setAppId(rs.getInt("APPID"));
        obj.setInterviewDate(rs.getString("INTERVIEWDATE"));
        obj.setInterviewTime(rs.getString("INTERVIEWTIME"));
        obj.setInterviewerName(rs.getString("INTERVIEWERNAME"));
        obj.setInterviewerRole(rs.getInt("INTERVIEWERROLE"));
        return obj;
    }
    
    
}
