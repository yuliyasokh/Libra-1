/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.ColumnLevel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class ColumnLevelRowMapper implements RowMapper<ColumnLevel> 
{
    public ColumnLevel mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      ColumnLevel columns = new ColumnLevel();
      columns.setColumnId(rs.getInt("ColumnId"));
      columns.setName(rs.getString("Name"));
      columns.setLavel(rs.getInt("Level"));
      return columns;
   }
}
