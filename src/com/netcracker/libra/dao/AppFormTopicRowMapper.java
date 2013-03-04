/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.AppFormTopics;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class AppFormTopicRowMapper implements RowMapper<AppFormTopics> 
{
   public AppFormTopics mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      AppFormTopics appFormTopics = new AppFormTopics();
      appFormTopics.setLevel(rs.getInt("level"));
      appFormTopics.setParentTopic(rs.getInt("parentTopic"));
      appFormTopics.setTopicId(rs.getInt("topicId"));
      appFormTopics.setTopicName(rs.getString("name"));
      appFormTopics.setRequireOther(rs.getInt("requireOther"));
      return appFormTopics;
   }
}