package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.OrderItem;
import com.neuedu.service.OrderItemService;
import com.neuedu.serviceImpl.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
@WebServlet("/product/orderitem")
public class OrderItemController extends HttpServlet{
@Autowired
	OrderItemService orderItemServiceImpl;
	@Override
	public void init() throws ServletException {
		super.init();
		/*WebApplicationContext mWebApplicationContext
				= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		orderItemServiceImpl =(OrderItemService) mWebApplicationContext.getBean("orderItemServiceImpl");
*/
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("order");
		String _op=req.getParameter("operation");
		
		
		if(_op!=null&&!_op.equals(" ")) {
			
			if(_op.equals("1")) {
				findAll(req,resp);
			}
			else{
				
			}
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123123123");
		List<OrderItem> orderitems=orderItemServiceImpl.seeOrderItem();
		
		req.setAttribute("orderitems", orderitems);
		System.out.println(orderitems);
		req.getRequestDispatcher("showorderitem.jsp").forward(req, resp);
	
	}
	
	
}
