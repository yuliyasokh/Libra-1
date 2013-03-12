package com.netcracker.libra.service;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.model.AppForm;

public class FormService {
	
	private static AppFormJDBC jdbc = new AppFormJDBC();

	public static AppForm showAppFormById(Integer userID) {
		return jdbc.queryForAppForm(userID);
	}
}
