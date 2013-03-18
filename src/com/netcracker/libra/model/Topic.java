/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Sashenka
 */
public class Topic 
{
    private int topicId;
    private String name;
    private String comments;
    private int templateId;
    private int parentTopic;
    private int requierOther;
    private List<Map> columnsList;
    
    public void setTopicId(int topicId) 
    {
	this.topicId = topicId;
    }
    public int getTopicId() 
    {
	return this.topicId;
    }
    public void setName(String name) 
    {
	this.name = name;
    }
    public String getName() 
    {
	return name;
    }
    public void setComments(String comments)
    {
        this.comments=comments;
    }
    public String getComments()
    {
        return this.comments;
    }
    public void setTemplate(int templateId)
    {
        this.templateId=templateId;
    }
    public int getTemplate()
    {
        return this.templateId;
    }
    public void setParentTopic(int parentTopic)
    {
        this.parentTopic=parentTopic;
    }
    public int getParentTopic()
    {
        return this.parentTopic;
    }
    public void setRequierOther(int requierOther)
    {
        this.requierOther=requierOther;
    }
    public int getRequierOther()
    {
        return this.requierOther;
    }
	public List<Map> getColumnsList() {
		return columnsList;
	}
	public void setColumnsList(List<Map> columnsList) {
		this.columnsList = columnsList;
	}
}