package com.netcracker.libra.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netcracker.libra.model.AppForm;
import com.netcracker.libra.model.RegisterForm;

@Repository
public class AppFormJDBC {
	
	
	private static JdbcTemplate jdbcTemplateObject;
	
	public AppFormJDBC() {
		
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	private int getCurrVal() {
	       String SQL = "select AppForm_seq.NEXTVAL as AppId from dual";
	       Integer id = jdbcTemplateObject.queryForInt(SQL);
	       return id;
	   }
	
	public void createEntry(AppForm form, Integer userid) {
		Integer appid = getCurrVal();
		Map<String, String> f = form.getPersonal(); 
		String sql = "insert into " +
				"appform (APPID,USERID,PATRONYMIC,PHONENUMBER,DEPARTMENTID,ADVERTISINGID,ADVERTISINGCOMMENT,COURSE,GRADUATED,TEMPLATEID) " +
				"values (?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplateObject.update(sql, appid, userid, f.get("patronymic"), 
				f.get("phoneNumber"), 1, 1, "comment", f.get("term"), f.get("graduated"), 17);
	}
	
}
