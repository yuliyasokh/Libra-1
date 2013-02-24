package com.netcracker.libra.service;

import com.netcracker.libra.dao.AppFormJDBC;
import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.AppForm;
import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.util.security.Security;

public class RegisterService {
	private static StudentJDBC db = new StudentJDBC();
	private static AppFormJDBC appdb = new AppFormJDBC();
	
	public static void registerUser(RegisterForm form) {
		db.create(form.getName(), form.getLastName(), form.getEmail(), Security.getMD5hash(form.getPassword()));
	}
	
	public static void fillAppForm(AppForm form) {
		appdb.createEntry(form);
	}
}
