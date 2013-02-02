/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.TopicShow;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class TopicShowRowMapper implements RowMapper<TopicShow> 
{
   public TopicShow mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      TopicShow topicShow = new TopicShow();
      topicShow.setTopicId(rs.getInt("TopicId"));
      topicShow.setComments(rs.getString("Comments"));
      topicShow.setTemplate(rs.getInt("TemplateId"));
      topicShow.setTemplateName(rs.getString("TemplateName"));
      topicShow.setParentTopic(rs.getInt("ParentTopic"));
      topicShow.setParentTopicName(rs.getString("ParentTopicName"));
      topicShow.setName(rs.getString("Name"));
      topicShow.setRequierOther(rs.getInt("RequireOther"));
      return topicShow;
   }
}
