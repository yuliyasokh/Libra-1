package com.netcracker.libra.model;

import java.util.List;

public class Student {
    //my student
	   private Integer id;
	   private String name;
	   private String lastName;
	   private String email;
	   private String password;
	   private int roleId;
           private int appId;
           private String patronymic;
           private String phoneNumber;
           private int departmentId;
           private int advertisingId;
           private String advertisingComment;
           private int course;
           private int graduated;
           private java.sql.Date dataCreation;
           private int modifiedBy;
	   private List customFields;
	   
           public Student(){
               
           }
	   public Student(String name,String lastName) {
               this.name=name;
               this.lastName=lastName;
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
           public void setAppId(int appId){
               this.appId=appId;
           }
           public int getAppId(){
               return appId;
           }
	   public List getCustomFields() {
		   return customFields;
	   }
           public void setPatronymic(String patronymic){
               this.patronymic=patronymic;
           }
           public String getPatronymic(){
               return patronymic;
           }
           public void setPhoneNumber(String phoneNumber){
               this.phoneNumber=phoneNumber;
           }
           public String getPhoneNumber(){
               return phoneNumber;
           }
           public void setDepartmentId(int departmentId){
               this.departmentId=departmentId;
           }
           public int getDepartmentId(){
               return departmentId;
           }
           public void setAdvertisingId(int advertisingId){
               this.advertisingId=advertisingId;
           }
           public int getAdvertisingID(){
               return advertisingId;
           }
           public void setAdvertisingComment(String advertisingComment){
               this.advertisingComment=advertisingComment;
           }
           public String getAdvertisingComment(){
               return advertisingComment;
           }
           public void setCourse(int course){
               this.course=course;
           }
           public int getCourse(){
               return course;
           }
           public void SetGraduated(int graduated){
               this.graduated=graduated;
           }
           public int getGraduated(){
               return graduated;
           }
           public void setDataCreation(java.sql.Date dataCreation){
               this.dataCreation=dataCreation;
           }
           public java.sql.Date getDataCreation(){
               return dataCreation;
           }
           public void setModifiedBy(int modifiedBy){
               this.modifiedBy=modifiedBy;
           }
           public int getModifiedBy(){
               return modifiedBy;
           }
           
	}