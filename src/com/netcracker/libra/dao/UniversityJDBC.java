/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.dao;

import com.netcracker.libra.model.University;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Yuliya
 */
public class UniversityJDBC implements UniversityDAO {

    private static JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            jdbcTemplateObject = new JdbcTemplate(dataSource);	
	}
    
    @Override
    public void addUniversity(String universityName) {
        String query="insert into university values(University_seq.NEXTVAL,?)";
        jdbcTemplateObject.update(query,universityName);
    }

    @Override
    public void deleteUniversity(int universityID) {
        String query="delete from university where universityId=?";
        jdbcTemplateObject.update(query,universityID);   
    }

    @Override
    public void updateUniversity(int universityID, String universityName) {
        String query="update university set universityName=? where universityId=?";
        jdbcTemplateObject.update(query,universityName,universityID);
    }

    @Override
    public List<University> getAllUniversity() {
        String query="select * from university";
        List<University> universities=jdbcTemplateObject.query(query, new UniversityRowMapper());
        return universities;
    }
    
}
