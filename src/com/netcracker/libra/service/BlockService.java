package com.netcracker.libra.service;

import java.util.Map;

import com.netcracker.libra.dao.AppFormJDBC;

public class BlockService {
	
	private static AppFormJDBC jdbc = new AppFormJDBC();
	private static Map<Integer, String> universities = jdbc.getAllUniversities();
	private static Map<Integer, String> faculties = jdbc.getAllFaculties(); 
	private static Map<Integer, String> departments = jdbc.getAllDepartments();
	
	public static Map<Integer, String> getUniversityList() {
		return universities;
	}
	
	public static Map<Integer, String> getFacultyList() {
		return faculties;
	}
	
	public static Map<Integer, String> getDepartmentList() {
		return departments;
	}
}
