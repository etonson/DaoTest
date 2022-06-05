package com.iml;

import java.util.List;

import com.con.DatabaseConnection;
import com.dao.CourseDAO;
import com.vo.Course;

public class CourseDAOPoxy implements CourseDAO {
	private DatabaseConnection dbc;
	private CourseDAOlmp dao = null;

	public CourseDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new CourseDAOlmp(dbc.getConnection());
	}

	public boolean doCreate(Course course) throws Exception {
		boolean flag = false;
		if (dao.findById(course.getCourseID()) == null) {
			flag = dao.doCreate(course);
		}
		dbc.close();
		return flag;
	}

	public List<Course> findAll() throws Exception {
		List<Course> list = dao.findAll();
		dbc.close();
		return list;
	}

	public Course findById(int courseID) throws Exception {
		Course course = dao.findById(courseID);
		dbc.close();
		return course;
	}
}
