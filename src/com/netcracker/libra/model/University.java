/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/** University consists from University number and University name.
 *  Uses for student's search and filling appform
 *  Universities can be created, edited, deleted.
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
