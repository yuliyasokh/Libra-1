package com.netcracker.libra.dao;

import com.netcracker.libra.model.User;
import java.sql.Types;
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
            String SQL = "SELECT * FROM Users WHERE RoleId > 1 ORDER BY RoleId";
            List <User> employees = jdbcTemplateObject.query(SQL, new UserRowMapper());
            return employees;
        }
        
        /**
         * @param role - должность (2 - HR, 3 - Tech, 4 - Admin)
         * @return список служащих, у которых должность совпадает со значением role
         */
        public List <User> getAllEmployeesByRole(Integer role) {
            String SQL = "SELECT * FROM Users WHERE RoleId = ? ORDER BY firstName";
            List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {role}, new UserRowMapper());
            return employees;
        }
        
        /**
         * @param fullName - полное имя, например "Вася Пупкин"
         * @return список служащих, у которых имя и фамилия совпадает со значениями firstName и lastName;
         * если имя отсутствует - возвращает список всех служащих, отсортированных 
         * в алфавитном порядке по имени (firstName)
         */
        public List <User> getAllEmployeesByFullName(String fullName) {
            
            if(!fullName.isEmpty()) {
                String [] names = fullName.split(" ");
                String firstName = names[0];
                String lastName = names[1];
            
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 AND firstName = ? AND lastName = ?";
                Object [] params = new Object[] {firstName, lastName};
                List <User> employees = jdbcTemplateObject.query(SQL, params, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 ORDER BY firstName";
                List <User> employees = jdbcTemplateObject.query(SQL, new UserRowMapper());
                return employees;
            }
        }
        
        /**
         * @param fullName - полное имя, например "Вася Пупкин"
         * @param role - должность (2 - HR, 3 - Tech, 4 - Admin)
         * @return список служащих, у которых имя, фамилия, должность 
         * совпадает со значениями firstName, lastName и role;
         * если имя отсутствует - возвращает список всех служащих с данной должностью,
         * отсортированных в алфавитном порядке по имени (firstName)
         */
        public List <User> getAllEmployeesByFullNameAndRole(String fullName, Integer role) {
            
            if(!fullName.isEmpty()) {
                String [] names = fullName.split(" ");
                String firstName = names[0];
                String lastName = names[1];
            
                String SQL = "SELECT * FROM Users WHERE firstName = ? AND lastName = ? AND RoleId = ?";
                Object [] params = new Object[] {firstName, lastName, role};
                List <User> employees = jdbcTemplateObject.query(SQL, params, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId = ? ORDER BY firstName";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {role}, new UserRowMapper());
                return employees;
            }
        }

        /**
         * @param firstName - имя
         * @return список служащих, у которых имя совпадает со значением firstName;
         * если имя отсутствует - возвращает список всех служащих, отсортированных 
         * в алфавитном порядке по имени
         */
        public List <User> getAllEmployeesByFirstName(String firstName) {
            
            if(!firstName.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 AND firstName = ?";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {firstName}, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 ORDER BY firstName";
                List <User> employees = jdbcTemplateObject.query(SQL, new UserRowMapper());
                return employees;
            } 
        }
        
        /**
         * @param firstName - имя
         * @param role - должность (2 - HR, 3 - Tech, 4 - Admin)
         * @return список служащих, у которых имя и должность совпадает со значениями firstName и role;
         * если имя отсутствует - возвращает список всех служащих с данной должностью,
         * отсортированных в алфавитном порядке по имени
         */
        public List <User> getAllEmployeesByFirstNameAndRole(String firstName, Integer role) {
            
            if(!firstName.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE firstName = ? AND RoleId = ?";
                Object [] params = new Object[] {firstName, role};
                List <User> employees = jdbcTemplateObject.query(SQL, params, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId = ? ORDER BY firstName";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {role}, new UserRowMapper());
                return employees;
            }
        }
        
        /**
         * @param lastName - фамилия
         * @return список служащих, у которых фамилия совпадает со значением lastName;
         * если фамилия отсутствует - возвращает список всех служащих, отсортированных 
         * в алфавитном порядке по фамилии
         */
        public List <User> getAllEmployeesByLastName(String lastName) {
            
            if(!lastName.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 AND lastName = ?";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {lastName}, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 ORDER BY lastName";
                List <User> employees = jdbcTemplateObject.query(SQL, new UserRowMapper());
                return employees;
            }
        }
        
        /**
         * @param lastName - фамилия
         * @param role - должность (2 - HR, 3 - Tech, 4 - Admin)
         * @return список служащих, у которых фамилия и должность 
         * совпадает со значением lastName и role;
         * если фамилия отсутствует - возвращает список всех служащих с данной должностью,
         * отсортированных в алфавитном порядке по фамилии
         */
        public List <User> getAllEmployeesByLastNameAndRole(String lastName, Integer role) {
            
            if(!lastName.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE lastName = ? AND RoleId = ?";
                Object [] params = new Object[] {lastName, role};
                List <User> employees = jdbcTemplateObject.query(SQL, params, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId = ? ORDER BY lastName";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {role}, new UserRowMapper());
                return employees;
            }
        }
        
        /**
         * @param email - электронная почта
         * @return список служащих, у которых эл.почта совпадает со значением email;
         * если эл.почта отсутствует - возвращает список всех служащих, отсортированных 
         * в алфавитном порядке по эл.почте
         */
        public List <User> getAllEmployeesByEmail(String email) {
            
            if(!email.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 AND email = ?";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {email}, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId > 1 ORDER BY email";
                List <User> employees = jdbcTemplateObject.query(SQL, new UserRowMapper());
                return employees;
            }
        }
        
        /**
         * @param email - электронная почта
         * @param role - должность (2 - HR, 3 - Tech, 4 - Admin)
         * @return список служащих, у которых эл. почта и должность 
         * совпадает со значением email и role;
         * если эл.почта отсутствует - возвращает список всех служащих с данной должностью,
         * отсортированных в алфавитном порядке по эл.почте
         */
        public List <User> getAllEmployeesByEmailAndRole(String email, Integer role) {
            
            if(!email.isEmpty()) {
                String SQL = "SELECT * FROM Users WHERE email = ? AND RoleId = ?";
                Object [] params = new Object[] {email, role};
                List <User> employees = jdbcTemplateObject.query(SQL, params, new UserRowMapper());
                return employees;
            }
            else {
                String SQL = "SELECT * FROM Users WHERE RoleId = ? ORDER BY email";
                List <User> employees = jdbcTemplateObject.query(SQL, new Object[] {role}, new UserRowMapper());
                return employees;
            }
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