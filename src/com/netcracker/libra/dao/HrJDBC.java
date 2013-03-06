package com.netcracker.libra.dao;

import com.netcracker.libra.model.Department;
import com.netcracker.libra.model.Faculty;
import com.netcracker.libra.model.Interview;
import com.netcracker.libra.model.InterviewDate;
import com.netcracker.libra.model.InterviewResults;
import com.netcracker.libra.model.Student;
import com.netcracker.libra.model.University;
import com.netcracker.libra.model.User;
import com.netcracker.libra.model.UserResult;
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
        String SQL = "select a.appid, u.firstname,u.lastname,u.email from Users u "
                + "join AppForm a on u.userId=a.userId and u.roleid=1";
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
        String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u "
                + "join appform a on u.userid=a.userid and a.appid=?";
        List <Student> students = jdbcTemplateObject.query(SQL, new Object[]{id}, new ShortStudentRowMapper());
        return students;
     }

        @Override
     public List<Student> getStudentsByLastName(String lname) {
        String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u "
                + "join appform a on u.userid=a.userid and lower(u.lastname) like '%"+lname.toLowerCase()+"%'";
        List <Student> students;
        students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
        return students;
     }
        public List<Student> getStudentsByAllFields(String value){
        String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u "
                        + "join appform a on u.userid=a.userid and "
                             + "((a.appid like '"+value+"') or (lower(u.firstname) like '%"+value.toLowerCase()+"%') "
                                + "or (lower(u.lastname) like '%"+value.toLowerCase()+"%') or (lower(u.email) like '%"+value.toLowerCase()+"%'))";
        List <Student> students;
        students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
        return students;
        }

        @Override
     public List<Student> getStudentsByFirstName(String fname) {
         String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u "
                 + "join appform a on u.userid=a.userid and lower(u.firstname) like '%"+fname.toLowerCase()+"%'";
         List <Student> students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
         return students;    
     }

        @Override
     public List<Student> getStudentsByEmail(String mail) {
        String SQL = "select a.appid, u.firstname,u.lastname,u.email from users u "
                + "join appform a on u.userid=a.userid and lower(u.email) like '%"+mail.toLowerCase()+"%'";
        List <Student> students = jdbcTemplateObject.query(SQL, new ShortStudentRowMapper());
        return students;
     }
        
     public List<University> getAllUniversity() {
        String query="select universityId, universityName from university";
        List<University> universities = jdbcTemplateObject.query(query, new UniversityRowMapper());
        return universities;
     }
     
     public List<University> getUniversityByName(String name){
         String query="select universityId, universityName from university where lower(universityName) like '%"+name.toLowerCase()+"%'";
         List<University> universities = jdbcTemplateObject.query(query, new UniversityRowMapper());
         return universities;
     }
     
     public List<University> getUniversityById(int universityId){
         String query="select universityId, universityName from university where universityId=?";
         List<University> universities = jdbcTemplateObject.query(query, new UniversityRowMapper(), universityId);
         return universities;
     }
     
     public List<Faculty> getAllFaculties() {
        String query = "select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId order by f.facultyId";
        List<Faculty> faculties = jdbcTemplateObject.query(query, new FacultyRowMapper() );
        return faculties;
     }
     
     public List<Faculty> getAllFaculties(int univerId) {
        String query="select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId  where f.universityId=?";
        List<Faculty> faculties;
        faculties = jdbcTemplateObject.query(query, new FacultyRowMapper(), univerId);
        return faculties;
     }
     public List<Faculty> getAllFacultiesById(int facultyId) {
        String query="select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId  where f.facultyId=?";
        List<Faculty> faculties;
        faculties = jdbcTemplateObject.query(query, new FacultyRowMapper(), facultyId);
        return faculties;
     
     }
     public List<Faculty> getUnselectedFaculties(int facultyId, int universityId) {
        String query="select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId  "
                            + "where u.universityId=? and f.facultyId not like '"+facultyId+"'";
        List<Faculty> faculties;
        faculties = jdbcTemplateObject.query(query, new FacultyRowMapper(), universityId);
        return faculties;
     }
     
     public List<Faculty> getAllFaculties(String param, String name) {
        String query="select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId  where lower("+param+") like '%"+name.toLowerCase()+"%'";
        List<Faculty> faculties;
        faculties = jdbcTemplateObject.query(query, new FacultyRowMapper());
        return faculties;
     }
    
     public List<Department> gelAllDepartemtns() {
        String query="select d.departmentId, d.departmentName, f.facultyId, f.facultyName, u.universityId, u.universityName from department d "
                        + "join faculty f on d.facultyId=f.facultyId "
                            + "join university u on f.universityId=u.universityId";
        List<Department> departments = jdbcTemplateObject.query(query, new departmentRowMapper());
        return departments;
     }
     
     public List<Department> getAllDepartments(String param, int facultyId) {
        String query="select d.departmentId, d.departmentName, f.facultyId, f.facultyName, u.universityId, u.universityName from department d "
                        + "join faculty f on d.facultyId=f.facultyId "
                            + "join university u on f.universityId=u.universityId where "+param+"=?";
        List<Department> departments = jdbcTemplateObject.query(query,new departmentRowMapper(),facultyId);
        return departments;
    }
     public List<Department> getAllDepartments(String param, String name) {
        String query="select d.departmentId, d.departmentName, f.facultyId, f.facultyName, u.universityId, u.universityName from department d "
                        + "join faculty f on d.facultyId=f.facultyId "
                            + "join university u on f.universityId=u.universityId where lower("+param+") like '%"+name.toLowerCase()+"%'";
        List<Department> departments = jdbcTemplateObject.query(query,new departmentRowMapper());
        return departments;
    }
          
    public List<Student> getStudentByUniversity(int universityId){
        String query="select a.appid, u.firstname,u.lastname,u.email, d.departmentName from users u "+
                        "join appform a on u.userid=a.userid "+
                            "join department d on d.departmentId=a.DepartmentId "+ 
                                "join faculty f on f.facultyid=d.facultyId "+
                                    "join university un on un.universityId=f.universityId and un.universityId=?";
        List <Student> students = jdbcTemplateObject.query(query, new ShortStudentRowMapper(), universityId);
        return students;
    }
    
    public List<Student> getStudentByFaculty(int facultyId){
        String query="select a.appid, u.firstname,u.lastname,u.email from users u "+
                        "join appform a on u.userid=a.userid "+
                            "join department d on d.departmentId=a.DepartmentId  "+
                                "join faculty f on f.facultyid=d.facultyId and f.facultyId=?";
        List <Student> students = jdbcTemplateObject.query(query, new ShortStudentRowMapper(), facultyId);
        return students;
    }
    
    public List<Student> getStudentByDepartment(int departmentId){
        String query="select a.appid, u.firstname,u.lastname,u.email from users u "+ 
                        "join appform a on u.userid=a.userid and a.departmentId=?";
        List <Student> students = jdbcTemplateObject.query(query, new ShortStudentRowMapper(), departmentId);
        return students;
    }
    
    public void addUniversity(String universityName){
        String query="insert into university values(University_seq.NEXTVAL,?)";
        jdbcTemplateObject.update(query,universityName);
    }
    
    public void addFaculty(String facultyName, int univerId) {
        String query="insert into faculty values(Faculty_seq.NEXTVAL,?,?)";
        jdbcTemplateObject.update(query,facultyName,univerId);
    }
    public void addDepartment(String departmentName, int facultyId){
        String query="insert into department values(Department_seq.NEXTVAL,?,?)";
        jdbcTemplateObject.update(query,departmentName,facultyId);
    }
    public void deleteUniversity(int universityID) {
        String query="delete from university where universityId=?";
        jdbcTemplateObject.update(query,universityID);   
    }
    public void deleteFaculty(int facultyId) {
        String query="delete faculty where facultyId=?";
        jdbcTemplateObject.update(query,facultyId);
    }
    public void deleteDepartment(int departemtnId) {
        String query="delete from department where departmentID=?";
        jdbcTemplateObject.update(query,departemtnId);
    }
    public void updateUniversity(int universityID, String universityName) {
        String query="update university set universityName=? where universityId=?";
        jdbcTemplateObject.update(query,universityName,universityID);
    }
    public List<Faculty> selectedUniversity(int facultyId) {
        String query="select f.facultyId, f.facultyName, u.universityId, u.universityName from faculty f "
                        + "join university u on f.universityId=u.universityId  where f.facultyId = ?";
        List<Faculty> faculties;
        faculties = jdbcTemplateObject.query(query, new FacultyRowMapper(),facultyId);
        return faculties;
     }
    public List<University> unselectedUniversity(int university){
        String query="select universityId, universityName from university where universityId not like ?";
        List<University> univers = jdbcTemplateObject.query(query, new UniversityRowMapper(), university);
        return univers;
    }
    public List<University> selectedUniversit(int university){
        String query="select universityId, universityName from university where universityId = ?";
        List<University> univers = jdbcTemplateObject.query(query, new UniversityRowMapper(), university);
        return univers;
    }
    public void updateFaculty(int facultyId, String facultyName, int univerId) {
        String query="update faculty set facultyName=?, universityId=? where facultyId=?";
        jdbcTemplateObject.update(query, facultyName,univerId, facultyId);
    }
    public int getUniversityIdByName(String name){
        String query="select universityId  from university where lower(universityName) = ?";
        return jdbcTemplateObject.queryForInt(query, name.toLowerCase());
    }
    public void updateDepartment(int departmentId, String departmentName, int facId) {
        String query="update department set departmentName=?, facultyId=? where departmentId=?";
        jdbcTemplateObject.update(query, departmentName, facId,departmentId);
    }
    
    public List<Student> getOrderStudent(String param, String value, String orderBy){
        if (param.equals("getAll")){
            String query="select a.appid, u.firstname,u.lastname,u.email from users u "
                            + "join appform a on u.userid=a.userid order by "+orderBy;
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return std;
        }
        if (param.equals("appId")){
            String query="select a.appid, u.firstname,u.lastname,u.email from users u "
                            + "join appform a on u.userid=a.userid and a.appid=?";
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper(), value);
            return std;
        }
        if (param.equals("firstName")){
            String query="select a.appid, u.firstname,u.lastname,u.email from users u "
                            + "join appform a on u.userid=a.userid and "
                    + "lower(u.firstname) like '%"+value.toLowerCase()+"%' order by "+orderBy;
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return std;
        }
        if (param.equals("lastName")){
            String query="select a.appid, u.firstname,u.lastname,u.email from users u "
                            + "join appform a on u.userid=a.userid and "
                    + "lower(u.lastname) like '%"+value.toLowerCase()+"%' order by "+orderBy;
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return std;
        }
        if (param.equals("email")){
            String query="select a.appid, u.firstname,u.lastname,u.email from users u "
                            + "join appform a on u.userid=a.userid and "
                    + "lower(u.email) like '%"+value.toLowerCase()+"%' order by "+orderBy;
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return std;
        }
        if (param.equals("allFields")){
            String query = "select a.appid, u.firstname,u.lastname,u.email from users u "
                        + "join appform a on u.userid=a.userid and "
                             + "((a.appid like '"+value+"') or (lower(u.firstname) like '%"+value.toLowerCase()+"%') "
                                + "or (lower(u.lastname) like '%"+value.toLowerCase()+"%') "
                    + "or (lower(u.email) like '%"+value.toLowerCase()+"%')) order by "+orderBy;
            List<Student> std = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return std;
        }
        return null;
    }
    
    public List<Student> getOrderedStudentByEdu(String param, String value, String orderBy){
        String query=null;
        if (param.equals("getAll")){
            query="select a.appid, u.firstname,u.lastname,u.email from users u "+ 
                    "join appform a on u.userid=a.userid order by "+orderBy;
            List <Student> students = jdbcTemplateObject.query(query, new ShortStudentRowMapper());
            return students;
        }
        if (param.equals("universityId")){
            query="select a.appid, u.firstname,u.lastname,u.email, d.departmentName from users u "+
                    "join appform a on u.userid=a.userid "+
                        "join department d on d.departmentId=a.DepartmentId "+ 
                            "join faculty f on f.facultyid=d.facultyId "+
				"join university un on un.universityId=f.universityId and un.universityId=?"
                                    + " order by "+orderBy;
        }
        if (param.equals("facultyId")){
            query="select a.appid, u.firstname,u.lastname,u.email, d.departmentName from users u "+
                    "join appform a on u.userid=a.userid "+
                        "join department d on d.departmentId=a.DepartmentId "+ 
                            "join faculty f on f.facultyid=d.facultyId "+
				"join university un on un.universityId=f.universityId and f.facultyid=?"
                                    + " order by "+orderBy;
        }
        if (param.equals("departmentId")){
            query="select a.appid, u.firstname,u.lastname,u.email from users u "+ 
                    "join appform a on u.userid=a.userid and a.departmentId=? order by "+orderBy;
        }
        List <Student> students = jdbcTemplateObject.query(query, new ShortStudentRowMapper(), value);
        return students;
    }
    
    
    /**
     * Возвращает интервью, которое было назначено по ID анкеты
     * @author Alexander Lebed
     */
    public Interview getInterview(Integer appId) {
        String SQL = "SELECT * FROM Interview WHERE appId = ?";
        Interview interview = jdbcTemplateObject.queryForObject(SQL, new Object[] {appId}, new InterviewRowMapper());
        return interview;
    }
    
    public InterviewDate getInterviewDate(Integer interviewDateId) {
        String SQL = "SELECT * FROM InterviewDate WHERE interviewDateId = ?";
        InterviewDate interviewDate = jdbcTemplateObject.queryForObject(SQL, new Object[] {interviewDateId}, new InterviewDateRowMapper());
        return interviewDate;
    }
    
    public List <User> getInterviewersFromInterviewerList(Integer interviewDateId) {
        String SQL = "SELECT * FROM Users WHERE userId IN (SELECT userId FROM InterviewerList WHERE interviewDateId = ?)";
        List <User> users = jdbcTemplateObject.query(SQL, new Object[] {interviewDateId}, new UserRowMapper());
        return users;
    }
    
    public List <User> getInterviewersFromInterviewResults(Integer interviewId) {
        String SQL = "SELECT * FROM Users WHERE userId IN (SELECT userId FROM InterviewResults WHERE interviewId = ?)";
        List <User> users = jdbcTemplateObject.query(SQL, new Object[] {interviewId}, new UserRowMapper());
        return users;
    }
    
    public List <InterviewResults> getInterviewResults(Integer interviewId) {
        String SQL = "SELECT * FROM InterviewResults WHERE interviewId = ?";
        List <InterviewResults> interviewResults = jdbcTemplateObject.query(SQL, new Object[] {interviewId}, new InterviewResultsRowMapper());
        return interviewResults;
    }
    
    public List <UserResult> getUserResults(Integer interviewId) {
        String SQL = "SELECT u.userId, u.firstName, u.lastName, u.roleId, r.mark, r.comments FROM Users u, InterviewResults r WHERE u.UserId = r.UserId AND r.interviewId = ?";
        List <UserResult> userResults = jdbcTemplateObject.query(SQL, new Object[] {interviewId}, new UserResultRowMapper());
        return userResults;
    }
    
    /**
     * @param interviewId - ID интерьвью
     * @param dateFinish - дата окончания интервью
     * @return true если интервью БУДЕТ, false - БЫЛО
     */
//    public boolean getActualInterview(Integer interviewId, Date dateFinish) {
//        String SQL = "SELECT 1 FROM InterviewDate id, Interview i "+
//                     "WHERE SYSDATE < ? AND id.InterviewDateId = i.InterviewDateId AND i.InterviewId = ?";
//        Object[] params = new Object[] {dateFinish, interviewId};
//        int var = jdbcTemplateObject.queryForInt(SQL, params);
//        return (var==1) ? true : false;
//    }

}
