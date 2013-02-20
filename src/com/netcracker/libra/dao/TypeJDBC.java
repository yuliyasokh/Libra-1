/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.InfoForDelete;
import com.netcracker.libra.model.Type;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sashenka
 */

@Repository
public class TypeJDBC implements TypeDAO
{
    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    private int getCurVal()
    {        
        String sqlSeq = "select Types_seq.NEXTVAL as Id from dual";
        return jdbcTemplateObject.queryForInt(sqlSeq);
    }
    
    public int existType(int id)
    {
        String sql = "select Count(*) from types where TypeId=?";
        return jdbcTemplateObject.queryForInt(sql,id);
    }
    @Override
    public Type getType(int id) 
    {
        String SQL = "select * from Types where TypeId =?";
        Type type = jdbcTemplateObject.queryForObject(SQL, new TypeRowMapper(),id);    
        return type; 
    }

    @Override
    public List<Type> getAll() 
    {
          String SQL = "select * from Types order by typeId";
        List <Type> types = jdbcTemplateObject.query(SQL, new TypeRowMapper());
        return types;
    }
    public List<Type> getAllInfo() 
    {
          String SQL ="select TypeId, Name, "+
                  "Decode(Name, 'string',Description,'integer',regexp_replace(Description,'(\\d+)(.)(\\d+)','от \\1 до \\3'),Description)  as Description "+
                  "from Types order by typeId";
                  
                  List <Type> types = jdbcTemplateObject.query(SQL, new TypeRowMapper());
        return types;
    }
    public int add(String name,String description)
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Types VALUES(?,?,?)";
        jdbcTemplateObject.update(SQL,i,name,description);
        return i;
    }
    @Override
    public void update(int id,String description) 
    {
        String SQL = "update Types set Description=?  where TypeId = ?";
       jdbcTemplateObject.update(SQL, description, id);
    }

    @Override
    public void delete(int id) 
    {
        String SQL = "Delete from Types where TypeId = ?";
       jdbcTemplateObject.update(SQL, id);
    }
    
    public List<InfoForDelete> getInfoForDelete(int[] type)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from columnFields cf join columns c on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "join types on types.TypeId=c.TypeId where ";
                                        
                for(int i=0;i<type.length-1;i++)
                {
                                       sql+= " types.TypeId="+type[i]+" or";
                }
                 sql+= " types.TypeId="+type[type.length-1];
                 sql+= " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcTemplateObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
}
