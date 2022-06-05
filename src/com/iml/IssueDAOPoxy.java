package com.iml;

import java.util.List;

import com.con.DatabaseConnection;
import com.dao.IssueDAO;
import com.vo.Issue;

public class IssueDAOPoxy implements IssueDAO {
	private DatabaseConnection dbc;
	private IssueDAOImpl dao = null;

	public IssueDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new IssueDAOImpl(dbc.getConnection());
	}

	public boolean doCreate(Issue issue) throws Exception {
		boolean flag = false;
		if (dao.findById(issue.getRecipient()) == null) {
			flag = dao.doCreate(issue);
		}
		dbc.close();
		return flag;
	}

	public List<Issue> findAll() throws Exception {
		List<Issue> list = dao.findAll();
		dbc.close();
		return list;
	}

	public List<Issue> findAllByRecipient(String recipient) throws Exception {
		List<Issue> list = dao.findAllByRecipient(recipient);
		dbc.close();
		return list;
	}

	public Issue findById(String recipient) throws Exception {
		Issue issue = dao.findById(recipient);
		dbc.close();
		return issue;
	}
}