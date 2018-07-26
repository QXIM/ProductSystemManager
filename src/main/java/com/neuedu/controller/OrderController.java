package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Order;

import com.neuedu.service.OrderService;
import com.neuedu.serviceImpl.OrderServiceImpl;


@WebServlet("/product/order")
public class OrderController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderService orderServiceImpl=new OrderServiceImpl();
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
}
