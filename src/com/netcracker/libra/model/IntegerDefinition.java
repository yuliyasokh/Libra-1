/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class IntegerDefinition extends abstractType
{  
    private int max;
    private int min;
    public IntegerDefinition(columnType c)
    {
        cType=c;
    }

    public void setMinMax(String s) 
    {
        String[] mas=s.split(";");
        min=Integer.parseInt(mas[0].trim());
        max=Integer.parseInt(mas[1].trim());
    }

    public int getMax() 
    {
        return max;
    }

    public int getMin() 
    {
        return min;
    }
}
