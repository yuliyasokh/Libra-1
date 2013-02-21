/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewResult;
import com.netcracker.libra.model.InterviewResultsInfo;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sashenka
 */
@Repository
public class InterviewResultsJDBC  implements InterviewResultsDAO
{
    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
     
    public List<InterviewResult> getResult(int interviewId)
    {
        String SQL="select r.title||': '||u.lastName||' '||u.firstName fio, ir.Mark, ir.comments, ir.userId  "+
                    "from interviewResults ir join "+
                    "users u on u.userId=ir.userId "+
                    "join roles r on r.roleId=u.roleId "+
                    "where ir.InterviewId=?";
        return jdbcTemplateObject.query(SQL, new InterviewResultRowMapper(),interviewId);
    }
    
    public int existsComment(int userId, int InterviewId)
    {
        String SQL="select count(*) from interviewResults where userId=? and interviewId=?";
        return jdbcTemplateObject.queryForInt(SQL,userId,InterviewId);
    }
    public List<InterviewResultsInfo> getInfo()
    {
        String SQL = "select u.firstname||' '||af.patronymic||' '||u.lastName fio, "+
	"af.appId, "+
        "ir.interviewId, "+
	"TO_CHAR(id.datefinish,'dd.mm.yyyy')||' '||TO_CHAR(id.datestart,'hh24:mi')||'-'||TO_CHAR(id.datefinish,'hh24:mi') iDate, "+
	"avg(nvl(ir.mark,0)) avgMark  "+
	"from interview i left join interviewResults ir on ir.interviewId=i.interviewId "+
	"right join appform af on af.appid=i.appid "+
	"left join interviewDate id on id.InterviewDateId=i.InterviewDateId "+
	"join users u on u.userId=af.userId  "+
	"where not (i.status=0 or i.status is null) "+
	"group by u.firstname, u.lastName, af.patronymic,af.appId, id.datefinish, id.datestart,ir.interviewId "+
	"order by avgMark  desc";
        List<InterviewResultsInfo> interview = jdbcTemplateObject.query(SQL, new InterviewResultInfoRowMapper());      
        return interview;
    }
    @Override
    public void addResult(int InterviewId,int UserId,int mark, String comments)
    {
        String SQL ="INSERT INTO InterviewResults VALUES(?,?,?,?)";
        jdbcTemplateObject.update(SQL,InterviewId,UserId,mark,comments);
    }
    
    @Override
    public void updateResult(int InterviewId,int UserId,int mark, String comments)
    {
        String SQL ="Update InterviewResults set mark=?, comments=? where interviewId=? and userId=?";
        jdbcTemplateObject.update(SQL,mark,comments,InterviewId,UserId);
    }
    public void deleteResult(int InterviewId,int UserId)
    {
        String SQL ="delete InterviewResults where interviewId=? and userId=?";
        jdbcTemplateObject.update(SQL,InterviewId,UserId);
    }
}
