package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AppForm {
	
	
	/*
	 * Набор постоянных значений анкеты
	 */
	private String patronymic;
	private String telephoneNumber;
	private String otherContacts;
	private String university;
	private String term;
	private String faculty;
	private String graduated;
	private String advert;
	
	private Map<String, String> personal = new HashMap<>();
	
	/*
	 * Коллекции, содержащие значения ярлыков для чекбоксов 
	 * (должны содержать значения, могут содержать динамически создаваемые данные)
	 */
	private Map<String, String> whatsInterestedList = new HashMap<>();
	private Map<String, String> workTypeList  = new HashMap<>();
	private Set<String> knowledgesList  = new HashSet<>();
	private Set<String> programmingLanguagesList = new HashSet<>();
	private Set<String> textFieldsList = new HashSet<>();
	
	/*
	 * Содержат отмеченные пользователем значения
	 */
	
	private String[] interests;
	private String[] workTypes;
	
	/*
	 * Коллекции, в которые помещаются значения, введенные в форму
	 */
	private Map<String, String> programmingLanguagesMap = new HashMap<>();
	private Map<String, String> englishGradesMap = new HashMap<>();
	private Map<String, String> knowledgesMap = new HashMap<>();
	private Map<String, String> textFieldsMap = new HashMap<>();
	
	
	/*
	 * Блок инициализации, в будущем удалить. Переделать под шаблоны из БД.
	 */
	
	{
		programmingLanguagesList.add("Java");
		programmingLanguagesList.add("C++");
		programmingLanguagesList.add("C#");
		programmingLanguagesList.add(".NET");
		programmingLanguagesList.add("Python");
		
		textFieldsList.add("Если у тебя есть опыт работы или выполненные учебные проекты, опиши их");
		textFieldsList.add("Почему именно тебя следует взять в NetCracker? Важные достоинства, возможно обещания?");
		textFieldsList.add("Дополнительные сведения о себе: олимпиады, курсы, поощрения, сертификаты и т.п.");
		
		knowledgesList.add("Сетевые технологии");
		knowledgesList.add("Эффективные алгоритмы");
		knowledgesList.add("ООП");
		knowledgesList.add("Базы данных");
		knowledgesList.add("Web-технологии");
		knowledgesList.add("Графический интерфейс (не Web)");
		knowledgesList.add("Сетевое программирование");
		knowledgesList.add("Проектирование программ");
		
		whatsInterestedList.put("studyCenter", "Учебный центр");
		whatsInterestedList.put("internShip", "Cтажировка");
		whatsInterestedList.put("softwareDevelopment", "Разработка ПО");
		whatsInterestedList.put("workInCompany", "Работа в компании");
		
		workTypeList.put("deepSpec", "Глубокая специализация");
		workTypeList.put("variousWork", "Разнообразная работа");
		workTypeList.put("management", "Управление специалистами");
		workTypeList.put("sales", "Продажи");
	}
	
	
	/*
	 * Набор геттеров и сеттеров
	 */
	
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
	public String[] getWorkTypes() {
		return workTypes;
	}
	/**
	 * @param workType the workType to set
	 */
	public void setWorkTypes(String[] workTypes) {
		this.workTypes = workTypes;
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
	 * @return the knowledgesList
	 */
	public Set<String> getKnowledgesList() {
		return knowledgesList;
	}


	/**
	 * @param knowledgesList the knowledgesList to set
	 */
	public void setKnowledgesList(Set<String> knowledgesList) {
		this.knowledgesList = knowledgesList;
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


	public Map<String, String> getEnglishGradesMap() {
		return englishGradesMap;
	}


	public void setEnglishGradesMap(Map<String, String> englishGradesMap) {
		this.englishGradesMap = englishGradesMap;
	}


	public Map<String, String> getTextFieldsMap() {
		return textFieldsMap;
	}


	public void setTextFieldsMap(Map<String, String> textFieldsMap) {
		this.textFieldsMap = textFieldsMap;
	}


	/**
	 * @return the programmingLanguagesMap
	 */
	public Map<String, String> getProgrammingLanguagesMap() {
		return programmingLanguagesMap;
	}


	/**
	 * @param programmingLanguagesMap the programmingLanguagesMap to set
	 */
	public void setProgrammingLanguagesMap(Map<String, String> programmingLanguagesMap) {
		this.programmingLanguagesMap = programmingLanguagesMap;
	}
	
	public Set<String> getProgrammingLanguagesList() {
		return programmingLanguagesList;
	}


	public void setProgrammingLanguagesList(Set<String> programmingLanguagesList) {
		this.programmingLanguagesList = programmingLanguagesList;
	}


	public void setWhatsInterestedList(Map<String, String> whatsInterestedList) {
		this.whatsInterestedList = whatsInterestedList;
	}


	public void setWorkTypeList(Map<String, String> workTypeList) {
		this.workTypeList = workTypeList;
	}


	/**
	 * @return the textFieldsList
	 */
	public Set<String> getTextFieldsList() {
		return textFieldsList;
	}


	/**
	 * @param textFieldsList the textFieldsList to set
	 */
	public void setTextFieldsList(Set<String> textFieldsList) {
		this.textFieldsList = textFieldsList;
	}


	/**
	 * @return the personal
	 */
	public Map<String, String> getPersonal() {
		return personal;
	}


	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(Map<String, String> personal) {
		this.personal = personal;
	}
	
	
}
