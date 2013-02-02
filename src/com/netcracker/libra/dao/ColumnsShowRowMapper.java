/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.ColumnsShow;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class ColumnsShowRowMapper implements RowMapper<ColumnsShow> 
{
   public ColumnsShow mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      ColumnsShow columnsShow = new ColumnsShow();
      columnsShow.setColumnId(rs.getInt("ColumnId"));
      columnsShow.setName(rs.getString("Name"));
      columnsShow.setRequired(rs.getInt("Required"));
      columnsShow.setTopicId(rs.getInt("TopicId"));
      columnsShow.setTopicName(rs.getString("TopicName"));
      columnsShow.setTypeId(rs.getInt("TypeId"));
      columnsShow.setTypeName(rs.getString("TypeName"));
      return columnsShow;
   }
}