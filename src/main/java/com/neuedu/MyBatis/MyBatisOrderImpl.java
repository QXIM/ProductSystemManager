package com.neuedu.MyBatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.Order;
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




        Integer result=session.insert("com.neuedu.entity.Order.addOrder",order);
        MyBatis.close(session);
        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public List<Order> findAll() {
        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();

        List<Order> p= session.selectList("com.neuedu.entity.Order.findAll");

        System.out.println(p);
        MyBatis.close(session);

        return p;

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
}
