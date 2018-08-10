package com.neuedu.transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionalDaoImpl implements TransactionalDao {

    @Autowired
    SqlSession sqlSession;
    @Override
    public void updateMoney(String name, int money) {

        TransactionalDao transactionalDao  =  sqlSession.getMapper(TransactionalDao.class);
        transactionalDao.updateMoney(name,money);

    }
}
