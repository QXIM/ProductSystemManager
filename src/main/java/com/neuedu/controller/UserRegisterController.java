package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.User;
import com.neuedu.input.MD5Utils;
import com.neuedu.service.UserService;
import com.neuedu.serviceImpl.UserServiceImpl;




@WebServlet("/register.do")
public class UserRegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userServiceImpl=new UserServiceImpl();
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userServiceImpl.addUser(user);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String _username=req.getParameter("username");
		String _password=req.getParameter("password");
		
		System.out.println("username="+_username+"password="+MD5Utils.GetMD5Code(_password));
		
		User user=new User();
		user.setName(_username);
		user.setPassword(MD5Utils.GetMD5Code(_password));
		
		boolean result=addUser(user);
		
		if(result) {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
		}else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	
}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}



	
	
}
