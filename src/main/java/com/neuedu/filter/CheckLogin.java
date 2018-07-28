package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.serviceImpl.UserServiceImpl;


 
/*@WebFilter("/product/*")*/
public class CheckLogin implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLogin() {
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
		
		HttpServletRequest _req=(HttpServletRequest)request;
		HttpServletResponse _resp=(HttpServletResponse)response;
		HttpSession session=_req.getSession();
		System.out.println(session.getMaxInactiveInterval());
		Object o=session.getAttribute("token");
		Object user_obj=session.getAttribute("user");
		
		
		if(o!=null&&user_obj!=null) {
			String _session=(String)o;
			User _user=(User)user_obj;
			System.out.println("guolv="+_user);
			UserService userservice=new UserServiceImpl();
			String _token= userservice.findToken(_user.getAccountid());
			
			if(_token!=null) {
			if(_session.equals(_token)) {
				chain.doFilter(request, response);
				return;
			}
		}
		}
		_resp.sendRedirect("http://localhost:8080/ProductSystem_web/login.jsp");





/*


		HttpServletRequest request = (HttpServletRequest)_request;
		HttpServletResponse response = (HttpServletResponse) _response;
		//得到会话域,服务器会根据已写到浏览器的JESSIONID查询到这个会话并加入到会话
		HttpSession session = request.getSession();

		Object o = session.getAttribute("token");
		Object o1 = session.getAttribute("acc");

		if(o!=null&&o1!=null) {
			String token = (String) o;
			Account account = (Account) o1;
			LoginService ls = new LoginServiceImpl();
			String data_token = ls.findTokenByAccountId(account.getId());
			if(data_token!=null) {
				if(token.equals(data_token)) {
					//有效的token
					chain.doFilter(request, response);
					return;
				}
			}

		}

		response.sendRedirect("http://localhost:8080/Serverlet01/Login.jsp");
*/






	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
