package com.neuedu.MyBatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisOrderImpl implements OrderDao {
    @Override

    public boolean addOrder(Order order) {

        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);

        Long order_no=order.getOrder_no();
        Integer user_id=order.getUser_id();
        Double payment=order.getPayment();
        String payment_type=order.getPayment_type();
        Integer postage=order.getPostage();
        Integer shipping_id=order.getShipping_id();
       Integer status= order.getStatus();
        Long create_time=order.getCreate_time();



        OrderDao orderDao= session.getMapper(OrderDao.class);
        orderDao.addOrder(order);
        MyBatis.close(session);
        return true;


    }

    @Override
    public List<Order> findAll() {
        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();
        OrderDao orderDao=session.getMapper(OrderDao.class);
        List<Order> orderList=orderDao.findAll();
        System.out.println(orderList);
        MyBatis.close(session);
         return orderList;

    }

    @Override
    public boolean deleteOrder(int id) {
        return false;
    }

    @Override
    public boolean updateOrder(Order Cart) {
        return false;
    }

    @Override
    public int idBySize() {
        return 0;
    }

    @Override
    public Order findOrderItemByOrderNo(long order_no) {

        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();

        OrderDao orderDao=session.getMapper(OrderDao.class);
       Order order= orderDao.findOrderItemByOrderNo(order_no);
        System.out.println(order);
        MyBatis.close(session);

        return order;



    }
}
