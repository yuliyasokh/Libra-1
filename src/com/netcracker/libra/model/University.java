/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Yuliya
 */
public class University {
    
    private int universityId;
    private String universityName;
    
    public void setUniversityId(int universityId){
        this.universityId=universityId;
    }
    public int getUniversityId(){
        return universityId;
    }
    public void setUniversityName(String universityName){
        this.universityName=universityName;
    }
    public String getUniversityName(){
        return universityName;
    }
}
