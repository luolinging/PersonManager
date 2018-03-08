package com.person.service;

import java.util.List;

import com.person.dao.DAOException;
import com.person.dao.DAOFactory;
import com.person.dao.UserDAO;
import com.person.vo.User;

public class UserService {
	private UserDAO dao = DAOFactory.getReaderDAO();

	public void save(User user) {
		try {
			if (user.getId() > 0)
				dao.updateUser(user);
			else
				dao.insert(user);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public User checkLogin(String name, String password) {
		User user = null;
		try {
			user = dao.checkLogin(name, password);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getUser() {
		List<User> users = null;
		try {
			users = dao.getUser();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUser(int id) {
		User user = new User();
		try {
			user = dao.getUser(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(int id) {
		boolean isSuccess = false;
		try {
			isSuccess = dao.deleteUser(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
