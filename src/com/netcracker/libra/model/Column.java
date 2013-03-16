/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class Column 
{
    private int columnId;
    private String Name;
    private int parentColumn;

    public int getParentColumn() 
    {
        return parentColumn;
    }

    public void setParentColumn(int parentColumn) 
    {
        this.parentColumn = parentColumn;
    }
    
    public String getName() 
    {
        return Name;
    }

    public int getColumnId() 
    {
        return columnId;
    }

    public void setColumnId(int columnId) 
    {
        this.columnId = columnId;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }
 
    /*int ColumnId;
    int TemplateId;
    String Name;
    int TypeId ;
    int ParentColumn ;
     
    
    public String getName() 
    {
        return Name;
    }

    public int getColumnId() 
    {
        return ColumnId;
    }

    public int getParentColumn() 
    {
        return ParentColumn;
    }

    public int getTemplateId() 
    {
        return TemplateId;
    }

    public int getTypeId() 
    {
        return TypeId;
    }

    public void setColumnId(int ColumnId) 
    {
        this.ColumnId = ColumnId;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public void setParentColumn(int ParentColumn) 
    {
        this.ParentColumn = ParentColumn;
    }

    public void setTemplateId(int TemplateId) 
    {
        this.TemplateId = TemplateId;
    }

    public void setTypeId(int TypeId) 
    {
        this.TypeId = TypeId;
    }
    */
}
