package com.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.person.vo.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {

	private static final String CHECK_LOGIN_SQL = "select * from user where name = ? and psd = ?";

	@Override
	public User checkLogin(String name, String psd) throws DAOException {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(CHECK_LOGIN_SQL);
			ps.setString(1, name);

			ps.setString(2, psd);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPsd(rs.getString("psd"));
			}
		} catch (SQLException e) {
			throw new DAOException("登陆失败." + e.getMessage());
		} finally {
			closeDBObjects(rs, ps, conn);
		}
		return user;
	}

	private static final String INSERT_USER_SQL = "INSERT INTO user(name,psd) VALUES (?,?)";

	@Override
	public void insert(User user) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(INSERT_USER_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPsd());

			ps.execute();
		} catch (SQLException e) {
			throw new DAOException("注册失败.  " + e.getMessage());
		} finally {
			closeDBObjects(null, ps, conn);
		}

	}

	private static final String GET_USERS_SQL = "select * from user ";

	@Override
	public List<User> getUser() throws DAOException {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(GET_USERS_SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPsd(rs.getString("psd"));

				users.add(user);
			}
		} catch (SQLException e) {
			throw new DAOException("获取读者信息失败." + e.getMessage());
		} finally {
			closeDBObjects(null, ps, conn);
		}

		return users;
	}

	private static final String GET_USER_SQL = "select * from user where id = ?";

	@Override
	public User getUser(int id) throws DAOException {
		User user = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(GET_USER_SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPsd(rs.getString("psd"));

			}
		} catch (SQLException e) {
			throw new DAOException("获取读者信息失败. " + e.getMessage());
		} finally {
			closeDBObjects(null, ps, conn);
		}

		return user;
	}

	@Override
	public void updateUser(User user) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteUser(int id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
