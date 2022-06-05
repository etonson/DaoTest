package com.iml;

import java.util.List;

import com.con.DatabaseConnection;
import com.dao.UserDAO;
import com.vo.User;

public class UserDAOProxy implements UserDAO {
	private DatabaseConnection dbc;
	private UserDAO dao = null;

	public UserDAOProxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new UserDAOImpl(dbc.getConnection());
	}

	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		if (dao.findById(user.getAccount()) == null) {
			flag = dao.doCreate(user);
		}
		dbc.close();
		return flag;
	}

	public List<User> findAll() throws Exception {
		List<User> list = dao.findAll();
		dbc.close();
		return list;
	}

	public User findById(String account) throws Exception {
		User user = dao.findById(account);
		dbc.close();
		return user;
	}
	public User checkExistById(String account, String pwd) throws Exception {
		User user = dao.checkExistById(account,pwd);
		dbc.close();
		return user;
	}
}
