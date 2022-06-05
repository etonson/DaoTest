package com.vo;

public class User {
	private String account;
	private String name;
	private String pwd;
	private String email;

	public User() {
	}

	public String getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
