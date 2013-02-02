/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import java.util.List;
import javax.sql.DataSource;
import javax.sql.DataSource;
import com.netcracker.libra.model.Topic;
/**
 *
 * @author Sashenka
 */
public interface TopicDAO 
{
    public void setDataSource(DataSource dataSource);
    public Topic getTopic(int id);
    public List<Topic> getAllTopics();
    public List<Topic> getAll(int templateId);
    public int addTopic(String name,String comments,int tamplateId,int parentTopic, int requiredOther);
    public void deleteTopic(int id);
    public void updateTopic(int id, String name, String comments, int templateId, int parentTopic, int require); 
    
}