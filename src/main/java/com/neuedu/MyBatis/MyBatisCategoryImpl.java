package com.neuedu.MyBatis;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.MyBatis;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MyBatisCategoryImpl implements CategoryDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public boolean addCategory(Category category) {


        String name=category.getName();
        Integer parent_id=category.getParent_id();
        Integer sort_order=category.getSort_order();
        Integer status=category.getStatus();

        Long create_time=category.getCreate_time();
        Long update_time=category.getUpdate_time();

        Integer result=sqlSession.update("com.neuedu.entity.Category.addCategory",category);

        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public PageModel<Category> findAll(int pageNo, int pageSize) {



        Integer totalcount=sqlSession.selectOne("com.neuedu.entity.Category.findCategoryPageCount");

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Category> p= sqlSession.selectList("com.neuedu.entity.Category.findCategoryPageContent",map);

        PageModel<Category> pageModel= new PageModel<Category>();
        pageModel.setTotalPage(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
        pageModel.setDate(p);


        System.out.println(pageModel);


        return pageModel;








    }

    @Override
    public boolean deleteCategory(int id) {



        Integer result=sqlSession.delete("com.neuedu.entity.Category.deleteCategory",id);

        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }




    }

    @Override
    public boolean updateCategory(Category category) {


        Integer categoryid=category.getCategoryid();
        String name=category.getName();
        Integer parent_id=category.getParent_id();
        Integer sort_order=category.getSort_order();
        Integer status=category.getStatus();

        Long create_time=category.getCreate_time();
        Long update_time=category.getUpdate_time();
        Integer result=sqlSession.update("com.neuedu.entity.Category.updateCategory",category);

        System.out.println(result);
        if(result==1){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public Category findcategoryById(int id) {

        Category category=sqlSession.selectOne("com.neuedu.entity.Category.findcategoryById",id);


        return category;
    }
}
