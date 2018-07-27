package com.neuedu.entity;

public class User {

	private int id;
private String username;
private String userpassword;


	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public User(int id,String username,String userpassword){
		this.id=id;
		this.username=username;
		this.userpassword=userpassword;

	}
	public User(){

	}
}

