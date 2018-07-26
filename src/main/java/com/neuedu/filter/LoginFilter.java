package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.User;
import com.neuedu.input.MD5Utils;
import com.neuedu.service.UserService;
import com.neuedu.serviceImpl.UserServiceImpl;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("DAODA");
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		
		
		Cookie[] cookies=_request.getCookies();
		String _username=null;
		String _password=null;
		if(cookies!=null) {
		for( Cookie c:cookies) {
			if(c.getName().equals("username")) {
				_username=c.getValue();
			}
			if(c.getName().equals("password")) {
				_password=c.getValue();
			}
		}
		}
		if(_username!=null&&_password!=null) {
			UserService userServiceImpl=new UserServiceImpl();
			User user= userServiceImpl.checkUser(_username, _password);
			if(user!=null) {
				long time=System.currentTimeMillis();
				String token=MD5Utils.GetMD5Code(_username+_password+time);
				System.out.println(user);
				userServiceImpl.addToken(token,user);
				HttpSession session=_request.getSession();
				session.setAttribute("token", token);
				session.setAttribute("user",user);
				
				
				_request.getRequestDispatcher("product/loginsucc.jsp").forward(_request, _response);
			}else {
				chain.doFilter(request, response);
			}
		}else {
		chain.doFilter(request, response);
	}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
