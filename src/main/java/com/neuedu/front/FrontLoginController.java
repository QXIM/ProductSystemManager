package com.neuedu.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.User;
import com.neuedu.input.MD5Utils;
import com.neuedu.service.UserService;
import com.neuedu.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/com/neuedu/front/login.do")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String _username=request.getParameter("username");
		String _password=request.getParameter("password");
		String _method=request.getParameter("method");
		
		UserService userServiceImpl=new UserServiceImpl();
		User user= userServiceImpl.checkUser(_username, MD5Utils.GetMD5Code(_password));
		System.out.println(user);
		
		if(user!=null) {
			//��½�ɹ�
		Gson gson=new Gson();	
		String json=gson.toJson(user);
		
		//��ȡ�����
		PrintWriter write=response.getWriter();
		write.println(_method+"("+json+")");
		
		
		
		}
		
 
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
