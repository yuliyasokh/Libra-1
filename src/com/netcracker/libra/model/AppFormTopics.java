/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.model;

/**
 *
 * @author Sashenka
 */
public class AppFormTopics 
{
    private int topicId;
    private String topicName;
    private int parentTopic;
    private int level;
    private int requireOther;

    public int getRequireOther() 
    {
        return requireOther;
    }

    public void setRequireOther(int requireOther) 
    {
        this.requireOther = requireOther;
    }
    
    public int getLevel() 
    {
        return level;
    }

    public int getParentTopic() 
    {
        return parentTopic;
    }

    public int getTopicId() 
    {
        return topicId;
    }

    public String getTopicName() 
    {
        return topicName;
    }

    public void setLevel(int level) 
    {
        this.level = level;
    }

    public void setParentTopic(int parentTopic) 
    {
        this.parentTopic = parentTopic;
    }

    public void setTopicId(int topicId) 
    {
        this.topicId = topicId;
    }

    public void setTopicName(String topicName) 
    {
        this.topicName = topicName;
    }   
}
