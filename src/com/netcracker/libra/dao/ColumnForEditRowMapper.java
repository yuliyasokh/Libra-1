/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.ColumnForEdit;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class ColumnForEditRowMapper implements RowMapper<ColumnForEdit> 
{
    public ColumnForEdit mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      ColumnForEdit columns = new ColumnForEdit();
      columns.setColumnId(rs.getInt("ColumnId"));
      columns.setName(rs.getString("Name"));
      columns.setParentColumn(rs.getInt("ParentColumn"));
      columns.setTypeId(rs.getInt("TypeId"));
      return columns;
   }
}