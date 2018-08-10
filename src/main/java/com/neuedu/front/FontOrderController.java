package com.neuedu.front;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import com.neuedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/com/neuedu/front/order.do")
public class FontOrderController extends HttpServlet {
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
		/*if(_op!=null&&!_op.equals(" ")) {
			
			if(_op.equals("1")) {
				addOrder(req,resp);
				
			}else if(_op.equals("2")) {
				findAll(req,resp);
			}else if(_op.equals("3")) {
				deleteProduct(req, resp);
			}else if(_op.equals("4")) {
				findOrderItemByOrderNo(req, resp);
			}else{
			}
	}*/
		String _op=req.getParameter("method");
		if (_op.equals("addOrder")){
			addOrder(req, resp);
		}else if (_op.equals("findAll")){
			findAll(req, resp);
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

		/*String []checkbox= req.getParameterValues("checkbox");

		for (int i=0;i<checkbox.length;i++){

			String id=checkbox[i];
			System.out.println(id);
		}*/



		boolean result= orderServiceImpl.addOrder();
		if(result) {
			System.out.println("����������");
			findAll(req, resp);
		}
	}
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("========find=========");
		List<Order> order= orderServiceImpl.seeOrder();
		String callback = request.getParameter("callback");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String result = gson.toJson(order);
		System.out.println(result);
		pw.println(callback+"("+result+")");


		/*List<Order> order= orderServiceImpl.seeOrder();
		req.setAttribute("order", order);
		req.getRequestDispatcher("showorder.jsp").forward(req, resp);*/
		
	}

	public void findOrderItemByOrderNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num =req.getParameter("order_no");
		Long orderno=Long.parseLong(num);
		Order order=orderServiceImpl.findOrderItemByOrderNo(orderno);
		List<OrderItem> orderItemList=order.getOrderItemList();
		req.setAttribute("orderItemList", orderItemList);
		req.getRequestDispatcher("showorderitem.jsp").forward(req, resp);

	}

	public void  updateOrder(HttpServletRequest req, HttpServletResponse resp){


		String _id =req.getParameter("id");
		String _status =req.getParameter("status");
		int id=Integer.parseInt(_id);
		int status=Integer.parseInt(_status);
		boolean result=orderServiceImpl.updateOrder(id,status);
		System.out.println(result);
	}



}
