package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import com.netcracker.libra.model.InterviewDateInfo;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDateJDBC implements InterviewDateDAO {
    
    private static JdbcTemplate jdbcTemplateObject;
    private static int interviewDateId = 100;
    
    public InterviewDateJDBC() {
        
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    // Забито под конкретный формат даты и времени DD/MM/YYYY hh24:mi
    @Override
    public void createInterviewDate(String startDateAndTime, String finishDateAndTime, Integer duration) {
        String SQL = "INSERT INTO InterviewDate VALUES "+
                "(InterDate_seq.NEXTVAL, TO_DATE(?, 'DD/MM/YYYY hh24:mi'), TO_DATE(?, 'DD/MM/YYYY hh24:mi'), ?)";
        jdbcTemplateObject.update(SQL, startDateAndTime, finishDateAndTime, duration);
        interviewDateId++;
    }
    
    @Override
    public void updateInterviewDateByDateId(Integer interviewDateId, String startDateAndTime, String finishDateAndTime, Integer duration) {
        String SQL = "UPDATE InterviewDate SET DateStart = TO_DATE(?, 'DD/MM/YYYY hh24:mi'), DateFinish = TO_DATE(?, 'DD/MM/YYYY hh24:mi'), InterviewDuration = ? "+
                "WHERE InterviewDateId = ?";
        jdbcTemplateObject.update(SQL, startDateAndTime, finishDateAndTime, duration, interviewDateId);
    }
    
    public void insertInterviewers(Integer userId){
        String query ="insert into interviewerList values(?, (select max(interviewDateId) from interviewDate))";
        jdbcTemplateObject.update(query,userId);
    }
   public void insertInterviewersAndDates(Integer userId, Integer interviewDateId){
        String query ="insert into interviewerList values(?, ?)";
        jdbcTemplateObject.update(query,userId,interviewDateId);
    }
    @Override
    public void deleteInterviewDateByAppId(Integer appId) {
        String SQL = "DELETE FROM InterviewDate "+
                "WHERE InterviewDateId = ?";
        jdbcTemplateObject.update(SQL, appId);
    }
    public void deleteFromInterviewerList(Integer interviewDateId){
        String SQL = "DELETE FROM InterviewerList "+
                "WHERE InterviewDateId = ?";
        jdbcTemplateObject.update(SQL, interviewDateId);
    }

    public List <InterviewDate> getAllInterviewDatesWithInterviewers() {
        String query = "select  d.interviewdateid, to_char(d.dateStart,'dd.mm.yyyy') dateInter, to_char(d.dateStart,'hh24:mi')||' - '||  to_char(d.dateFinish,'hh24:mi') timeInter, d.InterviewDuration,"+
        "rtrim(xmlagg(xmlelement(e, u.firstname||' '||u.lastname,', ').extract('//text()')),', ') listInterviewers "+ 
        "from  interviewdate d left join  interviewerlist l on d.interviewdateid=l.interviewdateid " 
		+"left join  users u on u.userid=l.userid "+
      "group by d.interviewdateid,d.datestart,d.datefinish,d.InterviewDuration";
        List <InterviewDate> interviewDates;
        interviewDates = jdbcTemplateObject.query(query, new WithInterviewersInterviewDateRowMapper());
        return interviewDates;
    }
    
    @Override
    public void addExtraTimeByAppId(Integer appId, Integer minutes) {
        String SQL = "UPDATE InterviewDate SET InterviewDuration = InterviewDuration + ? "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, minutes, appId);
    }
    
    @Override
    public InterviewDate getInterviewDateById(Integer Id) {
        String query = "select  d.interviewdateid, to_char(d.dateStart,'dd.mm.yyyy') dateInter, to_char(d.dateStart,'hh24:mi')||' - '||  to_char(d.dateFinish,'hh24:mi') timeInter, d.InterviewDuration,"+
        "rtrim(xmlagg(xmlelement(e, u.firstname||' '||u.lastname,', ').extract('//text()')),', ') listInterviewers "+ 
        "from  interviewdate d left join  interviewerlist l on d.interviewdateid=l.interviewdateid " 
		+"left join  users u on u.userid=l.userid where d.interviewdateid = ? "+
      "group by d.interviewdateid,d.datestart,d.datefinish,d.InterviewDuration";
        InterviewDate interviewDate = jdbcTemplateObject.queryForObject(query, 
                        new Object[]{Id}, new WithInterviewersInterviewDateRowMapper());
        return interviewDate;
    }
    
    @Override
    public List <InterviewDate> getAllInterviewDates() {
        String SQL = "SELECT * FROM InterviewDate";
        List <InterviewDate> interviewDates;
        interviewDates = jdbcTemplateObject.query(SQL, new InterviewDateRowMapper());
        return interviewDates;
    }
    public List<Map<String, Object>> getInterviewersNotInInterview(int interviewDateId){
        String query = "select u.userid userid,u.firstname||' '||u.lastname inters from users u where (u.roleid=2 or u.roleid=3) and u.userid != ALL(select ll.userid from interviewerList ll where ll.interviewDateId=?)";
        List<Map<String, Object>> interviewers = jdbcTemplateObject.queryForList(query,interviewDateId) ;
        return interviewers;
    }
    public List<Map<String, Object>> getInterviewersById(int interviewDateId){
        String query = "select i.userid userid, u.firstname||' '||u.lastname inters from interviewerList i join users u on i.userid=u.userid where i.interviewDateId=?";
        List<Map<String, Object>> interviewers = jdbcTemplateObject.queryForList(query,interviewDateId) ;
        return interviewers;
    }
    /*
     * Метод получает всех интервьеров из БД
     */
    public List<Map<String, Object>> getInterviewers(){
        String query="select userid, lastname||' '||firstname||"
                + "(case when roleid=2 then '(HR)' else '(Тех)' end) inters "
                + "from users where roleid=2 or roleid=3";
        List<Map<String, Object>> interviewers = jdbcTemplateObject.queryForList(query) ;
        return interviewers;
    }
    public List<InterviewDateInfo> getFreePlaces()
    {
        String SQL="select ilist.interviewDateId, "+
                "TO_CHAR(idate.datefinish,'dd.mm.yyyy') day, "+
                "TO_CHAR(idate.datestart,'hh24:mi')||'-'||TO_CHAR(idate.datefinish,'hh24:mi') hTime, "+
                "Count(*)*(idate.datefinish-idate.datestart)*24*60/idate.InterviewDuration -NVL(i.c,0) freePlaces, "+
                "sign(idate.datefinish-(SYSDATE+(select TIMEZONEDIFFERENCE from libraconfigs)/24)) correct "+
								 "from InterviewerList ilist join InterviewDate idate "+
										"on  idate.interviewDateId=ilist.interviewdateId "+	
								"left join "+ 
                "(select interviewDateId, Count(*) c "+
                "from interview "+
                "where status=1 "+ 
                "group by interviewDateId ) i on i.interviewDateId=idate.interviewDateId "+
                                        "GROUP by i.c,ilist.interviewDateId,idate.datestart,idate.datefinish,idate.InterviewDuration "+
					"order by idate.datestart ";
        return jdbcTemplateObject.query(SQL, new InterviewDateInfoRowMapper());
    }
    
    public int exists(int interviewId)
    {
        String sql = "select Count(*) from InterviewDate where InterviewDateId=? ";
        return jdbcTemplateObject.queryForInt(sql,interviewId);
    }
}
