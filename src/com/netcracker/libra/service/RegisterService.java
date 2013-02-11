package com.netcracker.libra.service;

import com.netcracker.libra.dao.StudentJDBC;
import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.util.security.Security;

public class RegisterService {
	private static StudentJDBC db = new StudentJDBC();
	
	public static void registerUser(RegisterForm form) {
		db.create(form.getName(), form.getLastName(), form.getEmail(), Security.getMD5hash(form.getPassword()));
	}
}
