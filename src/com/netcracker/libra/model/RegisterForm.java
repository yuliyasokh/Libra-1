package com.netcracker.libra.model;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class RegisterForm {
	
	@NotEmpty
	@Length(max=20)
	private String name;
	
	@NotEmpty
	@Length(max=30)
	private String lastName;
	

	@Length(min=6, max=20)
	private String password;
	

	@Length(min=6, max=20)
	private String confirmedPassword;
	
	@NotEmpty
	@Email
	@Length(max=50)
	private String email;
	
	public RegisterForm() {
		
	}
	
	public RegisterForm getRegisterForm() {
		return new RegisterForm();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@AssertTrue
	public boolean checkPassword() {
		if (password == null) {
            return false;
        } else {
            return password.equals(confirmedPassword);
       }
	}
	
}
