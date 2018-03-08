package com.person.dao;

public class DAOFactory {

	public static UserDAO getReaderDAO() {
		return new UserDAOImpl();
	}

	
}
