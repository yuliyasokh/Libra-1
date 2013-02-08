package com.netcracker.libra.dao;

import com.netcracker.libra.model.InterviewDate;
import com.netcracker.libra.model.InterviewDateInfo;
import java.util.List;
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
                "(?, TO_DATE(?, 'DD/MM/YYYY hh24:mi'), TO_DATE(?, 'DD/MM/YYYY hh24:mi'), ?)";
        jdbcTemplateObject.update(SQL, interviewDateId, startDateAndTime, finishDateAndTime, duration);
        interviewDateId++;
    }
    
    @Override
    public void updateInterviewDateByAppId(Integer appId, String startDateAndTime, String finishDateAndTime, Integer duration) {
        String SQL = "UPDATE InterviewDate SET DateStart = ?, DateFinish = ?, InterviewDuration = ? "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, startDateAndTime, finishDateAndTime, duration, appId);
    }
    
    @Override
    public void deleteInterviewDateByAppId(Integer appId) {
        String SQL = "DELETE FROM InterviewDate "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, appId);
    }
    
    @Override
    public void addExtraTimeByAppId(Integer appId, Integer minutes) {
        String SQL = "UPDATE InterviewDate SET InterviewDuration = InterviewDuration + ? "+
                "WHERE InterviewDateId = (SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        jdbcTemplateObject.update(SQL, minutes, appId);
    }
    
    @Override
    public InterviewDate getInterviewDateByAppId(Integer appId) {
        String SQL = "SELECT * FROM InterviewDate WHERE InterviewDateId = "+
                "(SELECT InterviewDateId FROM Interview WHERE AppId = ?)";
        InterviewDate interviewDate = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{appId}, new InterviewDateRowMapper());
        return interviewDate;
    }
    
    @Override
    public List <InterviewDate> getAllInterviewDates() {
        String SQL = "SELECT * FROM InterviewDate";
        List <InterviewDate> interviewDates;
        interviewDates = jdbcTemplateObject.query(SQL, new InterviewDateRowMapper());
        return interviewDates;
    }
    /**
     * Метод получает всю информацию о датах интервью + список интервьеров на каждом из интервью
     */
    public List <InterviewDate> getAllInterviewDatesWithInterviewers() {
        String SQL = "select  d.interviewdateid, d.dateStart,d.dateFinish,d.InterviewDuration,"+
        "rtrim(xmlagg(xmlelement(e, u.firstname||' '||u.lastname,', ').extract('//text()')),', ') listInterviewers "+
        "from  interviewdate d join interviewerlist l on d.interviewdateid=l.interviewdateid "+
		"join users u on u.userid=l.userid "+
      "group by d.interviewdateid,d.datestart,d.datefinish,d.InterviewDuration";
        List <InterviewDate> interviewDates;
        interviewDates = jdbcTemplateObject.query(SQL, new WithInterviewersInterviewDateRowMapper());
        return interviewDates;
    }
    public List<InterviewDateInfo> getFreePlaces()
    {
        String SQL="select  intDate.interviewDateId, TO_CHAR(tAllPlaces.dateFinish,'dd.mm.yyyy') day,TO_CHAR(tAllPlaces.dateStart,'hh24:mi') hSatrt,TO_CHAR(tAllPlaces.dateFinish,'hh24:mi') hFinish, tAllPlaces.allPlaces-count(*) freePlaces "+
        "from interviewDate intDate join Interview i on i.interviewDateId=intDate.interviewDateId "+
        "join "+
								"(select ilist.interviewDateId, idate.datefinish dateFinish,idate.datestart dateStart,Count(*)*(idate.datefinish-idate.datestart)*24*60/idate.InterviewDuration as allPlaces "+
								 "from InterviewerList ilist join InterviewDate idate "+
										"on  idate.interviewDateId=ilist.interviewdateId "+
										"GROUP by ilist.interviewDateId,idate.datestart,idate.datefinish,idate.InterviewDuration) tAllPlaces "+
										"on tAllPlaces.interviewDateId=intDate.interviewDateId "+
										"group by intDate.interviewDateId,tAllPlaces.allPlaces,tAllPlaces.dateStart,tAllPlaces.dateFinish "+
                                                                                "order by intDate.interviewDateId";

        return jdbcTemplateObject.query(SQL, new InterviewDateInfoRowMapper());
    }
    
}
