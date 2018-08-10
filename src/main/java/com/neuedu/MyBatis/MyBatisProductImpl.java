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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MyBatisProductImpl implements ProductDao {
    @Autowired
    SqlSession sqlSession;


    @Override
    public boolean addProduct(Product product) {


        String pname = product.getPname();
        String detail = product.getDetail();
        Integer stock = product.getStock();
        Double price = product.getPrice();
        String image = product.getImage();
        Integer result = sqlSession.update("com.neuedu.entity.Product.addProduct", product);

        System.out.println(result);
        if (result == 1) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {

        Integer result = sqlSession.delete("com.neuedu.entity.Product.deleteProduct", id);

        System.out.println(result);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {


        Integer productid = product.getProductid();
        String pname = product.getPname();
        String detail = product.getDetail();
        Integer stock = product.getStock();
        Double price = product.getPrice();
        String image = product.getImage();
        Integer result = sqlSession.update("com.neuedu.entity.Product.updateProduct", product);

        System.out.println(result);
        if (result == 1) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public List<Product> findDetailById(int id) {


        return null;
    }

    @Override
    public Product findproductById(int id) {


        Product p = sqlSession.selectOne("com.neuedu.entity.Product.findproductById", id);


        System.out.println(p);


        return p;


    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {


        Integer totalcount = sqlSession.selectOne("com.neuedu.entity.Product.findProductPageCount");

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("offset", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Product> p = sqlSession.selectList("com.neuedu.entity.Product.findProductPageContent", map);

        PageModel<Product> pageModel = new PageModel<Product>();
        pageModel.setTotalPage(totalcount % pageSize == 0 ? totalcount / pageSize : totalcount / pageSize + 1);
        pageModel.setDate(p);


        System.out.println(pageModel);


        return pageModel;


    }

    public boolean updateProductStock(Product product) {


        sqlSession.delete("com.neuedu.entity.Product.updateProductStock",product);


        return true;
    }


}
