/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class Type 
{
    int typeId;
    String typeName;
    String description;

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    public int getTypeId() 
    {
        return typeId;
    }

    public void setTypeId(int typeId) 
    {
        this.typeId = typeId;
    }

    public String getTypeName() 
    {
        return typeName;
    }

    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }
}
