package com.neuedu.dao;

import com.neuedu.entity.User;


public interface UserDao {
	
	boolean addUser(User user);
	
	User checkUser(String name, String password);
	
	 void updateTokenByAccountid(String token, User user);
	 
	 String findTokenByAccountid(int Accountid); 
	 
	 
}
