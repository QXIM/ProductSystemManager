package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.OrderItem;

public interface OrderItemDao {
	
			//��
			boolean addOrderItem(List<OrderItem> orderItem);
			//�鿴
			List<OrderItem> findAll();
			//ɾ��
			boolean deleteOrderItem(int id);
			//�޸�
			boolean updateOrderItem(OrderItem orderItem);
		
			int idBySize();
	
	
	
}
