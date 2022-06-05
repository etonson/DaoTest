package com.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDAO;
import com.vo.User;

public class UserDAOImpl implements UserDAO {
	private Connection con;
	private PreparedStatement stat = null;

	public UserDAOImpl(Connection con) {
		this.con = con;
	}

	public boolean doCreate(User user) throws Exception {
		String sql = "INSERT INTO User(account,name,pwd,email) VALUES(?,?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setString(1, user.getAccount());
		stat.setString(2, user.getName());
		stat.setString(3, user.getPwd());
		stat.setString(4, user.getEmail());
		int update = stat.executeUpdate();
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> findAll() throws Exception {
		String sql = "SELECT account,name,pwd,email FROM User";
		stat = con.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		User user = null;
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			String Account = rs.getString(1);
			String Name = rs.getString(2);
			String Pwd = rs.getString(3);
			String Email = rs.getString(4);
			user = new User();
			user.setAccount(Account);
			user.setName(Name);
			user.setPwd(Pwd);
			user.setEmail(Email);
			list.add(user);
		}
		return list;
	}

	public User findById(String account) throws Exception {
		String sql = "SELECT account,name,pwd,email FROM User WHERE account=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, account);
		ResultSet rs = stat.executeQuery();
		User user = null;
		if (rs.next()) {
			String name = rs.getString(2);
			String pwd = rs.getString(3);
			String email = rs.getString(4);
			user = new User();
			user.setAccount(account);
			user.setName(name);
			user.setPwd(pwd);
			user.setEmail(email);
		}
		return user;
	}

	public User checkExistById(String account, String pwd) throws Exception {
		String sql = "SELECT account,name,pwd,email FROM User WHERE account=? and pwd=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, account);
		stat.setString(2, pwd);
		ResultSet rs = stat.executeQuery();
		User user = null;
		if (rs.next()) {
			String name = rs.getString(2);
			String email = rs.getString(4);
			user = new User();
			user.setAccount(account);
			user.setName(name);
			user.setPwd(pwd);
			user.setEmail(email);
		}
		return user;
	}

}