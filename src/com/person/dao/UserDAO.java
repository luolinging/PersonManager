package com.person.dao;

import java.util.List;

import com.person.vo.User;

public interface UserDAO extends DAO {
	public User checkLogin(String name, String psd) throws DAOException;

	void insert(User user) throws DAOException;

	List<User> getUser() throws DAOException;

	User getUser(int id) throws DAOException;

	void updateUser(User user) throws DAOException;

	boolean deleteUser(int id) throws DAOException;
}
