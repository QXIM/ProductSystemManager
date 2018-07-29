package com.neuedu.MyBatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
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

public class MyBatisProductImpl implements ProductDao {
    @Override
    public boolean addProduct(Product product) {

        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);


        String pname=product.getPname();
        String detail=product.getDetail();
        Integer stock=product.getStock();
        Double price=product.getPrice();
        String image=product.getImage();
        Integer result=session.update("com.neuedu.entity.Product.addProduct",product);
        MyBatis.close(session);
        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);

        Integer result=session.delete("com.neuedu.entity.Product.deleteProduct",id);
        MyBatis.close(session);
        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();

        session = sqlMapper.openSession(true);

        Integer productid=product.getProductid();
        String pname=product.getPname();
        String detail=product.getDetail();
        Integer stock=product.getStock();
        Double price=product.getPrice();
        String image=product.getImage();
        Integer result=session.update("com.neuedu.entity.Product.updateProduct",product);
        MyBatis.close(session);
        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }






    }

    @Override
    public List<Product> findDetailById(int id) {
        return null;
    }

    @Override
    public Product findproductById(int id) {

        SqlSession session;
        SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();


        Product p= session.selectOne("com.neuedu.entity.Product.findproductById",id);




        System.out.println(p);
        MyBatis.close(session);

        return p;



    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {

        SqlSession session;
       SqlSessionFactory sqlMapper=MyBatis.getSqlSessionFactory();
        session = sqlMapper.openSession();

        Integer totalcount=session.selectOne("com.neuedu.entity.Product.findProductPageCount");

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> p= session.selectList("com.neuedu.entity.Product.findProductPageContent",map);

        PageModel<Product> pageModel= new PageModel<Product>();
        pageModel.setTotalPage(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
        pageModel.setDate(p);


        System.out.println(pageModel);
        MyBatis.close(session);

        return pageModel;



    }
}
