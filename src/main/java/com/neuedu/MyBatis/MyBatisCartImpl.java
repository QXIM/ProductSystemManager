package com.neuedu.MyBatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MyBatisCartImpl implements CartDao {

@Autowired
SqlSession sqlSession;
    @Override
    public boolean addCart(Cart Cart) {

        CartDao cartdao=sqlSession.getMapper(CartDao.class);
        cartdao.addCart(Cart);

        return true;
    }

    @Override
    public List<Cart> findAllCart() {


        CartDao cartdao=sqlSession.getMapper(CartDao.class);
        List<Cart> list= cartdao.findAllCart();
        System.out.println(list);



        return list;
    }

    @Override
    public boolean deleteCart(int id) {

        CartDao cartdao=sqlSession.getMapper(CartDao.class);
        cartdao.deleteCart(id);

        return true;
    }

    @Override
    public boolean updateCartNum(int id, int quantity) {

        CartDao cartdao=sqlSession.getMapper(CartDao.class);


        cartdao.updateCartNum(id,quantity);



        return true;
    }

    @Override
    public int idBySize() {
        return 0;
    }

    @Override
    public void clearCart() {

        CartDao cartdao=sqlSession.getMapper(CartDao.class);
        cartdao.clearCart();



    }

    @Override
    public Cart findById(int id) {

        CartDao cartdao=sqlSession.getMapper(CartDao.class);
        Cart cart=cartdao.findById(id);

        System.out.println(cart);
        return cart;
    }
}
