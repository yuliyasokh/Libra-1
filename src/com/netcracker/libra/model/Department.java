/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Yuliya
 */
public class Department {

    private int departmentId;
    private String departmentName;
    private int facId;
    
    public void setDepartmentId(int departmentId){
        this.departmentId=departmentId;
    }
    public int getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName=departmentName;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setFacId(int facId){
        this.facId=facId;
    }
    public int getFacId(){
        return facId;
    }
    
}
