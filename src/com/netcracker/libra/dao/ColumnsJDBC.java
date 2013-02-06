/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.Columns;
import com.netcracker.libra.model.ColumnsShow;
import com.netcracker.libra.model.InfoForDelete;
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
public class ColumnsJDBC implements ColumnsDAO
{

    private static JdbcTemplate jdbcColumnObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcColumnObject = new JdbcTemplate(dataSource);
    }
    private int getCurVal()
    {
        String sqlSeq = "select Columns_seq.NEXTVAL as Id from dual";
        return jdbcColumnObject.queryForInt(sqlSeq);
    }
    @Override
    public Columns getColumn(int id) 
    {
        String SQL = "select * from Columns where ColumnId ="+id;
        Columns columns = jdbcColumnObject.queryForObject(SQL, new ColumnsRowMapper());    
        return columns;
    }

    @Override
    public List<Columns> getAll() 
    {
        String SQL = "select * from Columns order by ColumnId";
        List <Columns> columns = jdbcColumnObject.query(SQL, new ColumnsRowMapper());
        return columns;
    }

    @Override
    public int add(int topicId, String name, int typeId, int required) 
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Columns VALUES("+i+","+
                topicId+","+
		"'"+name+"',"+
                typeId+","+
		required+")";
        jdbcColumnObject.update(SQL);
        return i;
    }
    
    public List<ColumnsShow> getColumnsShow()
    {
        String SQL = "select c.ColumnId, c.topicId, c.Name, t.TypeId, c.Required, top.Name as TopicName, t.Name as TypeName from Columns c join Types t on t.TypeId=c.TypeId join Topic top on top.TopicId=c.TopicId"+" order by ColumnId";
        List<ColumnsShow> columnsShow = jdbcColumnObject.query(SQL, new ColumnsShowRowMapper());
        return columnsShow;
    }
     public void delete(int columnId)
     {
         String SQL = "delete from Columns where columnId = ?";
       jdbcColumnObject.update(SQL, columnId);
     }
     
     public void update(int id, int topicId,String name, int typeId, int require) 
    {
        String SQL = "update Columns set topicId="+topicId+", name ='"+name+"', typeId="+typeId+", required ="+require+" where ColumnId ="+id;
       jdbcColumnObject.update(SQL);
    }
    
     public int existColumn(int id)
    {
        String sql = "select Count(*) from Columns where columnId="+id;
        return jdbcColumnObject.queryForInt(sql);
    }
     public List<InfoForDelete> getInfoForDelete(int columnId)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from columnFields cf join columns c on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "where c.columnId="+columnId+
                                        " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcColumnObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
     

}
