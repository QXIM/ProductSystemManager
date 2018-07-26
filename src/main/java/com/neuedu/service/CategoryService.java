package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CategoryService {
	
	//��
		boolean addCategory(Category category);
		//�鿴
		PageModel<Category> findAll(int pageNo, int pageSize);
		//ɾ��
		boolean deleteCategory(int id);
		//�޸�
		boolean updateCategory(Category category);
		Category findcategoryById(int id);
	
}
