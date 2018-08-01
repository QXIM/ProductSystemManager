package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.serviceImpl.ProductServiceImpl;

@WebServlet("/product/product")
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productservice=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("-----");
		String _op=req.getParameter("operation");
		
		
		if(_op!=null&&!_op.equals(" ")) {
			
			if(_op.equals("1")) {
				addProduct(req,resp);
				
			}else if(_op.equals("2")) {
				/*findAll(req,resp);
				
				req.getRequestDispatcher("showproduct.jsp").forward(req, resp);
				*/
			}else if(_op.equals("3")) {
				updateById(req,resp);
			}else if(_op.equals("4")) {
				deleteProduct(req, resp);
			}else if(_op.equals("5")) {
				updateProduct(req,resp);
				
			}else if(_op.equals("6")) {
				
			}
			else if(_op.equals("7")) {
				findPageNo(req, resp);
	req.getRequestDispatcher("showproductByPage.jsp").forward(req, resp);		
			}
		}
	}
	private void findPageNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pageNo=	Integer.parseInt(req.getParameter("pageNo"));
		System.out.println(pageNo);
		PageModel<Product> PageModel=productservice.findProductByPage(pageNo, 3);
		System.out.println(PageModel);
		req.setAttribute("PageModel", PageModel);
		req.getRequestDispatcher("showproductByPage.jsp").forward(req, resp);		
	}
	//ҳ����ת
	public void jump(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageModel<Product> PageModel=productservice.findProductByPage(1, 3);
		
		req.setAttribute("PageModel", PageModel);
		req.getRequestDispatcher("showproductByPage.jsp").forward(req, resp);		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
	
	
	
	public void addProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Product product=new Product();
		String name=req.getParameter("pname");
		String detail=req.getParameter("detail");
		String image=req.getParameter("image");
		String rule=req.getParameter("rule");
		try {
			double price=Double.parseDouble(req.getParameter("price"));
			int stock=Integer.parseInt(req.getParameter("stock"));
			
			product.setName(name);
			product.setDetail(detail);
			product.setPrice(price);
			product.setImage(image);
			product.setStock(stock);
			product.setRule(rule);
			
			
			addProduct(product);
			jump(req, resp);
		
			}catch(NumberFormatException e) {
			e.getStackTrace();
		}
		System.out.println("-----------");
		
	}
	
		//��
		public boolean addProduct(Product product) {
			return productservice.addProduct(product);
			}
		//�鿴
		/*public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			List<Product> products=productservice.findAll();
	req.setAttribute("products", products);
req.getRequestDispatcher("showproduct.jsp").forward(req, resp);		
		}*/
		//ɾ��
		public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int id=Integer.parseInt(req.getParameter("_id"));
			boolean result= productservice.deleteProduct(id);
			if(result) {
				System.out.println("ɾ���ɹ�");
				jump(req, resp);
							}
			
		}
		//�޸�
		
		public void updateById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
			
			int id=	Integer.parseInt(req.getParameter("_id"));
			
			Product product=findproductById(id);
			req.setAttribute("product", product);
	req.getRequestDispatcher("updateproduct.jsp").forward(req, resp);		
		}
		
		public void updateProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
			
			
			Product product=new Product();
			
			String name=req.getParameter("pname");
			String detail=req.getParameter("detail");
			String image=req.getParameter("image");
			String rule=req.getParameter("rule");
			try {
				int id=Integer.parseInt(req.getParameter("id"));
				double price=Double.parseDouble(req.getParameter("price"));
				int stock=Integer.parseInt(req.getParameter("stock"));
				product.setId(id);
				product.setName(name);
				product.setDetail(detail);
				product.setPrice(price);
				product.setImage(image);
				product.setStock(stock);
				product.setRule(rule);
				
				productservice.updateProduct(product);
				
			
			System.out.println("�޸ĳɹ�");
			
			jump(req, resp);
					}catch(NumberFormatException e) {
				e.getStackTrace();
			}
			
		}
				
		public Product findproductById(int id) {
			// TODO Auto-generated method stub
			return productservice.findproductById(id);
		}
	
	//��ҳ��ѯ
		
	
		
		
		
}
