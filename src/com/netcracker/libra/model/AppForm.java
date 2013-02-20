package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.netcracker.libra.service.TemplateGenerator;

public class AppForm {
	
	private TemplateGenerator gen = new TemplateGenerator();
	
	/*
	 * Набор постоянных значений анкеты
	 */	
	private Map<String, String> personal = new HashMap<>();
	private MultipartFile photo;
	
	/*
	 * Коллекции, содержащие значения ярлыков для форм 
	 * (должны содержать значения, могут содержать динамически создаваемые данные)
	 */
	private Map<String, String> whatsInterestedList = new HashMap<>();
	private Map<String, String> workTypeList  = new HashMap<>();
	private Set<String> knowledgesList  = new HashSet<>();
	private Set<String> programmingLanguagesList = new HashSet<>();
	private Set<String> textFieldsList = new HashSet<>();
	private Map<String, List> universityList = new HashMap<>();
	
	/*
	 * Содержат отмеченные пользователем значения чекбоксов
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
	 * Сюда будет помещаться изменяемый список вопросов анкеты
	 */
	private Map<String, String> referenceData = new HashMap<>();
	
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
		whatsInterestedList.put("workInCompany", "Работа в компании");
		
		workTypeList.put("softwareDevelopment", "Разработка ПО");
		workTypeList.put("deepSpec", "Глубокая специализация");
		workTypeList.put("variousWork", "Разнообразная работа");
		workTypeList.put("management", "Управление специалистами");
		workTypeList.put("sales", "Продажи");
		
	//	universityList.put("universities", gen.getUniversityList());
	//	universityList.put("faculties", gen.getFacultyList());
	//	universityList.put("departments", gen.getDepartmentList());
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


	/**
	 * @return the referenceData
	 */
	public Map<String, String> getReferenceData() {
		return referenceData;
	}


	/**
	 * @param referenceData the referenceData to set
	 */
	public void setReferenceData(Map<String, String> referenceData) {
		this.referenceData = referenceData;
	}


	public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
}
