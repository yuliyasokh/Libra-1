package com.netcracker.libra.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.netcracker.libra.model.BlockWithValues;
import com.netcracker.libra.model.FilledAppForm;
import com.netcracker.libra.model.RegisterForm;
import com.netcracker.libra.util.security.Security;

@Repository
public class AppFormJDBC {

	private static JdbcTemplate jdbcTemplateObject;
	private static SimpleJdbcInsert insert1;
	private static SimpleJdbcInsert insert2;
	private static SimpleJdbcInsert insert3;
	private static SimpleJdbcInsert insert4;
	private static SimpleJdbcInsert insert5;

	private Number userId;
	private Number appId;

	public AppFormJDBC() {

	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		insert1 = new SimpleJdbcInsert(dataSource);
		insert2 = new SimpleJdbcInsert(dataSource);
		insert3 = new SimpleJdbcInsert(dataSource);
		insert4 = new SimpleJdbcInsert(dataSource);
		insert5 = new SimpleJdbcInsert(dataSource);
	}

	public Map<Integer, String> getAllUniversities() {

		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from university";

		for (Map<String, Object> x : jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("universityid")).intValueExact(),
					(String) x.get("universityname"));
		}
		return map;

	}

	public Map<Integer, String> getAllFaculties() {

		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from faculty";

		for (Map<String, Object> x : jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("facultyid")).intValueExact(),
					(String) x.get("facultyname"));
		}
		return map;

	}

	public Map<Integer, String> getAllDepartments() {

		Map<Integer, String> map = new HashMap<>();
		String sql = "select * from department";

		for (Map<String, Object> x : jdbcTemplateObject.queryForList(sql)) {
			map.put(((BigDecimal) x.get("departmentid")).intValueExact(),
					(String) x.get("departmentname"));
		}
		return map;

	}

	public Map<Integer, BlockWithValues> getTextBlocks() {

		Map<Integer, BlockWithValues> blockMap = new HashMap<>();
		String sql = "select BLOCKID, BLOCKHEADER from block where templateid=? and typeid=3";
		List<Map<String, Object>> blockList = jdbcTemplateObject.queryForList(
				sql, 1);

		for (Map x : blockList) {
			Integer blockid = ((BigDecimal) x.get("blockid")).intValueExact();
			BlockWithValues bwv = new BlockWithValues();
			bwv.setHeader((String) x.get("blockheader"));
			bwv.setBlockID(blockid);
			blockMap.put(blockid, bwv);
		}
		return blockMap;
	}

	public Map<Integer, BlockWithValues> getGradeBlocks() {

		Map<Integer, BlockWithValues> blockMap = new HashMap<>();
		String sql = "select BLOCKID, BLOCKHEADER from block where templateid=? and typeid=2";
		List<Map<String, Object>> blockList = jdbcTemplateObject.queryForList(
				sql, 1);

		for (Map x : blockList) {
			Integer blockid = ((BigDecimal) x.get("blockid")).intValueExact();
			BlockWithValues bwv = new BlockWithValues();
			Map<Integer, String> valueMap = bwv.getValues();
			List<Map<String, Object>> valueList = jdbcTemplateObject
					.queryForList(
							"select blockvalueid, blockvalue from blockvalues where blockid=?",
							blockid);

			for (Map y : valueList) {
				valueMap.put(
						((BigDecimal) y.get("blockvalueid")).intValueExact(),
						(String) y.get("blockvalue"));

			}
			bwv.setHeader((String) x.get("blockheader"));
			bwv.setBlockID(blockid);
			blockMap.put(blockid, bwv);
		}
		return blockMap;
	}

	public Map<Integer, BlockWithValues> getCheckboxBlocks() {

		Map<Integer, BlockWithValues> blockMap = new HashMap<>();
		List<Map<String, Object>> blockList;

		String sql = "select BLOCKID, BLOCKHEADER from BLOCK where TEMPLATEID=? and TYPEID=1";
		blockList = jdbcTemplateObject.queryForList(sql, 1);

		for (Map x : blockList) {
			Integer blockid = ((BigDecimal) x.get("blockid")).intValueExact();
			BlockWithValues bwv = new BlockWithValues();
			Map<Integer, String> valueMap = bwv.getValues();
			List<Map<String, Object>> valueList = jdbcTemplateObject
					.queryForList(
							"SELECT BLOCKVALUEID, BLOCKVALUE from BLOCKVALUES where BLOCKID=?",
							blockid);

			for (Map y : valueList) {
				valueMap.put(
						((BigDecimal) y.get("BLOCKVALUEID")).intValueExact(),
						(String) y.get("BLOCKVALUE"));

			}
			bwv.setHeader((String) x.get("BLOCKHEADER"));
			bwv.setBlockID(blockid);
			bwv.setValues(valueMap);
			blockMap.put(blockid, bwv);
		}
		return blockMap;
	}

	public void saveData(FilledAppForm form, RegisterForm rform) {
		insertUser(rform);
		fillAppForm(form.getPersonal());
		System.out.println("Заполнение оценок");
		fillGradeAnswers(form.getGradeAnswers());
		fillTextFieldsAnswers(form.getTextFieldsAnswers());
		fillCheckboxAnswers(form.getCheckboxAnswers());
	}

	@SuppressWarnings("unchecked")
	private void fillCheckboxAnswers(Map<String, Integer> form) {

		if (!form.isEmpty()) {
			List<Map> params = new ArrayList<>(form.keySet().size());
			Map<String, Object>[] ar;

			for (String x : form.keySet()) {
				Map map = new HashMap();
				map.put("BLOCKID", form.get(x));
				map.put("APPID", appId);
				map.put("CHECKBOXANSWERVALUE", x);
				params.add(map);
				// System.out.println("Putting key "+x+"and value "
				// +form.get(x));
			}

			ar = params.toArray(new HashMap[params.size()]);
			insert1.withTableName("CHECKBOXANSWERS");
			insert1.executeBatch(ar);
		} else
			return;
	}

	@SuppressWarnings("unchecked")
	private void fillTextFieldsAnswers(Map<Integer, String> form) {

		List<Map> params = new ArrayList<>(form.keySet().size());
		Map<String, Object>[] ar;

		if (!form.isEmpty()) {
			for (Integer x : form.keySet()) {
				Map map = new HashMap();
				map.put("BLOCKID", x);
				map.put("APPID", appId);
				map.put("TEXTFIELDANSWERVALUE", form.get(x));
				params.add(map);
				System.out.println("Putting key " + x + "and value "
						+ form.get(x));
			}

			ar = params.toArray(new HashMap[params.size()]);
			insert2.withTableName("TEXTFIELDSANSWERS");
			insert2.executeBatch(ar);
		} else
			return;
	}

	@SuppressWarnings("unchecked")
	private void fillGradeAnswers(Map<Integer, String> form) {

		if (!form.isEmpty()) {
			List<Map> params = new ArrayList<>(form.keySet().size());
			Map<String, Object>[] ar;

			for (Integer x : form.keySet()) {
				Map map = new HashMap();
				map.put("BLOCKVALUEID", x);
				map.put("APPID", appId);
				map.put("ANSWER", form.get(x));
				params.add(map);
				System.out.println("Putting key " + x + "and value "
						+ form.get(x));
			}

			ar = params.toArray(new HashMap[params.size()]);
			insert3.withTableName("GRADEANSWERS");
			insert3.executeBatch(ar);
		}
	}

	@SuppressWarnings("unchecked")
	private void insertUser(RegisterForm rform) {

		Map map = new HashMap();
		map.put("FIRSTNAME", rform.getName());
		map.put("LASTNAME", rform.getLastName());
		map.put("EMAIL", rform.getEmail());
		map.put("PASSWORD", Security.getMD5hash(rform.getPassword()));
		map.put("ROLEID", 1);

		userId = insert4.withTableName("USERS_COPY")
				.usingGeneratedKeyColumns("USERID").executeAndReturnKey(map);
	}

	@SuppressWarnings("unchecked")
	private void fillAppForm(Map form) {

		if (!form.isEmpty()) {

			jdbcTemplateObject
					.update("INSERT "
							+ "INTO APPFORMCOPY (USERID, PATRONYMIC, PHONENUMBER, DEPARTMENTID, ADVERTISINGID, COURSE, GRADUATED, TEMPLATEID )"
							+ " VALUES (?,?,?,?,?,?,?,?)", 
							userId, form.get("patronymic"), 
							form.get("phoneNumber"), form.get("departmentid"), 1, 
							form.get("course"), form.get("graduated"),1);
							
			appId = jdbcTemplateObject
					.queryForInt("select appformcopyseq.CURRVAL from dual");

			/*
			 * Не работает по непонятной причине, неверный тип столбца
			 * 
			 * Map appFormMap = new HashMap();
			 * 
			 * appFormMap.put("USERID", userId);
			 * System.out.println("Вставили userid " + userId);
			 * 
			 * appFormMap.put("PATRONYMIC", form.get("patronymic"));
			 * System.out.println
			 * ("Вставили PATRONYMIC "+form.get("patronymic"));
			 * 
			 * appFormMap.put("PHONENUMBER", form.get("phoneNumber"));
			 * System.out.println("Вставили PHONENUMBER "
			 * +form.get("phoneNumber"));
			 * 
			 * appFormMap.put("DEPARTMENTID", form.get("departmentid"));
			 * System.out.println("Вставили DEPARTMENTID "+
			 * form.get("departmentid"));
			 * 
			 * //appFormMap.put("ADVERTISINGID", form.get("advertisingid"));
			 * appFormMap.put("ADVERTISINGID",1);
			 * System.out.println("Вставили ADVERTISINGID "+ 1);
			 * 
			 * appFormMap.put("COURSE", form.get("course"));
			 * System.out.println("Вставили COURSE " + form.get("course"));
			 * 
			 * appFormMap.put("GRADUATED", form.get("graduated"));
			 * System.out.println("Вставили GRADUATED " +
			 * form.get("graduated"));
			 * 
			 * appFormMap.put("TEMPLATEID",1);
			 * System.out.println("Вставили TEMPLATEID "+ 1);
			 * 
			 * try { appId = insert5.withTableName("APPFORMCOPY")
			 * .usingGeneratedKeyColumns("APPID")
			 * .executeAndReturnKey(appFormMap); } catch
			 * (UncategorizedSQLException e) { e.printStackTrace(); } }
			 */

		}
	}
}
