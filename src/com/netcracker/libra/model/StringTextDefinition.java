/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class StringTextDefinition extends abstractType
{
    private int maxLength;
    public StringTextDefinition(columnType c)
    {
        cType=c;
    }

    public int getMaxLength() 
    {
        return maxLength;
    }

    public void setMaxLength(int maxLength) 
    {
        this.maxLength = maxLength;
    }
     
}
