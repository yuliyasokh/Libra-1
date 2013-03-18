/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.AppFormTopics;
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
        String SQL = "select * from Topic where TopicId =?";
        Topic topic = jdbcTopicObject.queryForObject(SQL, new TopicRowMapper(),id);
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
        String SQL = "select * from Topic where templateId=? order by TopicId";
        List <Topic> topics = jdbcTopicObject.query(SQL, new TopicRowMapper(),templateId);
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
            SQL ="INSERT INTO Topic VALUES(?,?,?,?, "+parentTopic+",?)";
        }
        else
        {
            SQL ="INSERT INTO Topic VALUES(?,?,?,?, NULL, ?)";
        }
        jdbcTopicObject.update(SQL,i,name,comments,tamplateId,requiredOther);
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
        String SQL;
        if(parentTopic==0)
        {
            SQL = "update Topic set name =?, comments=?, templateid=?, parentTopic=NULL, requireOther =? where TopicId =?";
           jdbcTopicObject.update(SQL,name,comments,templateId,require,id);
        }
        else
        {
            SQL = "update Topic set name =?, comments=?, templateid=?, parentTopic=?, requireOther =? where TopicId =?";        
            jdbcTopicObject.update(SQL,name,comments,templateId,parentTopic,require,id);
        }
        
    }
    
    public int getTemplateForTopic(int id)
    {
        String SQL = "select TemplateId from Topic where TopicId =?";
        return  jdbcTopicObject.queryForInt(SQL,id);
    }
    public List<TopicShow> getTopicsShow()
    {
        String SQL = "select top.TopicId, top.ParentTopic, top.Comments, top.TemplateId, temp.Name as TemplateName, par.Name as ParentTopicName, top.Name, top.RequireOther from Topic top left join Template temp ON temp.TemplateId=top.TemplateId LEFT JOIN  Topic par ON par.TopicId=top.ParentTopic order by TopicId";
        List<TopicShow> topShow = jdbcTopicObject.query(SQL, new TopicShowRowMapper());
        return topShow;
    }
    public int existTopic(int id)
    {
        String sql = "select Count(*) from topic where TopicId=?";
        return jdbcTopicObject.queryForInt(sql,id);
    }
    public List<InfoForDelete> getInfoForDelete(int[] topics)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from topic top join columns c on c.topicId=top.topicId "+
					"join columnFields cf on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "where";
         for(int i=0;i<topics.length-1;i++)
                {
                                       sql+= " top.topicId="+topics[i]+" or";
                }
                 sql+= " top.topicId="+topics[topics.length-1];
                                       sql+= " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcTopicObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
    
    public List<AppFormTopics> getAppFormTopics(int id)
    {
        String SQL="select top.requireOther, top.topicId, top.name,top.parentTopic,level "+
                    "from topic top "+
                    "where  top.templateId=? "+
                    "START WITH  top.parentTopic is null "+
                    "CONNECT BY  prior  top.topicId =  top.parentTopic "+
                    "order siblings by top.name Desc ";
        List<AppFormTopics> topicList=jdbcTopicObject.query(SQL, new AppFormTopicRowMapper(),id);
        return topicList;
    }

}
