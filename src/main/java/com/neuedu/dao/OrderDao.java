package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Order;



public interface OrderDao {
	

		//��
		boolean addOrder(Order order);
		//�鿴
		List<Order> findAll();
		//ɾ��
		boolean deleteOrder(int id);
		//�޸�
		boolean updateOrder(Order Cart);
	
		int idBySize();
		

}
