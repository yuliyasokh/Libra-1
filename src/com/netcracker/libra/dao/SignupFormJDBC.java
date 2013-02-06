package com.netcracker.libra.dao;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.netcracker.libra.model.Topic;

public class SignupFormJDBC {
	
	private static JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	       jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public List<Topic> getCurrentTemplate() {
		
		com.netcracker.libra.dao.TopicJDBC topdb = new com.netcracker.libra.dao.TopicJDBC();
		com.netcracker.libra.dao.TemplateJDBC tdb = new com.netcracker.libra.dao.TemplateJDBC();
		return topdb.getAll(tdb.getActive().getTemplateId());
	}
	
	

}
