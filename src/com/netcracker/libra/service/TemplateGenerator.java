package com.netcracker.libra.service;
import java.util.Map;

import com.netcracker.libra.dao.TemplateGeneratorJDBC;

public class TemplateGenerator {
	
	TemplateGeneratorJDBC jdbc = new TemplateGeneratorJDBC();
	
	public Map<Integer, String> getUniversityList() {
		return jdbc.getAllUniversities();
	}
	
	public Map<Integer, String> getFacultyList() {
		return jdbc.getAllFaculties();
	}
	
	public Map<Integer, String> getDepartmentList() {
		return jdbc.getAllDepartments();
	}
	
}
