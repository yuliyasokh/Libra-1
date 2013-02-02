/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;
import com.netcracker.libra.model.InfoForDelete;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author Sashenka
 */
public class InfoForDeleteRowMapper implements RowMapper<InfoForDelete> 
{
   public InfoForDelete mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      InfoForDelete infoForDelete = new InfoForDelete();
      infoForDelete.setAppId(rs.getInt("AppId"));
      infoForDelete.setFirstname(rs.getString("FirstName"));
      infoForDelete.setLastname(rs.getString("LastName"));
      infoForDelete.setPatronymic(rs.getString("Patronymic"));
      infoForDelete.setUserId(rs.getInt("UserId"));
      return infoForDelete;
   }
}