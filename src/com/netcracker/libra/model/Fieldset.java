/*
 * This is model for populating sign up form with values from persistent storage
 */

package com.netcracker.libra.model;

import java.util.Map;

public class Fieldset {
	
	private String header;
	private Integer id;
	private Integer typeId;
	private Map<Integer, String> fieldList;
	
	public Fieldset(){};
	
	public Fieldset(Integer id, String header) {
		this.id = id;
		this.header = header;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer columnId) {
		this.id = columnId;
	}
	public Map<Integer, String> getFieldList() {
		return fieldList;
	}
	public void setFieldList(Map<Integer, String> fieldList) {
		this.fieldList = fieldList;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	
}
