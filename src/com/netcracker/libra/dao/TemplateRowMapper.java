/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.netcracker.libra.model.Template;

/**
 *
 * @author Sashenka
 */
public class TemplateRowMapper implements RowMapper<Template> 
{
   public Template mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      Template template = new Template();
      template.setTemplateId(rs.getInt("TemplateId"));
      template.setName(rs.getString("Name"));
      template.setActive(rs.getInt("Active"));
      return template;
   }
}