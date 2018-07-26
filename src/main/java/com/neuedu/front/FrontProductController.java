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
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class FrontProductController
 */
@WebServlet("/com/neuedu/front/product.do")
public class FrontProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String method=request.getParameter("method");
		Product pro=new Product();
		ProductService pros=new ProductServiceImpl();
		List<Product> list=pros.findAll();
		System.out.println(list);
		Gson gson=new Gson();
		String json=gson.toJson(list); 
		PrintWriter write=response.getWriter();
		write.println(method+"("+json+")");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
	
	
	
	
}
