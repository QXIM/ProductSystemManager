package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.CategoryService;
import com.neuedu.serviceImpl.CategoryServiceImpl;


@WebServlet("/product/category")
public class CategoryController extends HttpServlet {
	CategoryService CategoryService=new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("-----");
		String _op=req.getParameter("operation");
		
		
		if(_op!=null&&!_op.equals(" ")) {
			
			if(_op.equals("1")) {
				addCategory(req,resp);
				
			}else if(_op.equals("2")) {
				findAll(req,resp);
			}else if(_op.equals("3")) {
				deleteCategory(req,resp);
			}else if(_op.equals("4")) {
				updateById(req,resp);
			}else if(_op.equals("5")) {
				updateCategory(req,resp);
			}else  {
				
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
	
	public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	// TODO Auto-generated method stub
		
	Category category=new Category();
	String name=req.getParameter("name");
	
	try {
		
		int parent_id=Integer.parseInt(req.getParameter("parent_id"));
		int status=Integer.parseInt(req.getParameter("status"));
		int sort_order=Integer.parseInt(req.getParameter("sort_order"));
		
		category.setName(name);
		category.setParent_id(parent_id);
		category.setStatus(status);
		category.setSort_order(sort_order);
		
		addCategory(category);
		
		jump(req, resp);
		

		}catch(NumberFormatException e) {
		e.getStackTrace();
	}
	
		
		
		
		
	}






public boolean addCategory(Category category) {
	
	// TODO Auto-generated method stub
	
	return  CategoryService.addCategory(category);
	
}


	




	
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int pageNo=	Integer.parseInt(req.getParameter("pageNo"));
		
		PageModel<Category> PageModel=CategoryService.findAll(pageNo, 5);
		
		System.out.println(PageModel);
		System.out.println("1");
		req.setAttribute("PageModel", PageModel);
		req.getRequestDispatcher("showcategoryByPage.jsp").forward(req, resp);		
		System.out.println("1");
		
		
		
	}

public void jump(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageModel<Category> PageModel=CategoryService.findAll(1, 5);
		
		req.setAttribute("PageModel", PageModel);
		req.getRequestDispatcher("showcategoryByPage.jsp").forward(req, resp);		
		
	}
	public void  deleteCategory(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(req.getParameter("_id"));
		boolean result= CategoryService.deleteCategory(id);
		if(result) {
			System.out.println("ɾ���ɹ�");
			jump(req, resp);
						}
		
	} 
	public void updateById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		int id=	Integer.parseInt(req.getParameter("_id"));
		
		Category category=CategoryService.findcategoryById(id);
		req.setAttribute("category", category);
req.getRequestDispatcher("updatecategory.jsp").forward(req, resp);		
	}
	public void updateCategory(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Category category=new Category();
		
		String name=req.getParameter("name");
		
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			int parent_id=Integer.parseInt(req.getParameter("parent_id"));
			int status=Integer.parseInt(req.getParameter("status"));
			int sort_order=Integer.parseInt(req.getParameter("sort_order"));
			category.setId(id);
			category.setName(name);
			category.setParent_id(parent_id);
			category.setSort_order(sort_order);
			category.setStatus(status);
			
			
			
			CategoryService.updateCategory(category);
			
		
		System.out.println("�޸ĳɹ�");
		
		jump(req, resp);
				}catch(NumberFormatException e) {
			e.getStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
