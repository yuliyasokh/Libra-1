/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import javax.sql.DataSource;

/**
 *
 * @author Sashenka
 */
public interface InterviewResultsDAO 
{
    public void setDataSource(DataSource dataSource);
    public void addResult(int interviewId,int UserId,int mark, String comments);
    public void updateResult(int appId,int UserId,int mark, String comments);
}
