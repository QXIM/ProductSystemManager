package com.neuedu.MyBatis;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.OrderItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MyBatisOrderItemImpl implements OrderItemDao {
    @Override
    public boolean addOrderItem(List<OrderItem> orderItem) {
        Integer result=0;
        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession(true);
        OrderItemDao orderItemDao=session.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItem(orderItem);
       return false;








        
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
}
