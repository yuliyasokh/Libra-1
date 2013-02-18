package com.netcracker.libra.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class AppFormJDBC {
	
	private static JdbcTemplate jdbcTemplateObject;
	
	private int getCurrVal() {
	       String SQL="select AppForm_seq.NEXTVAL as AppId from dual";
	       return jdbcTemplateObject.queryForInt(SQL);
	   }
	
}
