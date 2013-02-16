/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Interview;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Сашенька
 */
@Repository
public class InterviewJDBC implements InterviewDAO
{
    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public int exists(int interviewDateId,int UserId)
    {
         String sql = "select Count(*) from Interview i join appForm af on af.appId=i.appId where af.UserId=? and i.interviewDateId=? and i.status=1 ";
        return jdbcTemplateObject.queryForInt(sql,UserId,interviewDateId);
    }
    public int exists0(int UserId)
    {
         String sql = "select Count(*) from Interview i join appForm af on af.appId=i.appId where af.UserId=? and i.status=0 ";
        return jdbcTemplateObject.queryForInt(sql,UserId);
    }
    public Interview getInterview(int id)
    {
        String SQL = "select * from Interview where InterviewId =?";
        Interview interview = jdbcTemplateObject.queryForObject(SQL, new InterviewRowMapper(),id);      
        return interview;
    }
    
    public List<Interview> getAll()
    {
         String SQL = "select * from Interview order by InterviewId";
        List <Interview> interviews = jdbcTemplateObject.query(SQL, new InterviewRowMapper());
        return interviews;
    }
    private int getCurVal()
    {
        String sqlSeq = "select Interview_seq.NEXTVAL as Id from dual";
        return jdbcTemplateObject.queryForInt(sqlSeq);
    }
   
    @Override
    public int add(int interviewDateId, int UserId, int status)
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Interview VALUES(?,?,"+
                "(Select appId from appform where UserId=?),"+
                "?)";
        jdbcTemplateObject.update(SQL,i,interviewDateId,UserId,status);
        return i;
    }
    public void updateRequest(int interviewDateId, int UserId)
    {
            String   SQL="Update Interview set InterviewDateId=? where appId=(select appId from appForm where UserId=?) and status=0";
            jdbcTemplateObject.update(SQL,interviewDateId,UserId);
    }
    public void deleteRequest(int userId)
    {
        String SQL="delete from interview where appId=(select appId from appForm where UserId=?) and status=0";
        jdbcTemplateObject.update(SQL, userId);
    }
    @Override
    public int getInterviewDateByAppId(int userId)
    {
        String sql="select InterviewDateId from interview i join appform af on af.appid=i.appid where i.status=1 and af.userId=?";
        return jdbcTemplateObject.queryForInt(sql,userId);
    }
    
    @Override
    public String getRequestInterviewDate(int userId)
    {
        String SQL="select 'Вы хотели перезаписатся '||TO_CHAR(id.dateFinish,'dd.mm.yyyy')||' на '||TO_CHAR(id.dateStart,'hh24:mi')||'-'|| TO_CHAR(id.dateFinish,'hh24:mi') from Interview i join appForm af on af.appId=i.appId  join InterviewDate id on id.InterviewDateId=i.InterviewDateId where af.UserId=? and i.status=0";
        return (String)jdbcTemplateObject.queryForObject(SQL,String.class,userId);
    }
       
}
