/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Topic;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class TopicRowMapper implements RowMapper<Topic>
{
   public Topic mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      Topic topic = new Topic();
      topic.setTopicId(rs.getInt("TopicId"));
      topic.setName(rs.getString("Name"));
      topic.setComments(rs.getString("Comments"));
      topic.setTemplate(rs.getInt("TemplateId"));
      topic.setParentTopic(rs.getInt("ParentTopic"));
      topic.setRequierOther(rs.getInt("RequireOther"));
      return topic;
   }
}