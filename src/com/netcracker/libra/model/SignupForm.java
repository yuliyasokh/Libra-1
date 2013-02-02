/*
 * ������ �������� � �������� ��� �������������� �����
 * @author Kuyun
 */

package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.Map;

public class SignupForm {

	private Map<String, String> form = new HashMap<>();

	public String getName() {
		return form.get("name");
	}

	public void setName(String name) {
		form.put("name", name);
		System.out.println("Name Saved");
	}

	public String getLastName() {
		return form.get("lastName");
	}

	public void setLastName(String lastName) {
		form.put("lastName", lastName);
	}

	public void setPatronymic(String value) {
		form.put("patronymic", value);
	}

	public String getPatronymic() {
		return form.get("patronymic");
	}

	public void setUniversity(String value) {
		form.put("university", value);
	}

	public String getUniversity() {
		return form.get("University");
	}

	public void setUniverTerm(String value) {
		form.put("univerTerm", value);
	}

	public String getUniverTerm() {
		return form.get("univerTerm");
	}

	public void setFaculty(String value) {
		form.put("faculty", value);
	}

	public String getFaculty() {
		return form.get("faculty");
	}

	public void setGraduated(String value) {
		form.put("graduated", value);
	}

	public String getGraduated() {
		return form.get("graduated");
	}

	public String getEmail() {
		return form.get("email");
	}

	public void setEmail(String value) {
		form.put("email", value);
	}

	public String getEmail2() {
		return form.get("email2");
	}

	public void setEmail2(String value) {
		form.put("email2", value);
	}

	public String getPhoneNumber() {
		return form.get("phoneNumber");
	}

	public void setPhoneNumber(String value) {
		form.put("phoneNumber", value);
	}

	public void setMiscContactType(String value) {
		form.put("type", value);
	}

	public String getMiscContactType() {
		return form.get("type");
	}

	public void setMiscContactValue(String value) {
		form.put(getMiscContactType(), value);
	}

	public String getMiscContactValue() {
		return form.get(getMiscContactType());
	}

	public void setWhatsInterested(String value) {
		form.put("whatsInterested", value);
	}

	public String getWhatsInterested() {
		return form.get("whatsInterested");
	}

	public void setScope(String value) {
		form.put("scope", value);
	}

	public String getScope() {
		return form.get("scope");
	}

	// TODO �������� ��� ����� ������� �������� ������ �� ������� "��� ������"
	public void setDeepSpec(String value) {
		form.put("deepSpec", value);
	}

	public String getDeepSpec() {
		return form.get("deepSpec");
	}

	public void setVariousWork(String value) {
		form.put("variousWork", value);
	}

	public String getVariousWork() {
		return form.get("variousWork");
	}

	public void setManagement(String value) {
		form.put("management", value);
	}

	public String getManagement() {
		return form.get("management");
	}
	
	public void setSales(String value) {
		form.put("sales", value);
	}

	public String getSales() {
		return form.get("sales");
	}
	
	public void setCustomWorkType(String value) {
		form.put("customWorkType", value);
	}

	public String getCustomWorkType() {
		return form.get("customWorkType");
	}

	public void setJavaKnowledge(String value) {
		form.put("javaKnowledge", value);
	}

	public String getJavaKnowledge() {
		return form.get("javaKnowledge");
	}
	
	public void setCKnowledge(String value) {
		form.put("cKnowledge", value);
	}

	public String getCKnowledge() {
		return form.get("cKnowledge");
	}
	
	public void setAnotherLang(String value) {
		form.put("anotherLang", value);
	}

	public String getAnotherLang() {
		return form.get("anotherLang");
	}
	
	public void setAnotherLang2(String value) {
		form.put("anotherLang2", value);
	}

	public String getAnotherLang2() {
		return form.get("anotherLang2");
	}
	
	public void setAnotherLang3(String value) {
		form.put("anotherLang3", value);
	}

	public String getAnotherLang3() {
		return form.get("anotherLang3");
	}
	
	public void setNetworkTechSkill(String value) {
		form.put("networkTech", value);
	}

	public String getNetworkTechSkill() {
		return form.get("networkTech");
	}
	
	public void setEffAlgSkill(String value) {
		form.put("effAlg", value);
	}

	public String getEffAlgSkill() {
		return form.get("effAlg");
	}
	
	public void setOopSkill(String value) {
		form.put("oop", value);
	}

	public String getOopSkill() {
		return form.get("oop");
	}
	
	public void setDBKnowledge(String value) {
		form.put("DBKnowledge", value);
	}

	public String getDBKnowledge() {
		return form.get("DBKnowledge");
	}
	
	public void setWebSkill(String value) {
		form.put("web", value);
	}

	public String getWebSkill() {
		return form.get("web");
	}
	
	public void setGuiSkill(String value) {
		form.put("gui", value);
	}

	public String getGuiSkill() {
		return form.get("gui");
	}
	
	public void setNetworkDevelopmentSkill(String value) {
		form.put("networkDevelopment", value);
	}

	public String getNetworkDevelopmentSkill() {
		return form.get("networkDevelopment");
	}
	
	public void setAppDesignSkill(String value) {
		form.put("appDesign", value);
	}

	public String getAppDesignSkill() {
		return form.get("appDesign");
	}
	
	public void setAnotherSkills(String value) {
		form.put("anotherSkills", value);
	}

	public String getAnotherSkills() {
		return form.get("anotherSkills");
	}
	
	public void setWorkExperience(String value) {
		form.put("workExp", value);
	}

	public String getWorkExperience() {
		return form.get("workExp");
	}
	
	public void setEnglishSkill(String value) {
		form.put("englishSkill", value);
	}

	public String getEnglishSkill() {
		return form.get("englishSkill");
	}
	
	public void setAdvert(String value) {
		form.put("advert", value);
	}

	public String getAdvert() {
		return form.get("advert");
	}
	
	public void setWhyTake(String value) {
		form.put("whyTake", value);
	}

	public String getWhyTake() {
		return form.get("whyTake");
	}
	
	public void setAdditionalDetails(String value) {
		form.put("additionalDetails", value);
	}

	public String getAdditionalDetails() {
		return form.get("additionalDetails");
	}
	
	public Map<String, String> getAppForm() {
		return new HashMap<String,String>();
	}
	
	public void setAppForm(Map<String, String> form) {
		this.form = form;
	}
}
