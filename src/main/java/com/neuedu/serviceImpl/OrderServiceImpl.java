package com.neuedu.serviceImpl;

import java.util.*;

import com.neuedu.MyBatis.MyBatisCartImpl;
import com.neuedu.MyBatis.MyBatisOrderImpl;
import com.neuedu.MyBatis.MyBatisOrderItemImpl;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;

import com.neuedu.dao.ProductDao;
import com.neuedu.daoImpl.CartDaoImpl2;

import com.neuedu.daoImpl.OrderDaoImpl2;

import com.neuedu.daoImpl.OrderItemDaoImpl2;
import com.neuedu.daoImpl.ProductDaoImpl2;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import com.neuedu.entity.Product;

import com.neuedu.input.Input;
import com.neuedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("myBatisOrderImpl")
	OrderDao orderDaoImpl;

	@Autowired
	@Qualifier("myBatisOrderItemImpl")
	OrderItemDao orderItemDao;

	@Autowired
	@Qualifier("myBatisCartImpl")
	CartDao CartDao ;

	@Autowired
	@Qualifier("myBatisProductImpl")
	ProductDao productDao  ;

	@Override
	public boolean addOrder() {
		// TODO Auto-generated method stub
		//�����ﳵ��Ϣ����������
		List<Cart> carts=CartDao.findAllCart();
		if(carts==null||carts.size()<=0) {
				return false;
			}
		Order order=createOrder();
		
		List<OrderItem> orderitems=new ArrayList<OrderItem>();
		for(int i=0;i<carts.size();i++) {
			Cart c=carts.get(i);
			OrderItem orderItemImpl=Input.createItem(order.getOrdersid(),order.getOrder_no(),c);
			if(orderItemImpl.getQuantity()<=c.getProduct().getStock()) {
				orderitems.add(orderItemImpl);
			}else {
				return false;
			}
		}

		order.setPayment(payment(orderitems));
		

		orderDaoImpl.addOrder(order);
		orderItemDao.addOrderItem(orderitems);
		//���㶩���ܼ۸�
		//����
		for(int i=0;i<carts.size();i++) {
			Cart cart=carts.get(i);
			Product p=cart.getProduct();
			
			int leftStock=p.getStock()-cart.getQuantity();
			p.setStock(leftStock);

		boolean issucc=	productDao.updateProductStock(p);
			if(issucc) {
				System.out.println("扣除成功");
			}else {
				return false;
			}
			
		}
		//��չ��ﳵ
		CartDao.clearCart();
		return true;
	}
		public static Order createOrder() {




		Order order=new Order();

		order.setOrder_no(System.currentTimeMillis());
		order.setCreate_time(System.currentTimeMillis());
		return order;
		
	}
	//�鿴����
	@Override
	public List<Order> seeOrder() {
		// TODO Auto-generated method stub
		return orderDaoImpl.findAll();
	}

	@Override
	public Order findOrderItemByOrderNo(long order_no) {
		return orderDaoImpl.findOrderItemByOrderNo(order_no);
	}



	//���㶩���۸�
	public double payment(List<OrderItem> orderitems) {
		double payments=0.0;
		for(int i=0;i<orderitems.size();i++){
			payments+=orderitems.get(i).getTotal_price();
		}
		return payments;
	}

	@Override
	public boolean updateOrder(long order_no, int status) {
		return orderDaoImpl.updateOrder(order_no, status);
	}

}
