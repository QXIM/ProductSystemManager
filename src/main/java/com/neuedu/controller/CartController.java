package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/product/cart")
@Controller
public class CartController extends HttpServlet {
	@Autowired
	CartService cartservice;
	@Autowired
	ProductController productController;

	@Override
	public void init() throws ServletException {
		super.init();
		/*WebApplicationContext mWebApplicationContext
				= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		cartservice =(CartService) mWebApplicationContext.getBean("cartServiceImpl");
*/
SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());
}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*获取ioc容器*/
		System.out.println("-----");
		String _op=req.getParameter("operation");
		
		System.out.println("ѡ��");
		/*if(_op!=null&&!_op.equals(" ")) {*/
			
			if(_op.equals("1")) {
				addCart(req,resp);
			}else if(_op.equals("2")) {
				//getQuantity(req,resp);
			}else if(_op.equals("3")) {
				deleteCart(req,resp);
			}else if(_op.equals("4")) {
				updateCartNo(req, resp);
			}else if(_op.equals("5")) {
				updateCartNum(req, resp);
			}else if(_op.equals("6")) {
				
			}
		}
		
		
	//}


	private void getId(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


	/*private void  getQuantity(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("cid"));
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		updateCartNum(id,quantity );
	}*/


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void addCart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart Cart=new Cart();
		/*private int id;
		private long cart_no;
		private int quantity;
		private Product product;
		*/
		
		int pid=Integer.parseInt(req.getParameter("pid"));

		Product pro=productController.findproductById(pid);
		Cart.setProduct(pro);
		Cart.setCart_no(System.currentTimeMillis());
		addCart(Cart);
		System.out.println("�ӹ�");
		findAllCart(req,resp);
	
	}
	
	
	public boolean addCart(Cart cart) {
		return cartservice.addCart(cart);
	}

	public void findAllCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Cart> carts= cartservice.findAllCart();
		req.setAttribute("carts", carts);
		req.getRequestDispatcher("showcart.jsp").forward(req, resp);
		System.out.println(carts);
	}

	
	public void deleteCart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id=Integer.parseInt(req.getParameter("cid"));
			
			boolean result= cartservice.deleteCart(id);
			if(result) {
				findAllCart(req, resp);
				
			}
		}catch(NumberFormatException e) {
			e.getStackTrace();
		}
		
	}
	
	public void updateCartNo(HttpServletRequest req,HttpServletResponse resp ) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("cid"));
		
		Cart cart=cartservice.findById(id);
		req.setAttribute("cart", cart);
		
req.getRequestDispatcher("updatecart.jsp").forward(req, resp);		
	
		
		
	}
	
	
	
	public void updateCartNum(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
	try {
		
		int id=	Integer.parseInt(req.getParameter("cid"));
		int stock=	Integer.parseInt(req.getParameter("quantity"));
		cart.setId(id);
		
		cart.setQuantity(stock);
		
		 cartservice.updateCartNum(id,stock);
		 findAllCart(req,resp);
		
	}catch(NumberFormatException e) {
		e.getStackTrace();
	}
		
	
		
		
	
		
	}
	
	public int idBySize() {
		// TODO Auto-generated method stub
		return cartservice.idBySize();
	}
	
	
}
