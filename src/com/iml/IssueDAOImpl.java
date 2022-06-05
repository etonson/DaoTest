package com.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.IssueDAO;
import com.vo.Issue;

public class IssueDAOImpl implements IssueDAO {
	private Connection con;
	private PreparedStatement stat = null;

	public IssueDAOImpl(Connection con) {
		this.con = con;
	}

	public boolean doCreate(Issue issue) throws Exception {
		String sql = "INSERT INTO Issue(issueTitle," + "issueDescribe,status,recipient,"
				+ "assigness,startDate,deadDate) " + "VALUES(?,?,?,?,?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setString(1, issue.getiIssueTitle());
		stat.setString(2, issue.getIssueDescribe());
		stat.setInt(3, issue.getStatus());
		stat.setString(4, issue.getRecipient());
		stat.setString(5, issue.getAssigness());
		stat.setString(6, issue.getStartDate());
		stat.setString(7, issue.getDeadDate());
		int update = stat.executeUpdate();
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Issue> findAll() throws Exception {
		String sql = "SELECT issueID,issueTitle,issueDescribe,status,recipient,"
				+ "assigness,startDate,deadDate FROM Issue";
		stat = con.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		List<Issue> list = new ArrayList<Issue>();
		while (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			String issueDescribe = rs.getString(3);
			int status = Integer.parseInt(rs.getString(4));
			String recipient = rs.getString(5);
			String assigness = rs.getString(6);
			String startDate = rs.getString(7);
			String deadDate = rs.getString(8);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setIssueDescribe(issueDescribe);
			issue.setStatus(status);
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
			list.add(issue);
		}
		return list;
	}

	public List<Issue> findAllByRecipient(String recipient) throws Exception {
		String sql = "SELECT issueID,issueTitle,status,recipient,"
				+ "assigness,startDate,deadDate FROM Issue WHERE recipient=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, recipient);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		List<Issue> list = new ArrayList<Issue>();
		while (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			int status = Integer.parseInt(rs.getString(3));
			String assigness = rs.getString(5);
			String startDate = rs.getString(6);
			String deadDate = rs.getString(7);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setStatus(status);
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
			list.add(issue);
		}
		return list;
	}

	public Issue findById(String recipient) throws Exception {
		String sql = "SELECT issueID,issueTitle,issueDescribe,status,recipient,"
				+ "assigness,startDate,deadDate FROM Issue WHERE recipient=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, recipient);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		if (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			String issueDescribe = rs.getString(3);
			String status = rs.getString(4);
			String assigness = rs.getString(6);
			String startDate = rs.getString(7);
			String deadDate = rs.getString(8);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setIssueDescribe(issueDescribe);
			issue.setStatus(Integer.parseInt(status));
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
		}
		return issue;
	}
}
