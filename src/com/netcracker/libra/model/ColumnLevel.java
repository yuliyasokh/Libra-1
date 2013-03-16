/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

import java.util.List;

/**
 *
 * @author Sashenka
 */
public class ColumnLevel extends Column
{
    protected int lavel;

    public void setLavel(int lavel) 
    {
        this.lavel = lavel;
    }

    public int getLavel() 
    {
        return lavel;
    }
    
    private List<ColumnLevel> list;
    
    public List<ColumnLevel> getList()
    {
        return list;
    }
    
    public void setList(List<ColumnLevel> val)
    {
        list = val;
    }
}
