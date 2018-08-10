package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	

		//��
		boolean addOrder(Order order);
		//�鿴
		List<Order> findAll();
		//ɾ��
		boolean deleteOrder(int id);
		//�޸�
		boolean updateOrder(long order_no,int status);
	
		int idBySize();

	Order findOrderItemByOrderNo(long order_no);


}
