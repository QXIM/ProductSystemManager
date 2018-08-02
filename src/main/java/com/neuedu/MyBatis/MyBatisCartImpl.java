package com.neuedu.MyBatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisCartImpl implements CartDao {


    @Override
    public boolean addCart(Cart Cart) {
        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);
        cartdao.addCart(Cart);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public List<Cart> findAllCart() {

        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);
        List<Cart> list= cartdao.findAllCart();
        System.out.println(list);
        session.commit();
        session.close();


        return list;
    }

    @Override
    public boolean deleteCart(int id) {
         SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);
        cartdao.deleteCart(id);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateCartNum(int id, int quantity) {

        SqlSession session;
        SqlSessionFactory sessionMapper = MyBatis.getSqlSessionFactory();
        session=sessionMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);


        cartdao.updateCartNum(id,quantity);
        session.close();


        return true;
    }

    @Override
    public int idBySize() {
        return 0;
    }

    @Override
    public void clearCart() {
        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);
        cartdao.clearCart();
        session.commit();
        session.close();



    }

    @Override
    public Cart findById(int id) {
        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession(true);
        CartDao cartdao=session.getMapper(CartDao.class);
        Cart cart=cartdao.findById(id);
        session.commit();
        session.close();
        System.out.println(cart);
        return cart;
    }
}
