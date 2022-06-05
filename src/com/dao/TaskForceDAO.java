package com.dao;

import java.util.List;

import com.vo.TaskForce;

public interface TaskForceDAO {
	public boolean doCreate(TaskForce taskForce) throws Exception;

	public List<TaskForce> findAll() throws Exception;

	public TaskForce findById(String account) throws Exception;
}
