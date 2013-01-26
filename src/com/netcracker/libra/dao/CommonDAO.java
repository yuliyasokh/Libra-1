package com.netcracker.libra.dao;

public interface CommonDAO {
	void create(String name, String lastName, String email, String password);
	void update(Integer id, String name, String lastName, String email, String password);
	void delete(Integer id);
}
