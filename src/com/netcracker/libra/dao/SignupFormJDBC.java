package com.netcracker.libra.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SignupFormJDBC {
	
	private static JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	       jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public void main(String[] args) {
	}

}
