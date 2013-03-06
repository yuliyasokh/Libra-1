/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**Departemnt consists from department number, department name, faculty number, faculty name, 
 * university number and university name.
 * Uses in student's search and filling appform
 * Department can be created, edited and deleted.
 *
 * @author Yuliya
 */
public class Department {

    private int departmentId;
    private String departmentName;
    private int facId;
    private String facultyName;
    private int universityId;
    private String universityName;
    
    public void setDepartmentId(int departmentId){
        this.departmentId=departmentId;
    }
    public int getDepartmentId(){
        return departmentId;
    }
    public void setUniversityId(int universityId){
        this.universityId=universityId;
    }
    public int getUniversityId(){
        return universityId;
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
    public void setFacultyName(String facultyName){
        this.facultyName=facultyName;
    }
    public String getFacultyName(){
        return facultyName;
    }
    public void setUniversityName(String universityName){
        this.universityName=universityName;
    }
    public String getUniversityName(){
        return universityName;
    }
    
}
