package com.neuedu.serviceImpl;

import com.neuedu.MyBatis.MyBatisloginImpl;
import com.neuedu.dao.UserDao;
import com.neuedu.daoImpl.UserDaoImpl;
import com.neuedu.daoImpl.UserDaoImpl2;
import com.neuedu.entity.User;
import com.neuedu.input.MD5Utils;
import com.neuedu.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDaoImpl=new UserDaoImpl2();
	
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDaoImpl.addUser(user);
	}
	
	@Override
	public User checkUser(String name, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.checkUser(name, password);
	}

	@Override
	public void addToken(String token,User user) {
		// TODO Auto-generated method stub
		String username=user.getUsername();
		String password=user.getUserpassword();
		
		userDaoImpl.updateTokenByAccountid(token, user);
		
	}

	@Override
	public String findToken(int Accountid) {
		// TODO Auto-generated method stub
		return userDaoImpl.findTokenByAccountid(Accountid);
	}

	
	
	
	
	
	

}
