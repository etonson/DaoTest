package com.factory;

import com.dao.CourseDAO;
import com.dao.IssueDAO;
import com.dao.TaskForceDAO;
import com.dao.UserDAO;
import com.iml.CourseDAOPoxy;
import com.iml.IssueDAOPoxy;
import com.iml.TaskForceDAOPoxy;
import com.iml.UserDAOProxy;

public class DAOFactory {
	public static UserDAO getInstance() {
		UserDAO dao = null;
		try {
			dao = new UserDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static IssueDAO getIssueInstance() {
		IssueDAO dao = null;
		try {
			dao = new IssueDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static TaskForceDAO getTaskForceInstance() {
		TaskForceDAO dao = null;
		try {
			dao = new TaskForceDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static CourseDAO getCourseInstance() {
		CourseDAO dao = null;
		try {
			dao = new CourseDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
}