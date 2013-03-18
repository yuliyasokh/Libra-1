/*
 * Contains fieldset for application form
 * 
 */

package com.netcracker.libra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlockWithValues {

	private long blockID;
	private Map<Integer, String> values = new HashMap<>();
	private String header;
	private ArrayList<String> cbAnswers = new ArrayList<>();
	
	public BlockWithValues() {
		System.out.println("Created block");
	}
	
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
	public ArrayList<String> getCbAnswers() {
		return cbAnswers;
	}
	public void setCbAnswers(ArrayList<String> cbAnswers) {
		this.cbAnswers = cbAnswers;
	}
}
