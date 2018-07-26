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

@WebServlet("/product/orderitem")
public class OrderItemController extends HttpServlet{
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
	OrderItemService orderItemServiceImpl=new OrderItemServiceImpl();
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123123123");
		List<OrderItem> orderitems=orderItemServiceImpl.seeOrderItem();
		
		req.setAttribute("orderitems", orderitems);
		System.out.println(orderitems);
		req.getRequestDispatcher("showorderitem.jsp").forward(req, resp);
	
	}
	
	
}
