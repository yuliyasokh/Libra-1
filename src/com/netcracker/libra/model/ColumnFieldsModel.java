/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sashenka
 */
public class ColumnFieldsModel
{
    Map<Integer,String> map = new HashMap<Integer,String>();
    public Map<Integer,OtherField> otherMap=new HashMap<Integer,OtherField>();

    public Map<Integer, OtherField> getOtherMap() 
    {
        return otherMap;
    }

    public void setOtherMap(Map<Integer, OtherField> otherMap) 
    {
        this.otherMap = otherMap;
    }
    public void setMap(Map<Integer,String> map)
    {
        this.map = map;  
    }
    
    public Map<Integer,String> getMap()
    {
        return map;
    }       
}
