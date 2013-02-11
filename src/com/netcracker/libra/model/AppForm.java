package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.Map;

public class AppForm {
	
	private String patronymic;
	private String telephoneNumber;
	private String otherContacts;
	private String university;
	private String term;
	private String faculty;
	private String graduated;
	private Map<String, String> whatsInterestedList = new HashMap<>();
	private Map<String, String> workTypeList  = new HashMap<>();
	private Map<String, String> knowledgesList  = new HashMap<>();
	private String[] interests;
	private String[] workType;
	private String[] knowledges;
	private Map<String, String> interestsMap = new HashMap<>();
	private Map<String, String> workTypeMap = new HashMap<>();
	private Map<String, String> knowledgesMap = new HashMap<>();
	
	{
		whatsInterestedList.put("studyCenter", "Учебный центр");
		whatsInterestedList.put("internShip", "Cтажировка");
		whatsInterestedList.put("softwareDevelopment", "Разработка ПО");
		whatsInterestedList.put("workInCompany", "Работа в компании");
		interestsMap.put("studyCenter", "Учебный центр");
		interestsMap.put("internShip", "Cтажировка");
		interestsMap.put("softwareDevelopment", "Разработка ПО");
		interestsMap.put("workInCompany", "Работа в компании");
		workTypeList.put("deepSpec", "Глубокая специализация");
		workTypeList.put("variousWork", "Разнообразная работа");
		workTypeList.put("management", "Управление специалистами");
		workTypeList.put("sales", "Продажи");
		knowledgesList.put("networkTech", "Сетевые технологии");
		knowledgesList.put("algorithms", "Эффективные алгоритмы");
		knowledgesList.put("OOP", "Объектно-ориентированное программирование");
		knowledgesList.put("database", "Базы данных");
		knowledgesList.put("web", "Web-технологии");
		knowledgesList.put("GUI", "Графический интерфейс (не Web)");
		knowledgesList.put("networkProgramming", "Графический интерфейс (не Web)");
		knowledgesList.put("applicationDesign", "Проектирование программ");
	}
	
	public AppForm getAppForm() {
		return new AppForm();
	}
	

	/**
	 * @return the interests
	 */
	public Map<String, String> getWhatsInterestedList() {
		return whatsInterestedList;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setWhatsInterested(Map<String, String> whatsInterestedList) {
		this.whatsInterestedList = whatsInterestedList;
	}
	/**
	 * @return the interests
	 */
	public String[] getInterests() {
		return interests;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	/**
	 * @return the workType
	 */
	public Map<String, String> getWorkTypeList() {
		return workTypeList;
	}
	/**
	 * @param workType the workType to set
	 */
	public void setWorkType(Map<String, String> workTypeList) {
		this.workTypeList = workTypeList;
	}
	/**
	 * @return the workType
	 */
	public String[] getWorkType() {
		return workType;
	}
	/**
	 * @param workType the workType to set
	 */
	public void setWorkType(String[] workType) {
		this.workType = workType;
	}
	/**
	 * @return the patronymic
	 */
	public String getPatronymic() {
		return patronymic;
	}
	/**
	 * @param patronymic the patronymic to set
	 */
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the otherContacts
	 */
	public String getOtherContacts() {
		return otherContacts;
	}

	/**
	 * @param otherContacts the otherContacts to set
	 */
	public void setOtherContacts(String otherContacts) {
		this.otherContacts = otherContacts;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}

	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	/**
	 * @return the graduated
	 */
	public String getGraduated() {
		return graduated;
	}

	/**
	 * @param graduated the graduated to set
	 */
	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}


	/**
	 * @return the knowledges
	 */
	public String[] getKnowledges() {
		return knowledges;
	}


	/**
	 * @param knowledges the knowledges to set
	 */
	public void setKnowledges(String[] knowledges) {
		this.knowledges = knowledges;
	}


	/**
	 * @return the knowledgesList
	 */
	public Map<String, String> getKnowledgesList() {
		return knowledgesList;
	}


	/**
	 * @param knowledgesList the knowledgesList to set
	 */
	public void setKnowledgesList(Map<String, String> knowledgesList) {
		this.knowledgesList = knowledgesList;
	}


	/**
	 * @return the interestsMap
	 */
	public Map<String, String> getInterestsMap() {
		return interestsMap;
	}


	/**
	 * @param interestsMap the interestsMap to set
	 */
	public void setInterestsMap(Map<String, String> interestsMap) {
		this.interestsMap = interestsMap;
	}


	/**
	 * @return the workTypeMap
	 */
	public Map<String, String> getWorkTypeMap() {
		return workTypeMap;
	}


	/**
	 * @param workTypeMap the workTypeMap to set
	 */
	public void setWorkTypeMap(Map<String, String> workTypeMap) {
		this.workTypeMap = workTypeMap;
	}


	/**
	 * @return the knowledgesMap
	 */
	public Map<String, String> getKnowledgesMap() {
		return knowledgesMap;
	}


	/**
	 * @param knowledgesMap the knowledgesMap to set
	 */
	public void setKnowledgesMap(Map<String, String> knowledgesMap) {
		this.knowledgesMap = knowledgesMap;
	}
}
