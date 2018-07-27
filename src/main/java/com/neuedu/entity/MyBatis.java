package com.neuedu.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatis {
        static SqlSessionFactory sqlMapper=null;
    static {


    String resource = "MyBatis-config.xml";
    Reader reader = null;

    try {
        reader = Resources.getResourceAsReader(resource);
       sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);

    } catch (IOException e) {
// TODO Auto-generated catch block
        e.printStackTrace();
    }

    }

    public  static  SqlSessionFactory  getSqlSessionFactory(){
            return sqlMapper;
    }
    public  static void close(SqlSession session){
        session.close();
    }


}
