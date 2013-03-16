/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class EnumDefinition  extends abstractType
{
    private String[] emums;
    
    public EnumDefinition(columnType c)
    {
        cType=c;
    }

    public void setEmums(String emums) 
    {
        this.emums = emums.split(",");
    }  

    public String[] getEmums() 
    {
        return emums;
    }
    
}
