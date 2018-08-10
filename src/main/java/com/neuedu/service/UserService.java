package com.neuedu.service;

import com.neuedu.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	boolean addUser(User user);
	User  checkUser(String name, String password);
	
	void addToken(String token, User user);
	
	String findToken(int Accountid);

}
