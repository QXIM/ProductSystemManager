package com.neuedu.MyBatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

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
        return false;
    }

    @Override
    public boolean updateCartNum(int id, int quantity) {
        return false;
    }

    @Override
    public int idBySize() {
        return 0;
    }

    @Override
    public void clearCart() {

    }

    @Override
    public Cart findById(int id) {
        return null;
    }
}
