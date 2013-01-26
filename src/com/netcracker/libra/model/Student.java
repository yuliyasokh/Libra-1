package com.netcracker.libra.model;

import java.util.List;

public class Student {
	   private Integer id;
	   private String name;
	   private String lastName;
	   private String email;
	   private String password;
	   private int roleId;
	   private List customFields;
	   
	   public Student() {
	   }

	   public void setId(Integer id) {
	      this.id = id;
	   }
	   public Integer getId() {
	      return id;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }
	   
	   public void setLastName(String lastName) {
		      this.lastName = lastName;
		   }
	   public String getLastName() {
		      return lastName;
		   }

	   public void setEmail(String email) {
	      this.email = email;
	   }
	   public String getEmail() {
	      return email;
	   }
	   
	   public void setPassword(String password) {
		      this.password = password;
		   }
	   public String getPassword() {
		      return password;
		   }
	   
	   public void setRoleId(Integer id) {
		   this.roleId = id;
	   }
	   public Integer getRoleId() {
		   return roleId;
	   }
	   
	   public List getCustomFields() {
		   return customFields;
	   }
	}