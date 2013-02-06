/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Columns;
import com.netcracker.libra.model.ColumnsShow;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Sashenka
 */
public interface ColumnsDAO 
{
    public void setDataSource(DataSource dataSource);
    public Columns getColumn(int id);
    public List<Columns> getAll();
    public int add(int topicId, String name, int typeId,int required);
    public void delete(int columnId);
    public List<ColumnsShow> getColumnsShow(int id);
    public void update(int id, int topicId,String name, int typeId, int require);
    public int existColumn(int id);
}
