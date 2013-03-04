/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.AppColumns;
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
        String SQL = "select * from Columns where ColumnId =?";
        Columns columns = jdbcColumnObject.queryForObject(SQL,new ColumnsRowMapper(),id);    
        return columns;
    }

    @Override
    public List<Columns> getAll() 
    {
        String SQL = "select * from Columns order by ColumnId";
        List <Columns> columns = jdbcColumnObject.query(SQL, new ColumnsRowMapper());
        return columns;
    }

    public List<AppColumns> getAllByTemplate(int templateId) 
    {
        String SQL = "select typ.Name typeName, c.ColumnId, c.topicId, c.name, c.typeId,c.Required "
                + "from Columns c join topic t on t.topicId=c.topicId "
                +" join types typ on typ.TypeId=c.TypeId"
                + " where t.templateId=? "
                + " and c.Required=1 "
                + "order by c.ColumnId";
        List <AppColumns> columns = jdbcColumnObject.query(SQL, new AppColumnsRowMapper(),templateId);
        return columns;
    }
    @Override
    public int add(int topicId, String name, int typeId, int required) 
    {
        int i=getCurVal();
        String SQL ="INSERT INTO Columns VALUES(?,?,?,?,?)";
        jdbcColumnObject.update(SQL,i,topicId,name,typeId,required);
        return i;
    }
    
    @Override
    public List<ColumnsShow> getColumnsShow(int id)
    {
        String SQL = "select c.ColumnId, c.topicId, c.Name, "+
                "Decode(t.Name, 'string','Максимальная длина строки '||t.Description||' символов','integer',regexp_replace(t.Description,'(\\d+)(,)(\\d+)','Диапазон: от \\1 до \\3'),'Возможны значения :'||t.Description)  as TypeName ,"+
                "t.TypeId, c.Required, top.Name as TopicName from Columns c join Types t "+
                "on t.TypeId=c.TypeId join Topic top on top.TopicId=c.TopicId where top.TopicId=?  order by ColumnId ";
        List<ColumnsShow> columnsShow = jdbcColumnObject.query(SQL, new ColumnsShowRowMapper(),id);
        return columnsShow;
    }
     public void delete(int columnId)
     {
         String SQL = "delete from Columns where columnId = ?";
       jdbcColumnObject.update(SQL, columnId);
     }
     
     public void update(int id, int topicId,String name, int typeId, int require) 
    {
        String SQL = "update Columns set topicId=?, name =?, typeId=?, required =? where ColumnId =?";
       jdbcColumnObject.update(SQL,topicId,name,typeId,require,id);
    }
    
     public int existColumn(int id)
    {
        String sql = "select Count(*) from Columns where columnId=?";
        return jdbcColumnObject.queryForInt(sql,id);
    }
     public List<InfoForDelete> getInfoForDelete(int[] columns)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from columnFields cf join columns c on cf.columnId=c.columnId "+
					"join appForm  af on af.appId=cf.appId "+
					"join users u on u.userId=af.userId "+
                                        "where ";
         for(int i=0;i<columns.length-1;i++)
                {
                                       sql+= " c.columnId="+columns[i]+" or";
                }
                 sql+= " c.columnId="+columns[columns.length-1];
                                       sql+= " order by af.appId";
        List<InfoForDelete> listOfInfo=jdbcColumnObject.query(sql, new InfoForDeleteRowMapper());
        return listOfInfo;
    }
     private int getCurColumnField()
    {
        String sqlSeq = "select ColumnFields_seq.NEXTVAL as Id from dual";
        return jdbcColumnObject.queryForInt(sqlSeq);
    }
     public int  addColumnField(int columnId,int userId,String value,int status)
     {
         int i=getCurColumnField();
         String sql="INSERT INTO ColumnFields VALUES (?,"+
		"?,"+
		"(select appId from appForm where UserId=?), "+
		"?,"+
		"?)";
                    jdbcColumnObject.update(sql,i,columnId,userId,value,status);   
         return 1;
     }
}
