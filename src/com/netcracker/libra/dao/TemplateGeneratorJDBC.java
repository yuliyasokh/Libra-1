package com.netcracker.libra.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TemplateGeneratorJDBC {

	private static JdbcTemplate jdbcTemplateObject;
	
	public static TemplateGeneratorJDBC getTemplateGeneratorJDBC() {
		return new TemplateGeneratorJDBC();
	}
	
	public TemplateGeneratorJDBC() {
		
	}
	
	public List<University> getUniversities() {
		
		List<University> list = new ArrayList<>();
		String sql = "select * from university where universityid=1";
		list.add((University) jdbcTemplateObject.queryForObject(sql, new BeanPropertyRowMapper<University>()));
		return list;
		
	}
	
	public List<Faculty> getFaculties() {
		
		String sql = "select * from faculty";
		List<Faculty> list  = jdbcTemplateObject.query(sql,
				new BeanPropertyRowMapper<Faculty>());
		return list;
	}
	
	public List<Department> getDepartments() {
		
		String sql = "select * from department";
		List<Department> list  = jdbcTemplateObject.query(sql,
				new BeanPropertyRowMapper<Department>());
		return list;
	}
	
	public class University {
		
		private int universityId;
		private String universityName;
		
		public University getUniversity() {
			return new University();
		}
		
		public int getUniversityId() {
			return universityId;
		}
		
		public void setUniversityId(int id) {
			this.universityId = id;
		}

		public String getUniversityName() {
			return universityName;
		}

		public void setUniversityName(String name) {
			this.universityName = name;
		}
	}
	
	
	
	class Faculty {
		
		private int universityId;
		private int facultyId;
		private String facultyName;

		public int getUniversityId() {
			return universityId;
		}
		
		public void setFacultyId(int id) {
			this.facultyId = id;
		}
		
		public int getFacultyId() {
			return facultyId;
		}
		
		public void setUniversityId(int id) {
			this.universityId = id;
		}

		public String getFacultyName() {
			return facultyName;
		}

		public void setFacultyName(String name) {
			this.facultyName = name;
		}
	}
	
	class Department {
		
		private int id;
		private String name;

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
