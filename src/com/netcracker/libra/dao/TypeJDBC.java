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
        String sql = "select Count(*) from types where TypeId="+id;
        return jdbcTemplateObject.queryForInt(sql);
    }
    @Override
    public Type getType(int id) 
    {
        String SQL = "select * from Types where TypeId ="+id;
        Type type = jdbcTemplateObject.queryForObject(SQL, new TypeRowMapper());    
        return type; 
    }

    @Override
    public List<Type> getAll() 
    {
          String SQL = "select * from Types order by typeId";
        List <Type> types = jdbcTemplateObject.query(SQL, new TypeRowMapper());
        return types;
    }
    
    public int add(String name)
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Types VALUES("+i+","+
		"'"+name+"')";
        jdbcTemplateObject.update(SQL);
        return i;
    }
    @Override
    public void update(int id, String name) 
    {
        String SQL = "update Types set name = ? where TypeId = ?";
       jdbcTemplateObject.update(SQL, name, id);
    }

    @Override
    public void delete(int id) 
    {
        String SQL = "Delete from Types where TypeId = ?";
       jdbcTemplateObject.update(SQL, id);
    }
    
    public List<InfoForDelete> getInfoForDelete(int type)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from columnFields cf join columns c on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "join types on types.TypeId=c.TypeId "+
                                        "where types.TypeId="+type+
                                        " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcTemplateObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
}
