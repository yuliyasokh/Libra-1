package com.netcracker.libra.dao;

import com.netcracker.libra.model.User;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexander Lebed
 */
@Repository
public class AdminJDBC implements AdminDAO {
    
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
		// TODO Auto-generated method stub
		
	}

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
            jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
        
        /*
         * @return customers все служащие (HR, tech и т.д.)
         */
        public List <User> getAllEmployees() {
            String SQL = "SELECT * FROM Users WHERE RoleId > 1";
            List <User> customers = jdbcTemplateObject.query(SQL, new UserRowMapper());
            System.out.println(customers);
            return customers;
        }
        
        public User getEmployee(Integer employeeId) {
            String SQL = "SELECT * FROM Users WHERE UserId = ?";
            User employee = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{employeeId}, new UserRowMapper());
            return employee;
        }
        
        //Чтобы изменить значение в Users необходимо сначала изменить значения во всех его потомков(FK)?
        public void updateEmployee(Integer employeeId, String firstName, String lastName, 
                                        String email, String password, Integer roleId) {
            String SQL = "UPDATE Users SET firstName = ?, lastName = ?,"+
                         "email = ?, password = ?, roleId = ? WHERE userId = ?";
            jdbcTemplateObject.update(SQL, firstName, lastName, email, password, roleId, employeeId);
        }
        
        public void deleteEmployee(Integer employeeId) {
            String SQL = "";
        }
        

}