package com.neuedu.dao;





import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryDao {
	
	//��
	boolean addCategory(Category category);
	//�鿴
	PageModel<Category> findAll(int pageNo, int pageSize);
	//ɾ��
	boolean deleteCategory(int id);
	//�޸�
	boolean updateCategory(Category category);
	//
	Category findcategoryById(int id);
	

}
