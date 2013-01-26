package com.netcracker.libra.dao;

import javax.sql.DataSource;

public interface CommonDAO {
	void setDataSource(DataSource dataSource);
	void create(String name, String lastName, String email, String password);
	void update(Integer id, String name, String lastName, String email, String password);
	void delete(Integer id);
}
