package com.neuedu.entity;

public class User {

	private int accountid;
private String username;
private String userpassword;


	public int getAccountid() {
		return accountid;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public User(int accountid,String username,String userpassword){
		this.accountid=accountid;
		this.username=username;
		this.userpassword=userpassword;

	}
	public User(){

	}
}

