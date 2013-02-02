/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class ColumnsRowMapper  implements RowMapper<Columns> 
{
    public Columns mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      Columns columns = new Columns();
      columns.setColumnId(rs.getInt("ColumnId"));
      columns.setTopicId(rs.getInt("TopicId"));
      columns.setName(rs.getString("Name"));
      columns.setTypeId(rs.getInt("TypeId"));
      columns.setRequired(rs.getInt("Required"));
      return columns;
   }
}
