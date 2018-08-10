package com.neuedu.dao;

import java.util.List;


import com.neuedu.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {
	
	//��
		boolean addCart(Cart Cart);
		//�鿴
		List<Cart> findAllCart();
		//ɾ��
		boolean deleteCart(int id);
		//�޸�
		boolean updateCartNum(int id, int quantity);
	
		int idBySize();
		
		void clearCart();
		
		Cart findById(int id);
		
		
	
}
