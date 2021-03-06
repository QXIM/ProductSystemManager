package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Order;

import com.neuedu.entity.OrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;


@WebServlet("/product/order")
public class OrderController extends HttpServlet {
	@Autowired
	OrderService orderServiceImpl;
	/**
	 * 
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		/*WebApplicationContext mWebApplicationContext
				= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		orderServiceImpl =(OrderService) mWebApplicationContext.getBean("orderServiceImpl");
*/
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());


	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("order");
		String _op=req.getParameter("operation");
		
		
		if(_op!=null&&!_op.equals(" ")) {
			
			if(_op.equals("1")) {
				addOrder(req,resp);
				
			}else if(_op.equals("2")) {
				findAll(req,resp);
			}else if(_op.equals("3")) {
				deleteProduct(req, resp);
			}else if(_op.equals("4")) {
				findOrderItemByOrderNo(req, resp);
			}else if(_op.equals("5")) {
				findOrderByOrderNo(req, resp);
			} else if(_op.equals("6")) {
				updateOrder(req, resp);
			}else{


			}
		
	}
	}
	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);

	}
	public  void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result= orderServiceImpl.addOrder();
		if(result) {
			System.out.println("����������");
			findAll(req, resp);
		}
	}
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Order> order= orderServiceImpl.seeOrder();
		req.setAttribute("order", order);
		req.getRequestDispatcher("showorder.jsp").forward(req, resp);
		
	}

	public void findOrderItemByOrderNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num =req.getParameter("order_no");
		Long orderno=Long.parseLong(num);
		Order order=orderServiceImpl.findOrderItemByOrderNo(orderno);
		List<OrderItem> orderItemList=order.getOrderItemList();
		req.setAttribute("orderItemList", orderItemList);
		req.getRequestDispatcher("showorderitem.jsp").forward(req, resp);

	}

	public void findOrderByOrderNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num =req.getParameter("order_no");
        Long orderno=Long.parseLong(num);
		Order updateorder=orderServiceImpl.findOrderItemByOrderNo(orderno);
		req.setAttribute("updateorder", updateorder);
		req.getRequestDispatcher("updateorderstatus.jsp").forward(req, resp);

	}


	public void  updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String _order_no =req.getParameter("order_no");
		String _status =req.getParameter("status");
        Long order_no=Long.parseLong(_order_no);
		int status=Integer.parseInt(_status);
		boolean result=orderServiceImpl.updateOrder(order_no,status);
		System.out.println(result);
		findAll(req, resp);
	}

}
