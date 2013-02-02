package com.netcracker.libra.dao;

import com.netcracker.libra.model.SignupForm;
import com.netcracker.libra.model.Student;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HrJDBC implements HrDAO {

       private static JdbcTemplate jdbcTemplateObject;

	@Override
	public void create(String name, String lastName, String email,
			String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer id, String name, String lastName, String email,
			String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		
	}
        
        @Override
        public void deleteFormById(Integer id){
           String SQL = "delete from AppForm where appid = ?)";
           jdbcTemplateObject.update(SQL, id);
           System.out.println("Deleted form with ID = " + id );
        }
        
        @Override
        public void updateStudent(SignupForm form){
          
        }
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
            jdbcTemplateObject = new JdbcTemplate(dataSource);

		
	}

}
