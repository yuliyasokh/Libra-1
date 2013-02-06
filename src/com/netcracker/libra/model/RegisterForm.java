package com.netcracker.libra.model;

import javax.validation.constraints.*;

public class RegisterForm {
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	@Size(min=1, max=50)
	private String lastName;
	
	@NotNull
	@Size(min=6, max=40)
	private String password;
	
	@NotNull
	@Size(min=6, max=40)
	private String confirmedPassword;
	
	@NotNull
	@Size(max=40)
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
	
	@AssertTrue(message="Пароли не совпадают")
	public boolean checkPassword() {
		if (password == null) {
            return false;
        } else {
            return password.equals(confirmedPassword);
       }
	}
	
}
