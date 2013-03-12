package com.netcracker.libra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppForm {

	private List<BlockWithValues> checkboxAnswersList = new ArrayList<>();
	private List<BlockWithValues> gradeAnswersList = new ArrayList<>();
	private Map<String, String> textFieldsAnswersList = new HashMap<>();
	private Map<String, String> personal = new HashMap<>();
	
	public List<BlockWithValues> getCheckboxAnswersList() {
		return checkboxAnswersList;
	}
	public void setCheckboxAnswersList(List<BlockWithValues> checkboxAnswersList) {
		this.checkboxAnswersList = checkboxAnswersList;
	}
	public List<BlockWithValues> getGradeAnswersList() {
		return gradeAnswersList;
	}
	public void setGradeAnswersList(List<BlockWithValues> gradeAnswersList) {
		this.gradeAnswersList = gradeAnswersList;
	}
	public Map<String, String> getTextFieldsAnswersList() {
		return textFieldsAnswersList;
	}
	public void setTextFieldsAnswersList(Map<String, String> textFieldsAnswersList) {
		this.textFieldsAnswersList = textFieldsAnswersList;
	}
	public Map<String, String> getPersonal() {
		return personal;
	}
	public void setPersonal(Map<String, String> personal) {
		this.personal = personal;
	}
	
}
