package com.vo;

public class Issue {
	private int issueID;
	private String issueTitle;
	private String issueDescribe;
	private int status;
	private String recipient;
	private String assigness;
	private String startDate;
	private String deadDate;

	public int getIssueID() {
		return issueID;
	}

	public String getiIssueTitle() {
		return issueTitle;
	}

	public String getIssueDescribe() {
		return issueDescribe;
	}

	public int getStatus() {
		return status;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getAssigness() {
		return assigness;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getDeadDate() {
		return deadDate;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	public void setIssueDescribe(String issueDescribe) {
		this.issueDescribe = issueDescribe;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public void setAssigness(String assigness) {
		this.assigness = assigness;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setDeadDate(String deadDate) {
		this.deadDate = deadDate;
	}
}