/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Yuliya
 */
public class Faculty {
    
    private int facultyId;
    private String facultyName;
    private int universityId;
    private String universityName;
    
    public void setFacultyId(int facultyId){
        this.facultyId=facultyId;
    }
    public int getFacultyId(){
        return facultyId;
    }
    public void setUniversityName(String universityName){
        this.universityName=universityName;
    }
    public String getUniversityName(){
        return universityName;
    }
    public void setFacultyName(String facultyName){
        this.facultyName=facultyName;
    }
    public String getFacultyName(){
        return facultyName;
    }
    public void setUniverId(int universityId){
        this.universityId=universityId;
    }
    public int getUniverId(){
        return universityId;
    }
}
