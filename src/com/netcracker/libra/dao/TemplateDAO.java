/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import java.util.List;
import javax.sql.DataSource;
import com.netcracker.libra.model.Template;

/**
 *
 * @author Sashenka
 */
public interface TemplateDAO 
{
    public void setDataSource(DataSource dataSource);
    public Template getTemplate(int id);
    public List<Template> getAll();
    public int add(String name);
    public void delete(int id);
    public void update(int id, String name);
}
