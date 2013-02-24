package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.netcracker.libra.service.BlockService;

public class FilledAppForm {
	
	private Map<String, Integer> checkboxAnswers = new HashMap<>();
	private Map<Integer, String> gradeAnswers = new HashMap<>();
	private Map<Integer, String> textFieldsAnswers = new HashMap<>();
	private Map<String, String> personal = new HashMap<>();
	private MultipartFile photo;
	
	public Map<String, Integer> getCheckboxAnswers() {
		return checkboxAnswers;
	}

	public void setCheckboxAnswers(Map<String, Integer> checkboxAnswers) {
		this.checkboxAnswers = checkboxAnswers;
	}

	public Map<Integer, String> getTextFieldsAnswers() {
		return textFieldsAnswers;
	}

	public void setTextFieldsAnswers(Map<Integer, String> textFieldsAnswers) {
		this.textFieldsAnswers = textFieldsAnswers;
	}

	public Map<Integer, String> getGradeAnswers() {
		return gradeAnswers;
	}

	public void setGradeAnswers(Map<Integer, String> gradeAnswers) {
		this.gradeAnswers = gradeAnswers;
	}

	public Map<String, String> getPersonal() {
		return personal;
	}

	public void setPersonal(Map<String, String> personal) {
		this.personal = personal;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	public Map<Integer, String> getUniversityList() {
		return BlockService.getUniversityList();
	}


	public Map<Integer, String> getFacultyList() {
		return BlockService.getFacultyList();
	}


	public Map<Integer, String> getDepartmentList() {
		return BlockService.getDepartmentList();
	}
}
