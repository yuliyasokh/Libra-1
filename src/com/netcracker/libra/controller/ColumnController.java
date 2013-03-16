/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.controller;

import com.netcracker.libra.dao.ColumnJDBC;
import com.netcracker.libra.dao.ColumnsJDBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.netcracker.libra.dao.TypeJDBC;
import com.netcracker.libra.dao.UserPreferences;
import com.netcracker.libra.model.AppFormColumns;
import com.netcracker.libra.model.ColumnFieldsModel;
import com.netcracker.libra.model.InfoForDelete;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author Sashenka
 */
@Controller
public class ColumnController
{
    
    @RequestMapping(value="index2")
    public String index(ModelMap model)  
    {
        return "index2";
    }
    TypeJDBC typeJDBC=new TypeJDBC();
    ColumnJDBC columnJDBC=new ColumnJDBC();
    @Autowired
    UserPreferences userPreferences;
    int templateId;
    @RequestMapping(value="showColumn",method = RequestMethod.GET)
    public String showColumns(ModelMap model,
    @RequestParam int templateId)  
    {
        this.templateId=templateId;
        model.addAttribute("types", typeJDBC.getAllInfo());
        model.addAttribute("templateId", templateId);    
        model.addAttribute("columns", columnJDBC.getColumnsInfo(templateId));
        return "ShowNewColumnsView";
    }
    
    @RequestMapping(value="changeOrder",method = RequestMethod.POST)
    public String changeOrder(ModelMap model,
    @RequestParam(required=true,value="column1") int column1,
    @RequestParam(required=true,value="column2") int column2)  
    {
        
        return "redirect:showColumn.html?templateId="+templateId;
    }
    @RequestMapping(value="SubmitColumn",method = RequestMethod.POST)
    public String addColumn(ModelMap model,
    @RequestParam("name") String name,
    @RequestParam("selType") int selType,
    @RequestParam("parentColumn") int parentColumn,
    @RequestParam("templateId") int templateId)  
    {
        columnJDBC.add(templateId, name, selType, parentColumn);
        return "redirect:showColumn.html?templateId="+templateId;
    }
    
    @RequestMapping(value="editColumn",method = RequestMethod.GET)
    public String editColumn(ModelMap model,
    @RequestParam("columnId") int columnId)  
    {
        model.addAttribute("columnId", columnId);
        model.addAttribute("columns", columnJDBC.getColumns(templateId));
        model.addAttribute("types", typeJDBC.getAllInfo());
        model.addAttribute("current",columnJDBC.getColumnInfo(columnId));
        return "editNewColumnView";
    }
    
    @RequestMapping(value="editSubmitColumn",method = RequestMethod.POST)
    public String editSubmitColumn(ModelMap model,
    @RequestParam("name") String name,
    @RequestParam("selType") int selType,
    @RequestParam("parentColumn") int parentColumn,
    @RequestParam("columnId") int columnId)  
    {
        columnJDBC.update(name, selType, parentColumn, columnId);
        return "redirect:showColumn.html?templateId="+templateId;
    }
    
    @RequestMapping(value="delColumns",method = RequestMethod.POST)
    public String delColumns(ModelMap model,
    @RequestParam("delete[]") int[] delete)  
    {
        List<InfoForDelete> info=columnJDBC.getInfoForDelete(delete);
        int infoSize=info.size();
        model.addAttribute("delete", delete);
        model.addAttribute("info", info);
        model.addAttribute("infoSize",infoSize);
        model.addAttribute("title","Удалить колонки");
        model.addAttribute("h1","Вы действительно хотите удалить эти колонки?");
        model.addAttribute("submit","delSubmitColumns");
        model.addAttribute("location","addColumn.html?templateId="+templateId);
        return "delInfoView";
    }
    
    @RequestMapping(value="delSubmitColumns",method = RequestMethod.POST)
    public String delSubmiteColumns(ModelMap model,
    @RequestParam("delete[]") int[] delete)  
    {
        for(int i=0;i<delete.length;i++)
        {
            columnJDBC.delete(delete[i]);
        }
        return "redirect:showColumn.html?templateId="+templateId;
    }
    
    @RequestMapping(value="showAppForm",method = RequestMethod.GET)
    public String showAppForm(ModelMap model,
    @RequestParam("templateId") int templateId)  
    {
        ColumnFieldsModel columnFields = new ColumnFieldsModel();
        List<AppFormColumns> appList=columnJDBC.getAppFormColumns(templateId);
        model.addAttribute("columns", appList);
        model.addAttribute("columnFields", columnFields);
        return "appFormView";
    }
    
    //submitForm
         ColumnsJDBC columnsJDBS=new ColumnsJDBC();
    @RequestMapping(value="submitForm",method = RequestMethod.POST)
    public String submitForm(ModelMap model,
    @ModelAttribute("columnFields") ColumnFieldsModel columnFields)  
    {
        Map<Integer,String> map=columnFields.getMap();   
        
        Set s=map.entrySet();
        // Move next key and value of HashMap by iterator
        Iterator it=s.iterator();
        while(it.hasNext())
        {
            // key=value separator this by Map.Entry to get key and value
            Map.Entry m =(Map.Entry)it.next();
            // getKey is used to get key of HashMap
            int key=(Integer)m.getKey();
            // getValue is used to get value of key in HashMap
            String value=(String)m.getValue();
            if(!value.equalsIgnoreCase(""))
            {
                columnsJDBS.addColumnField(key, userPreferences.UserId, value, 1);
            }
        }
        return "appFormView";
    }
    
    @RequestMapping(value="changeColumn",method = RequestMethod.POST)
    public String ChangeColumn(ModelMap model,
    @RequestParam("column1") int column1,
    @RequestParam("column2") int column2)  
    {
        columnJDBC.swop(column1, column2);
        //model.addAttribute("columns", columnJDBC.getBrothers(column,parentColumn));
          return "redirect:showColumn.html?templateId="+templateId;
   }
}
