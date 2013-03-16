/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Column;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
//Column
public class ColumnRowMapper  implements RowMapper<Column> 
{
    public Column mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      Column columns = new Column();
      columns.setColumnId(rs.getInt("ColumnId"));
      columns.setName(rs.getString("Name"));
      columns.setParentColumn(rs.getInt("parentColumn"));
      return columns;
   }
}
