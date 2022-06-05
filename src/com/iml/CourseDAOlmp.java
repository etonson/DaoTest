package com.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.CourseDAO;
import com.vo.Course;

public class CourseDAOlmp implements CourseDAO {
	private Connection con;
	private PreparedStatement stat = null;

	public CourseDAOlmp(Connection con) {
		this.con = con;
	}

	public boolean doCreate(Course course) throws Exception {
		String sql = "INSERT INTO Course(issueID,replyDate,reply)VALUES(?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setInt(1, course.getIssueID());
		stat.setString(2, course.getReplyDate());
		stat.setString(3, course.getReply());
		int update = stat.executeUpdate();
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Course> findAll() throws Exception {
		String sql = "SELECT courseID,issueID,replyDate,reply" + "FROM Course";
		stat = con.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		Course course = null;
		List<Course> list = new ArrayList<Course>();
		while (rs.next()) {
			int courseID = Integer.parseInt(rs.getString(1));
			int issueID = Integer.parseInt(rs.getString(2));
			String replyDate = rs.getString(3);
			String reply = rs.getString(4);

			course = new Course();
			course.setCourseID(courseID);
			course.setIssueID(issueID);
			course.setReplyDate(replyDate);
			course.setReply(reply);

			list.add(course);
		}
		return list;
	}

	public Course findById(int courseID) throws Exception {
		String sql = "SELECT courseID,issueID,replyDate,reply" + "FROM Course WHERE courseID=?";
		stat = con.prepareStatement(sql);
		stat.setInt(1, courseID);
		ResultSet rs = stat.executeQuery();
		Course course = null;
		if (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(2));
			String replyDate = rs.getString(3);
			String reply = rs.getString(4);

			course = new Course();
			course.setIssueID(issueID);
			course.setReplyDate(replyDate);
			course.setReply(reply);
		}
		return course;
	}
}
