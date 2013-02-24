package com.netcracker.libra.service;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.model.FilledAppForm;
import com.netcracker.libra.model.RegisterForm;

public class RegisterService {

	public static void fillAppForm(RegisterForm form, FilledAppForm rform) {
		System.out.println("Sending to JDBC");
		new AppFormJDBC().saveData(rform, form);
	}
}
