package com.neuedu.MyBatis;


import com.neuedu.dao.UserDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisloginImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User checkUser(String name, String password) {
        SqlSession session;
        SqlSessionFactory sqlMapper= MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();

        Map<String,String> map=new HashMap<String,String>();
        map.put("username",name);
        map.put("password",password);

        Object o= session.selectOne("com.neuedu.entity.User.checkUser",map);
        System.out.println(o);
        MyBatis.close(session);
        if(o instanceof User){

           return (User)o;

        }else{
        return null;
        }

    }

    @Override
    public void updateTokenByAccountid(String token, User user) {

    }

    @Override
    public String findTokenByAccountid(int Accountid) {
        return null;
    }
}
