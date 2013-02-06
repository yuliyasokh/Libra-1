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
public class Template 
{
    private int templateId;
    private String name;
    private int active;
    public void setTemplateId(int templateId) 
    {
	      this.templateId = templateId;
    }
    public int getTemplateId() 
    {
	      return templateId;
    }
    
    public void setName(String name) 
    {
	      this.name = name;
    }
    public String getName() 
    {
	      return name;
    }
    
    public int getActive()
    {
        return active;
    }
    
    public void setActive(int active)
    {
        this.active=active;
    }
    
    //added 02.02.2013
    public List<Topic> getTopics() {
    	com.netcracker.libra.dao.TopicJDBC db = new com.netcracker.libra.dao.TopicJDBC();
    	return db.getAll(getTemplateId());
    }
}

