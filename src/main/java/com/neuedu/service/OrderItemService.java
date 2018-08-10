package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.OrderItem;
import org.springframework.stereotype.Service;

@Service
public interface OrderItemService {
	
	List<OrderItem> seeOrderItem();
	
}
