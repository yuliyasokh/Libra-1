/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class ColumnInfo extends Column
{
    private String typeDescription;
    private String parentName;
    private int parentColumn;
    private int typeId;
    private String numbers;
    private int level;

    public void setLevel(int level) 
    {
        this.level = level;
    }

    public int getLevel() 
    {
        return level;
    }
    
    public void setNumbers(String numbers) 
    {
        this.numbers = numbers;
    }

    public String getNumbers() 
    {
        return numbers;
    }
    
    public int getTypeId() 
    {
        return typeId;
    }

    public void setTypeId(int typeId)
    {
        this.typeId = typeId;
    }
    
    public int getParentColumn() 
    {
        return parentColumn;
    }

    public void setParentColumn(int parentColumn) 
    {
        this.parentColumn = parentColumn;
    }

    
    public String getParentName() 
    {
        return parentName;
    }

    public void setParentName(String parentName) 
    {
        this.parentName = parentName;
    }  
    
    public String getTypeDescription() 
    {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) 
    {
        this.typeDescription = typeDescription;
    }
}
