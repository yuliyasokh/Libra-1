package com.netcracker.libra.dao;

import com.netcracker.libra.model.Student;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Yuliya
 */
@Repository
public class HrJDBC implements HrDAO {

      private static JdbcTemplate jdbcTemplateObject;
      

       
      public List<Student> listStudents() {
      String SQL = "select a.appid, u.firstname,u.lastname,u.email from Users u join appform a on u.userid=a.userid and roleid=1";
      List <Student> students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
      return students;
    }

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
        }
        
        public void updateStudent(Student student){
      /*     String SQL = "update Appform set Patronymic = ?, PhoneNumber = ?, DepartmentId = ?, AdvertisingId = ?, AdvertisingComment = ?,"
                   + " Course = ?, Graduated = ?, DataCreation = ?, ModifiedBy = ? "
                   + "where appid = ?";
           jdbcTemplateObject.update(SQL, form.getPatronymic(), form.getPhoneNumber(), form.getDepartment(),
                   form.getAdvert(),form.getAdvertComment(),form.getCourse(),form.getGraduated(),form.getModifieldBy(),
                   form.getAppId());
           String SQLJava = "update AppLanguages set mark = ?, status=1  where LanguageId=1 and appId=?";
           jdbcTemplateObject.update(SQLJava,form.getJavaKnowledge(),form.getAppId());
           String SQLCpp = "update AppLanguages set mark = ?, status=1  where LanguageId=2 and appId=?";
           jdbcTemplateObject.update(SQLCpp,form.getCKnowledge(),form.getAppId());
           String SQLAnotherLang1 = "update AppLanguages set mark = ?, status=1 where appId=? and AppLanguageId=("
                   + "select min(AppLanguageId) from applanguages where appid=? and LanguageId>2) ";
           jdbcTemplateObject.update(SQLAnotherLang1,form.getAnotherLang(),form.getAppId(),form.getAppId(),form.getAppId());
           String SQLAnotherLang2 = "update AppLanguages set mark = ?, status=1 where appId=? and AppLanguageId=("
                   + "select round(avg(AppLanguageId)) from applanguages where appid=? and LanguageId>2) ";
           jdbcTemplateObject.update(SQLAnotherLang2,form.getAnotherLang2(),form.getAppId(),form.getAppId(),form.getAppId());
           String SQLAnotherLang3 = "update AppLanguages set mark = ?, status=1 where appId=? and AppLanguageId=("
                   + "select max(AppLanguageId) from applanguages where appid=? and LanguageId>2) ";
           jdbcTemplateObject.update(SQLAnotherLang3,form.getAnotherLang3(),form.getAppId(),form.getAppId(),form.getAppId());
           String SQLemail2 = "update ColumnFields set Value=? where columnid=1 and appid=?";
           jdbcTemplateObject.update(SQLemail2,form.getEmail2(),form.getAppId());
         
*/
        }
        
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
            jdbcTemplateObject = new JdbcTemplate(dataSource);
	
	}

    public List<Student> getStudent(Integer id) {
    String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u join appform a on u.userid=a.userid and a.appid=?";
    List <Student> students = jdbcTemplateObject.query(SQL, 
                        new Object[]{id}, new ShortStudentRowMapper());
      return students;
   }

    @Override
    public List<Student> getStudentsByLastName(String lname) {
    String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u join appform a on u.userid=a.userid and u.lastname like '"+lname+"%'";
    List <Student> students;
        students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
    return students;
    }

    @Override
    public List<Student> getStudentsByFirstName(String fname) {
    String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u join appform a on u.userid=a.userid and u.firstname like '"+fname+"%'";
    List <Student> students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
    return students;    
    }

    @Override
    public List<Student> getStudentsByEmail(String mail) {
    String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u join appform a on u.userid=a.userid and u.email like '"+mail+"%'";
    List <Student> students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
    return students;
    }

}
