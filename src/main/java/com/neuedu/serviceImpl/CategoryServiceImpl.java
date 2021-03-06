package com.neuedu.serviceImpl;

import java.util.List;

import com.neuedu.MyBatis.MyBatisCategoryImpl;
import com.neuedu.dao.CategoryDao;
import com.neuedu.daoImpl.CategoryDaoImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier("myBatisCategoryImpl")
	CategoryDao CategoryDao ;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.CategoryDao = categoryDao;
	}

	@Override
	public boolean addCategory(Category category) {
		
		// TODO Auto-generated method stub
		
		return CategoryDao.addCategory(category);
	}

	

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return CategoryDao.deleteCategory(id);
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return CategoryDao.updateCategory(category);
	}

	@Override
	public PageModel<Category> findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return CategoryDao.findAll(pageNo, pageSize);
	}



	@Override
	public Category findcategoryById(int id) {
		// TODO Auto-generated method stub
		return CategoryDao.findcategoryById(id);	
				}

}
