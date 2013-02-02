/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sashenka
 */
public class TypeRowMapper implements RowMapper<Type> 
{
   public Type mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      Type type = new Type();
      type.setTypeId(rs.getInt("TypeId"));
      type.setTypeName(rs.getString("Name"));
      return type;
   }
}