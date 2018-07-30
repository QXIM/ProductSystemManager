package com.neuedu.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;

import com.neuedu.serviceImpl.CartServiceImpl;


/**
 * Servlet implementation class FrontProductController
 */
@WebServlet("/com/neuedu/front/cart.do")
public class FrontCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String method=request.getParameter("method");
		
		
		CartService carts=new CartServiceImpl();
		List<Cart> list=carts.findAllCart();
		Gson gson=new Gson();
		String json=gson.toJson(list); 
		PrintWriter write=response.getWriter();
		write.println(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
	
	
	
	
}
