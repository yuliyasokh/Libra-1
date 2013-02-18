package com.netcracker.libra.service;

import java.util.List;

import com.netcracker.libra.dao.TemplateGeneratorJDBC;

public class TemplateGenerator {
	
	TemplateGeneratorJDBC jdbc = new TemplateGeneratorJDBC();
	
	public List getUniversityList() {
		return jdbc.getUniversities();
	}
	
	public List getFacultyList() {
		return jdbc.getFaculties();
	}
	
	public List getDepartmentList() {
		return jdbc.getDepartments();
	}
	
}
