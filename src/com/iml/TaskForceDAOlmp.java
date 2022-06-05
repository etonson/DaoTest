package com.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.TaskForceDAO;
import com.vo.TaskForce;

public class TaskForceDAOlmp implements TaskForceDAO {
	private Connection con;
	private PreparedStatement stat = null;

	public TaskForceDAOlmp(Connection con) {
		this.con = con;
	}

	public boolean doCreate(TaskForce taskForce) throws Exception {
		String sql = "INSERT INTO TaskForce(account,depart,level) " + "VALUES(?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setString(1, taskForce.getAccount());
		stat.setString(2, taskForce.getDepart());
		stat.setInt(3, taskForce.getLevel());
		int update = stat.executeUpdate();
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<TaskForce> findAll() throws Exception {
		String sql = "SELECT account,depart,level FROM TaskForce";
		stat = con.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		TaskForce taskForce = null;
		List<TaskForce> list = new ArrayList<TaskForce>();
		while (rs.next()) {
			String account = rs.getString(1);
			String depart = rs.getString(2);
			int level = Integer.parseInt(rs.getString(3));
			taskForce = new TaskForce();
			taskForce.setAccount(account);
			taskForce.setDepart(depart);
			taskForce.setLevel(level);
			list.add(taskForce);
		}
		return list;
	}

	public TaskForce findById(String account) throws Exception {
		String sql = "SELECT account,depart,level FROM TaskForce WHERE account=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, account);
		ResultSet rs = stat.executeQuery();
		TaskForce taskForce = null;
		if (rs.next()) {
			String depart = rs.getString(2);
			int level = Integer.parseInt(rs.getString(3));
			taskForce = new TaskForce();
			taskForce.setAccount(account);
			taskForce.setDepart(depart);
			taskForce.setLevel(level);
		}
		return taskForce;
	}
}
