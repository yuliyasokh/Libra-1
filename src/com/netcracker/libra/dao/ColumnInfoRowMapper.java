/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.ColumnInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class ColumnInfoRowMapper  implements RowMapper<ColumnInfo> 
{
    public ColumnInfo mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      ColumnInfo columns = new ColumnInfo();
      columns.setColumnId(rs.getInt("ColumnId"));
      columns.setName(rs.getString("Name"));
      columns.setParentColumn(rs.getInt("ParentColumn"));
      columns.setTypeId(rs.getInt("TypeId"));
      columns.setTypeDescription(rs.getString("typeDescription"));
      columns.setLevel(rs.getInt("level"));
      return columns;
   }
}