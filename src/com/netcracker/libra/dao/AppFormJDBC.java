/*
 * 
 * 
 * НЕ ИСПОЛЬЗОВАТЬ
 * 
 * 
 * 
 */
package com.netcracker.libra.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netcracker.libra.model.AppForm;
import com.netcracker.libra.model.RegisterForm;

@Repository
public class AppFormJDBC {
	
	
	private static JdbcTemplate jdbcTemplateObject;
	
	public AppFormJDBC() {
		
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	private int getAppCurrVal() {
	       String SQL = "select AppForm_seq.NEXTVAL as AppId from dual";
	       Integer id = jdbcTemplateObject.queryForInt(SQL);
	       return id;
	   }
	
	private int getColumnFieldsCurrVal() {
	       String SQL = "select ColumnFields_seq.NEXTVAL as columnid from dual";
	       Integer id = jdbcTemplateObject.queryForInt(SQL);
	       return id;
	   }
	
	private int getCurrentUserId() {
	       String SQL = "select user_seq.CURRVAL as userid from dual";
	       Integer id = jdbcTemplateObject.queryForInt(SQL);
	       return id;
	   }
	
	public void createEntry(AppForm form) {
		
		Integer appid = getAppCurrVal();
		
		Map<String, String> personal = form.getPersonal();
		Map<String, String> textFields = form.getTextFieldsMap(); 
		String[] whatsInterested = form.getInterests(); 
		String[] workType = form.getWorkTypes(); 
		Map<String, String> programmingLang = form.getProgrammingLanguagesMap(); 
		Map<String, String> knowledges = form.getKnowledgesMap(); 
		Map<String, Integer> englishGrades = form.getEnglishGradesMap(); 
		
		String sql = "insert into " +
				"appform (APPID,USERID,PATRONYMIC,PHONENUMBER,DEPARTMENTID,ADVERTISINGID,ADVERTISINGCOMMENT,COURSE,GRADUATED,TEMPLATEID) " +
				"values (?,?,?,?,?,?,?,?,?,?)";
		
		String sql2 = "insert into columnfields values (?,?,?,?,?)";
		
		jdbcTemplateObject.update(sql, appid, 84, personal.get("patronymic"), 
				personal.get("phoneNumber"), 1, 1, "comment", personal.get("term"), personal.get("graduated"), 17);
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 109, appid,
				textFields.get("Почему именно тебя следует взять в NetCracker? Важные достоинства, возможно обещания?"), 1);
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 110, appid,
				textFields.get("Дополнительные сведения о себе: олимпиады, курсы, поощрения, сертификаты и т.п."), 1);
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 111, appid,
				textFields.get("Если у тебя есть опыт работы или выполненные учебные проекты, опиши их"), 1);
		
		
		for (String x : whatsInterested) {
			jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 112, appid, x, 1);
		}
		
		for (String x : workType) {
			jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 115, appid, x, 1);
		}
		
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 120, appid, programmingLang.get("Java"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 121, appid, programmingLang.get("C++"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 122, appid, programmingLang.get("C#"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 123, appid, programmingLang.get(".NET"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 124, appid, programmingLang.get("Python"), 1);
		
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 125, appid, knowledges.get("Сетевые технологии"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 126, appid, knowledges.get("Эффективные алгоритмы"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 127, appid, knowledges.get("ООП"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 128, appid, knowledges.get("Базы данных"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 129, appid, knowledges.get("Web-технологии"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 130, appid, knowledges.get("Графический интерфейс (не Web)"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 131, appid, knowledges.get("Сетевое программирование"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 132, appid, knowledges.get("Проектирование программ"), 1);
		
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 133, appid, englishGrades.get("Чтение"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 134, appid, englishGrades.get("Письмо"), 1);
		jdbcTemplateObject.update(sql2, getColumnFieldsCurrVal(), 135, appid, englishGrades.get("Устная речь"), 1);

	}
	
}
