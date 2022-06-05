package com.vo;

public class Course {
	private int courseID;
	private int issueID;
	private String replyDate;
	private String reply;

	public Course() {
	}

	public int getCourseID() {
		return courseID;
	}

	public int getIssueID() {
		return issueID;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public String getReply() {
		return reply;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
}