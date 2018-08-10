package com.neuedu.MyBatis;


import com.neuedu.dao.UserDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MyBatisloginImpl implements UserDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User checkUser(String name, String password) {

        Map<String,String> map=new HashMap<String,String>();
        map.put("username",name);
        map.put("password",password);

        Object o= sqlSession.selectOne("com.neuedu.entity.User.checkUser",map);
        System.out.println(o);

        if(o instanceof User){

           return (User)o;

        }else{
        return null;
        }

    }

    @Override
    public void updateTokenByAccountid(String token, User user) {




        Integer accountid=user.getAccountid();
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("token",token);
        map.put("accountid",accountid);

        Integer o= sqlSession.update("com.neuedu.entity.User.updateTokenByAccountid",map);
        System.out.println(o);




    }

    @Override
    public String findTokenByAccountid(int Accountid) {

        String  o=sqlSession.selectOne("com.neuedu.entity.User.findTokenByAccountid",Accountid);

        return o;
    }
}
