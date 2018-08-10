package com.neuedu.Aspect;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AopDaoImpl implements AopDao {

    @Autowired
    SqlSession sqlSession;
    public Object addAspect(LogBean str){
        System.out.println("Dao="+str);
        AopDao aopDao=sqlSession.getMapper(AopDao.class);
        Object re=aopDao.addAspect(str);
        System.out.println("结果"+re);
        return re;


    }



}
