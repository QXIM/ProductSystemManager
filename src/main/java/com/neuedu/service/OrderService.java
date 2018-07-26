package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Order;

public interface OrderService {
	
	boolean addOrder();
	List<Order> seeOrder();

}
