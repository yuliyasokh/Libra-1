/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class TopicShow 
{
    int topicId;
    String name;
    String comments;
    int templateId;
    String templateName;
    String parentTopicName;
    int parentTopic;
    int requierOther;
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
    public void setTemplateName(String templateName)
    {
        this.templateName=templateName;
    }
    public String getTemplateName()
    {
        return this.templateName;
    }
    public void setParentTopicName(String parentTopicName)
    {
        this.parentTopicName=parentTopicName;
    }
    public String getParentTopicName()
    {
        return this.parentTopicName;
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
}
