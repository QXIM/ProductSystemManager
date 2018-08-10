package com.neuedu.MyBatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MyBatisOrderImpl implements OrderDao {
    @Autowired
    SqlSession sqlSession;

    @Override

    public boolean addOrder(Order order) {


        Long order_no=order.getOrder_no();
        Integer user_id=order.getUser_id();
        Double payment=order.getPayment();
        String payment_type=order.getPayment_type();
        Integer postage=order.getPostage();
        Integer shipping_id=order.getShipping_id();
       Integer status= order.getStatus();
        Long create_time=order.getCreate_time();



        OrderDao orderDao= sqlSession.getMapper(OrderDao.class);
        orderDao.addOrder(order);

        return true;


    }

    @Override
    public List<Order> findAll() {

        OrderDao orderDao=sqlSession.getMapper(OrderDao.class);
        List<Order> orderList=orderDao.findAll();
        System.out.println(orderList);

         return orderList;

    }

    @Override
    public boolean deleteOrder(int id) {
        return false;
    }

    @Override
    public boolean updateOrder(long order_no,int status) {
        System.out.println(order_no);
        System.out.println(status);
         OrderDao orderDao=sqlSession.getMapper(OrderDao.class);
        boolean re=orderDao.updateOrder(order_no,status);
        if (re){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public int idBySize() {
        return 0;
    }

    @Override
    public Order findOrderItemByOrderNo(long order_no) {



        OrderDao orderDao=sqlSession.getMapper(OrderDao.class);
       Order order= orderDao.findOrderItemByOrderNo(order_no);
        System.out.println(order);


        return order;



    }
}
