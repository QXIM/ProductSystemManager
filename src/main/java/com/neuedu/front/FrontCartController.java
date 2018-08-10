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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


/**
 * Servlet implementation class FrontProductController
 */
@WebServlet("/com/neuedu/front/cart.do")
@Service
public class FrontCartController extends HttpServlet {

	@Autowired
	CartService cartService;

	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());


    }

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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if (method!=null&&!method.equals("")){

			if (method.equals("findCart")){
				findCart(request,response);
			}else if (method.equals("changeNum")){
				changeNum(request,response);
			}else if (method.equals("deleteCart")){
				deleteCart(request,response);
			}



		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	public void findCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/*List<Cart> list=cartService.findAllCart();
		Gson gson=new Gson();
		String json=gson.toJson(list);
		PrintWriter write=response.getWriter();
		write.println(json);*/

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("========find=========");
         List<Cart> list=cartService.findAllCart();
        String callback = request.getParameter("callback");
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        String result = gson.toJson(list);
        System.out.println(result);
        pw.println(callback+"("+result+")");



    }
	public void changeNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int id=Integer.parseInt(request.getParameter("id"));
		cartService.updateCartNum(id, quantity);
		findCart(request,response);

	}

	public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {


		int id=Integer.parseInt(request.getParameter("cartid"));
		boolean re=cartService.deleteCart(id);

		System.out.println(re);
		response.sendRedirect("http://127.0.0.1:8020/NBA_store/shoping_cart.html");

	}
	
	
	
	
	
	
	
	
	
}
