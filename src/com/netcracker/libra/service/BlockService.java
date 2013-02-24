package com.netcracker.libra.service;

import java.util.Map;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.model.BlockWithValues;

public class BlockService {
	
	private static AppFormJDBC jdbc = new AppFormJDBC();
	private static Map b1 = jdbc.getTextBlocks();
	private static Map b2 = jdbc.getCheckboxBlocks();
	private static Map b3 = jdbc.getGradeBlocks();
	private static Map universities = jdbc.getAllUniversities();
	private static Map faculties = jdbc.getAllFaculties(); 
	private static Map departments = jdbc.getAllDepartments();
	
	public static Map<Integer, BlockWithValues> retrieveTextFieldBlocks() {
		return b1;
	}
	
	public static Map<Integer, BlockWithValues> retrieveCheckboxBlocks() {
		return b2;
	}
	
	public static Map<Integer, BlockWithValues> retrieveGradeBlocks() {
		return b3;
	}
	
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
