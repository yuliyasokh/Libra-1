/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;


import com.netcracker.libra.model.InfoForDelete;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.netcracker.libra.model.Template;
import com.netcracker.libra.model.Topic;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Sashenka
 */
@Repository
public class TemplateJDBC implements TemplateDAO
{
    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    /**
     * Gets template by id
     * @param id the number of template
     * @return Template
     */
    public Template getTemplate(int id) 
    {
      String SQL = "select * from Template where TemplateId =?";
      //Template template = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new TemplateRowMapper());
      Template template = jdbcTemplateObject.queryForObject(SQL, new TemplateRowMapper(),id);    
      return template;
   }
    /**
    * Retrieves all persons
    * 
    * @return a list of persons
    */
    public List<Template> getAll() 
    {
        String SQL = "select * from Template order by TemplateId";
        List <Template> templates = jdbcTemplateObject.query(SQL, new TemplateRowMapper());
        return templates;
    }
    
    private int getCurVal()
    {
        String sqlSeq = "select Template_seq.NEXTVAL as Id from dual";
        return jdbcTemplateObject.queryForInt(sqlSeq);
    }
    /**
     * Adds a new template
     * @param name the name of tamplate
     */
    public int add(String name) 
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Template VALUES(?,?,0)";
        jdbcTemplateObject.update(SQL,i,name);
        return i;
    }
    
    /**
     * Delete Template by id
     * 
     * @param id id of temaplate, which we wand delete
     */
    public void delete(int id)
    {
       String SQL = "delete from Template where templateId = ?";
       jdbcTemplateObject.update(SQL, id);
    }

    /**
     * Update Template
     * 
     * @param oldid old id of temaplate
     * @param newid new id of template
     * @param name new name of tamplate
     */
    public void update(int id, String name) 
    {
            String SQL = "update Template set name = ? where TemplateId = ?";
            jdbcTemplateObject.update(SQL, name, id);
    }
    
    public Template getActive() 
    {
      String SQL = "select * from Template where Active = 1";
      //Template template = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new TemplateRowMapper());
      Template template = jdbcTemplateObject.queryForObject(SQL, new TemplateRowMapper());    
      return template;
   }
    
    public void setActive(int id)
    {
        String SQL1="update Template set active=0";
        jdbcTemplateObject.update(SQL1);
        String SQL2="update Template set active=1 where TemplateId=?";
        jdbcTemplateObject.update(SQL2,id);   
    }
    
    public int existTemplate(int id)
    {
        String sql = "select Count(*) from template where TemplateId=?";
        return jdbcTemplateObject.queryForInt(sql,id);
    }
    
    public List<InfoForDelete> getInfoForDelete(int[] templates)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from template temp join topic top on temp.templateId=top.templateId "+
					"join columns c on c.topicId=top.topicId "+
					"join columnFields cf on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "where ";
        for(int i=0;i<templates.length-1;i++)
                {
                                       sql+= " temp.templateId="+templates[i]+" or";
                }
                 sql+= " temp.templateId="+templates[templates.length-1];
                                       sql+= " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcTemplateObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
}
