package com.neuedu.serviceImpl;

import java.util.List;

import com.neuedu.MyBatis.MyBatisCartImpl;
import com.neuedu.dao.CartDao;
import com.neuedu.daoImpl.CartDaoImpl;
import com.neuedu.daoImpl.CartDaoImpl2;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
    @Qualifier("myBatisCartImpl")
	CartDao cartdao;



	public void setCartdao(CartDao cartdao) {
		this.cartdao = cartdao;
	}
	@Override




	public boolean addCart(Cart Cart) {
		// TODO Auto-generated method stub
		return cartdao.addCart(Cart);
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartdao.findAllCart();
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartdao.deleteCart(id);
	}

	@Override
	public boolean updateCartNum(int id,int  quantity) {
		// TODO Auto-generated method stub
		return cartdao.updateCartNum(id,quantity);
	}

	@Override
	public int idBySize() {
		// TODO Auto-generated method stub
		return cartdao.idBySize();
	}

	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		
		return cartdao.findById(id);
	}


}
