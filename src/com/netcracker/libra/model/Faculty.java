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
    
    public void setFacultyId(int facultyId){
        this.facultyId=facultyId;
    }
    public int getFacultyId(){
        return facultyId;
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
