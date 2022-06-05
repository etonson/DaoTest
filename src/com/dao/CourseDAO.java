package com.dao;

import java.util.List;

import com.vo.Course;

public interface CourseDAO {
	public boolean doCreate(Course course) throws Exception;

	public List<Course> findAll() throws Exception;

	public Course findById(int courseID ) throws Exception;
}
