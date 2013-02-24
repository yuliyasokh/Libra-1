/*
 * Содержит набор значений для вопроса, соответствующих шаблону
 * 
 */

package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.Map;

public class BlockWithValues {

	private long blockID;
	private Map<Integer, String> values = new HashMap<>();
	private String header;
	
	public long getBlockID() {
		return blockID;
	}
	public void setBlockID(long blockID) {
		this.blockID = blockID;
	}
	public Map<Integer, String> getValues() {
		return values;
	}
	public void setValues(Map<Integer, String> values) {
		this.values = values;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
}
