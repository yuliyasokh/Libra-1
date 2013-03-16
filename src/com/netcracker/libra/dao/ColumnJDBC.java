/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.AppFormColumns;
import com.netcracker.libra.model.Column;
import com.netcracker.libra.model.ColumnForEdit;
import com.netcracker.libra.model.ColumnInfo;
import com.netcracker.libra.model.ColumnLevel;
import com.netcracker.libra.model.InfoForDelete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sashenka
 */
@Repository
public class ColumnJDBC 
{
    private static JdbcTemplate jdbcColumnObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcColumnObject = new JdbcTemplate(dataSource);
    }
    
    private int getCurVal()
    {
        String sqlSeq = "select NewColumns_seq.NEXTVAL as Id from dual";
        return jdbcColumnObject.queryForInt(sqlSeq);
    }
    
    public List<ColumnInfo> getColumnsInfo(int templateId) 
    {
        String SQL = "select  c.ColumnId,  c.Name, NVL(c.TypeId,0) TypeId, NVL(c.ParentColumn,0) ParentColumn,  "
                +"Decode(t.Name, 'textstring','Однострочное текстовое поле с максимальной длиной '||t.Description||' символов',"
                +" 'areastring','Многострочный текст с максимальной длиной '||t.Description||' символов',"
                + "'integer',regexp_replace(t.Description,'(\\d+)(;)(\\d+)','Число в диапазоне: от \\1 до \\3'),"
                + " 'radioenum','Переключатели со значениями :'||t.Description,"
                + " 'checkboxenum','Флажки со значениями :'||t.Description,"
                + " 'selectenum','Выпадающий список со значениями :'||t.Description) as typeDescription,"
                + " level "
                + " from NewColumns c  "
                + " left join types t on t.typeId=c.typeId"
                + " where c.templateId=? "
                +"START WITH  c.parentColumn is null " 		    
		+"CONNECT BY  prior  c.columnId =  c.ParentColumn "
                +"order siblings by c.OrderId ASC ";
        List<ColumnInfo> list = jdbcColumnObject.query(SQL,new ColumnInfoRowMapper(),templateId); 
        int plevel=0;
        int maxLevel=1000;
    int[] mas=new int[maxLevel];

    for(ColumnInfo item: list)
    {
            if (item.getLevel()>plevel)
            {	
                    mas[plevel]=1;
                    plevel++;
            }
            else if (item.getLevel()<plevel)
            {
                    while (item.getLevel()<plevel)
                    {
                            plevel--;
                            mas[plevel]++;
                    }
                    mas[plevel-1]++;
            }
            else
            {
                mas[plevel-1]++;
            }
            String s=String.valueOf(mas[0]);

            for (int i=1;i<item.getLevel();i++)
                    s=s+"."+mas[i];
            item.setNumbers(s);
    }
        return list;
    }
    public List<Column> getColumns(int templateId)
    {
        String SQL="select  c.columnId, c.name, c.parentColumn "
                    +" from newColumns c "
                    +"where  c.templateId=?  "
                    +"START WITH  c.parentColumn is null "		    
		    +"CONNECT BY  prior  c.columnId =  c.ParentColumn "
                    +"order siblings by c.OrderId ASC ";
        List<Column> appList=jdbcColumnObject.query(SQL, new ColumnRowMapper(),templateId);
        return appList;
    }
        
    public ColumnForEdit getColumnInfo(int columnId) 
    {
        String SQL = "select c.ColumnId, c.Name, NVL(c.TypeId,0) TypeId, NVL(c.ParentColumn,0) ParentColumn  "
                + " from NewColumns c  "
                + " where c.columnId=? ";
        ColumnForEdit column = jdbcColumnObject.queryForObject(SQL,new ColumnForEditRowMapper(),columnId);    
        return column;
    } 

    public int add(int templateId, String name, int typeId, int parentColumn) 
    {
        int i=getCurVal();
        String parent;
        String type;
        if(parentColumn==0)
        {
            parent="NULL";
        }
        else
        {
            parent=Integer.toString(parentColumn);
        }
        if(typeId==0)
        {
            type="NULL";
        }
        else
        {
            type=Integer.toString(typeId);
        }
            String SQL ="INSERT INTO NewColumns VALUES(?,?,?,"+type+","+parent+",?)";
            jdbcColumnObject.update(SQL,i,templateId,name,i);
        return i;
    }
    public void update(String name, int typeId, int parentColumn,int columnId) 
    {
        String parent;
        String type;
        if(parentColumn==0)
        {
            parent="NULL";
        }
        else
        {
            parent=Integer.toString(parentColumn);
        }
        if(typeId==0)
        {
            type="NULL";
        }
        else
        {
            type=Integer.toString(typeId);
        }
        String SQL ="UPDATE NewColumns SET name=?, TypeId ="+type+", ParentColumn="+parent+" where ColumnId =?";
        jdbcColumnObject.update(SQL,name,columnId);

    }
    
     public List<InfoForDelete> getInfoForDelete(int[] columns)
    {
        String sql = "select distinct u.userId, u.firstname, u. lastname, af.patronymic, af.appId "+
                      "from columnFields cf join NewColumns c on cf.columnId=c.columnId "+
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
     
    public void delete(int columnId)
    {
        String SQL = "delete from NewColumns where columnId = ?";
        jdbcColumnObject.update(SQL, columnId);
    }
    
    public List<AppFormColumns> getAppFormColumns(int id)
    {

        String SQL="select  c.columnId, c.name,  NVL(t.name,'show') typeName, NVL(t.DESCRIPTION,'show') DESCRIPTION, level " 
                    +"from newColumns c "
                    +" left join types t on t.typeId=c.typeId "
                    +"where  c.templateId=? " 
                    +"START WITH  c.parentColumn is null " 		    
		    +"CONNECT BY  prior  c.columnId =  c.ParentColumn "
                    +"order siblings by c.OrderId ASC ";
        List<AppFormColumns> appList=jdbcColumnObject.query(SQL, new AppFormColumnsRowMapper(),id);
        return appList;
    }
 
    public void swop(int columnId1,int columnId2)
    {
        /*
         UPDATE t1 SET t1.orderId=t2.orderId 
FROM newColumns t1 
inner JOIN newColumns t2 ON t1.ColumnParent=t2.ColumnParent 
WHERE (t1.columnId=1 and t2.ColumnId=14) OR (t2.columnId=14 and t1.ColumnId=1);
         */
        String SQL="MERGE INTO newColumns t1"
        +" USING newColumns t2"
        +" ON (((t1.ParentColumn=t2.ParentColumn)"
        + " or(t1.ParentColumn is null) or(t2.ParentColumn is null)) AND (t1.columnid<>t2.columnid))"
        +" WHEN MATCHED THEN UPDATE"
	+" SET t1.orderid=t2.orderid"
	+" WHERE ((t1.columnid=? AND t2.columnid=?) OR (t1.columnid=? AND t2.columnid=?))";
        jdbcColumnObject.update(SQL, columnId1,columnId2,columnId2,columnId1);
    }
    
   /* public List<Column> getBrothers(int columnId,int parentId)
    {
        String SQL="select  c.columnId, c.name, c.parentColumn "
                    +" from newColumns c "
                    +"where  c.ColumnId!=?  "
                    +"and c.parentColumn=? ";
        List<Column> c=jdbcColumnObject.query(SQL, new ColumnRowMapper(), columnId, parentId);
        return c;
    }*/
    
}
