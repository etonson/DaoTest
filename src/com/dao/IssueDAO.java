package com.dao;

import java.util.List;

import com.vo.Issue;

public interface IssueDAO {
	public boolean doCreate(Issue issue) throws Exception;

	public List<Issue> findAll() throws Exception;

	public Issue findById(String recipient) throws Exception;

	public List<Issue> findAllByRecipient(String recipient) throws Exception;
}
