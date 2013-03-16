/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.AppFormColumns;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class AppFormColumnsRowMapper implements RowMapper<AppFormColumns> 
{
    public AppFormColumns mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      AppFormColumns appFormColumns = new AppFormColumns();
      appFormColumns.setColumnId(rs.getInt("ColumnId"));
      appFormColumns.setName(rs.getString("Name"));
      appFormColumns.setLevel(rs.getInt("level"));
      appFormColumns.setcT(rs.getString("typeName"));
      appFormColumns.setTypeName(rs.getString("typeName"));
      appFormColumns.setDefinition(rs.getString("DESCRIPTION"));     
      return appFormColumns;
   }
}