package com.netcracker.libra.dao;

import com.netcracker.libra.model.User;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Класс служит для ввода, вывода служащих (HR, Tech, Admin),
 * редактирования и удаления информации о них
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
        
        /**
         * Возвращает служащего по его ID
         */
        public User getEmployee(Integer employeeId) {
            String SQL = "SELECT * FROM Users WHERE UserId = ?";
            User employee = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{employeeId}, new UserRowMapper());
            return employee;
        }
        
        /**
         * Возвращает список всех служащих
         */
        public List <User> getAllEmployees() {
            String SQL = "SELECT * FROM Users WHERE RoleId > 1";
            List <User> customers = jdbcTemplateObject.query(SQL, new UserRowMapper());
            return customers;
        }
        
        /**
         * Заменяет информащию о служащем по его ID
         */
        public void updateEmployee(Integer employeeId, String firstName, String lastName, 
                                        String email, String password, Integer roleId) {
            String SQL = "UPDATE Users SET firstName = ?, lastName = ?,"+
                         "email = ?, password = ?, roleId = ? WHERE userId = ?";
            jdbcTemplateObject.update(SQL, firstName, lastName, email, password, roleId, employeeId);
        }
        
        /**
         * Добавляет служащего в таблицу Users
         */
        public void addEmployee(String firstName, String lastName,
                            String email, String password, Integer roleId) {
            String SQL = "INSERT INTO Users VALUES(User_seq.NEXTVAL,?,?,?,?,?)";
            jdbcTemplateObject.update(SQL, firstName, lastName, email, password, roleId);
        }
        
        /**
         * Удаляет служащего по его ID во всех таблицах с ним
         */
        public void deleteEmployee(Integer employeeId) {
            String SQL1 = "DELETE FROM InterviewerList WHERE UserId = ?";
            String SQL2 = "DELETE FROM InterviewResults WHERE UserId = ?";
            String SQL3 = "UPDATE AppForm SET ModifiedBy = null WHERE ModifiedBy = ?";
            String SQL4 = "DELETE FROM Users WHERE UserId = ?";
            jdbcTemplateObject.update(SQL1, employeeId);
            jdbcTemplateObject.update(SQL2, employeeId);
            jdbcTemplateObject.update(SQL3, employeeId);
            jdbcTemplateObject.update(SQL4, employeeId);
        }
        
        /**
         * Удаляет служащего по его ID из таблицы InterviewerList
         */
        public void deleteEmployeeFromInterviewerList(Integer employeeId) {
            String SQL1 = "DELETE FROM InterviewerList WHERE UserId = ?";
            jdbcTemplateObject.update(SQL1, employeeId);
        }
        
        /**
         * Удаляет служащего по его ID из таблицы InterviewResults
         */
        public void deleteEmployeeFromInterviewResults(Integer employeeId) {
            String SQL2 = "DELETE FROM InterviewResults WHERE UserId = ?";
            jdbcTemplateObject.update(SQL2, employeeId);
        }
        
        /**
         * Удаляет служащего по его ID из таблицы AppForm
         */
        public void deleteEmployeeFromAppForm(Integer employeeId) {
            String SQL3 = "UPDATE AppForm SET ModifiedBy = null WHERE ModifiedBy = ?";
            jdbcTemplateObject.update(SQL3, employeeId);
        }
        
         /**
         * Удаляет служащего по его ID из таблицы Users
         */
        public void deleteEmployeeFromUsers(Integer employeeId) {
            String SQL4 = "DELETE FROM Users WHERE UserId = ?";
            jdbcTemplateObject.update(SQL4, employeeId);
        }

}