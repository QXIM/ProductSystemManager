package com.neuedu.serviceImpl;

import java.util.List;

import com.neuedu.MyBatis.MyBatisOrderItemImpl;
import com.neuedu.dao.OrderItemDao;

import com.neuedu.daoImpl.OrderItemDaoImpl2;
import com.neuedu.entity.OrderItem;
import com.neuedu.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
			@Qualifier("myBatisOrderItemImpl")
	OrderItemDao orderItemDaoImpl;
	@Override
	public List<OrderItem> seeOrderItem() {
		// TODO Auto-generated method stub
		return orderItemDaoImpl.findAll();
	}

}
