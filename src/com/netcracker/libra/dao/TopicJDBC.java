/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Columns;
import com.netcracker.libra.model.InfoForDelete;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.netcracker.libra.model.Topic;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.netcracker.libra.model.TopicShow;
/**
 *
 * @author Sashenka
 */
@Repository
public class TopicJDBC implements TopicDAO
{
    private static JdbcTemplate jdbcTopicObject;

    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
      jdbcTopicObject = new JdbcTemplate(dataSource);
    }
    
    public Topic getTopic(int id) 
    {
        String SQL = "select * from Topic where TopicId ="+id;
        Topic topic = jdbcTopicObject.queryForObject(SQL, new TopicRowMapper());
      return topic;
    }

    public List<Topic> getAllTopics()
    {
        String SQL = "select * from Topic order by TopicId";
        List <Topic> topics = jdbcTopicObject.query(SQL, new TopicRowMapper());
        return topics;
    }
    public List<Topic> getAll(int templateId) 
    {
        String SQL = "select * from Topic where templateId="+templateId+" order by TopicId";
        List <Topic> topics = jdbcTopicObject.query(SQL, new TopicRowMapper());
        return topics;
    }
    
    private int getCurVal()
    {
        String sqlSeq = "select Topic_seq.nextval as Id from dual";
        return jdbcTopicObject.queryForInt(sqlSeq);
    }
    @Override
    public int addTopic(String name,String comments,int tamplateId,int parentTopic, int requiredOther) 
    {
        String SQL="";
        int i=getCurVal();
        if(parentTopic!=0)
        {
        SQL ="INSERT INTO Topic VALUES("+i+","+
		"'"+name+"',"+"'"+comments+"', "+tamplateId+", "+parentTopic+", "+requiredOther+
		")";
        }
        else
        {
            SQL ="INSERT INTO Topic VALUES("+i+","+
		"'"+name+"',"+"'"+comments+"', "+tamplateId+", NULL, "+requiredOther+
		")";
        }
        jdbcTopicObject.update(SQL);
        return i;
    }

    @Override
    public void deleteTopic(int id) 
    {
        String SQL = "delete from Topic where topicId = ?";
       jdbcTopicObject.update(SQL, id);
    }

    @Override
    public void updateTopic(int id, String name, String comments, int templateId, int parentTopic, int require) 
    {
        String SQL = "update Topic set name ='"+name+"', comments='"+comments+"', templateid="+templateId+", parentTopic="+parentTopic+", requireOther ="+require+" where TopicId ="+id;
       jdbcTopicObject.update(SQL);
    }
    
    public int getTemplateForTopic(int id)
    {
        String SQL = "select TemplateId from Topic where TopicId ="+id;
        return  jdbcTopicObject.queryForInt(SQL);
    }
    public List<TopicShow> getTopicsShow()
    {
        String SQL = "select top.TopicId, top.ParentTopic, top.Comments, top.TemplateId, temp.Name as TemplateName, par.Name as ParentTopicName, top.Name, top.RequireOther from Topic top left join Template temp ON temp.TemplateId=top.TemplateId LEFT JOIN  Topic par ON par.TopicId=top.ParentTopic"+" order by TopicId";
        List<TopicShow> topShow = jdbcTopicObject.query(SQL, new TopicShowRowMapper());
        return topShow;
    }
    public int existTopic(int id)
    {
        String sql = "select Count(*) from topic where TopicId="+id;
        return jdbcTopicObject.queryForInt(sql);
    }
    public List<InfoForDelete> getInfoForDelete(int topicId)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from topic top join columns c on c.topicId=top.topicId "+
					"join columnFields cf on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "where top.topicId="+topicId+
                                        " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcTopicObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
    
    //Added 02.02.2013
    public List<Columns> getTopicColumns(Integer id) 
    {
        String SQL = "select * from Columns where TopicId =?";
        List<Columns> columns = jdbcTopicObject.query(SQL, new ColumnsRowMapper(), id);    
        return columns;
    }
    
    //added 03.02.2013
    public String getTopicLabel(Integer id) {
    	return jdbcTopicObject.queryForObject("select label from topic where topicid=?", String.class, id);
    }
}
