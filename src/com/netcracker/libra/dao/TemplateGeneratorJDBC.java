package com.netcracker.libra.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TemplateGeneratorJDBC {

	private static JdbcTemplate jdbcTemplateObject;
	
	public static TemplateGeneratorJDBC getTemplateGeneratorJDBC() {
		return new TemplateGeneratorJDBC();
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public TemplateGeneratorJDBC() {
		
	}
	
	public Map<Integer, String> getAllUniversities() {
		
		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from university";
		
		for (Map<String, Object> x: jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("universityid")).intValueExact(),(String)x.get("universityname"));
		}
		return map;
		
	}
	
	public Map<Integer, String> getAllFaculties() {
		
		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from faculty";
		
		for (Map<String, Object> x: jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("facultyid")).intValueExact(),(String)x.get("facultyname"));
		}
		return map;
		
	}
	
	public Map<Integer, String> getAllDepartments() {
		
		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from department";
		
		for (Map<String, Object> x: jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("departmentid")).intValueExact(),(String)x.get("departmentname"));
		}
		return map;
		
	}
	
}
