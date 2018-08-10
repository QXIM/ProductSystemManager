package com.neuedu.MyBatis;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisOrderItemImpl implements OrderItemDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public boolean addOrderItem(List<OrderItem> orderItem) {

        OrderItemDao orderItemDao=sqlSession.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItem(orderItem);
       return true;
    }

    @Override
    public List<OrderItem> findAll() {
        return null;
    }

    @Override
    public boolean deleteOrderItem(int id) {
        return false;
    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) {
        return false;
    }

    @Override
    public int idBySize() {
        return 0;
    }


    public List<OrderItem> findOrderItemByOrderNo(Long order_no){

        OrderItemDao orderItemDao=sqlSession.getMapper(OrderItemDao.class);
        List<OrderItem> list= orderItemDao.findOrderItemByOrderNo(order_no);

            return list;
    }

}




