package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
	
	boolean addOrder();
	List<Order> seeOrder();
	Order findOrderItemByOrderNo(long order_no);
	boolean updateOrder(long order_no,int status);

}
