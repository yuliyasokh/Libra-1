/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Interview;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Sashenka
 */
public interface InterviewDAO 
{
    public void setDataSource(DataSource dataSource);
    public Interview getInterview(int id);
    public List<Interview> getAll();
    public int add(int interviewDateId, int UserId, int status);
    public int getInterviewDateByAppId(int userId);
    public String getRequestInterviewDate(int userId);
}
