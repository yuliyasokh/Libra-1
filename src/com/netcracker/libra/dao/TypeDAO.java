/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Type;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Sashenka
 */
public interface TypeDAO 
{
    public void setDataSource(DataSource dataSource);
    public Type getType(int id);
    public int add(String name,String descroption);
    public List<Type> getAll();
    public void update(int id,String description);
    public void delete(int id);
}
