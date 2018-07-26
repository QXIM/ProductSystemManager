package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {
	
	//��
		boolean addProduct(Product product);
		//�鿴
		List<Product> findAll();
		//ɾ��
		boolean deleteProduct(int id);
		//�޸�
		boolean updateProduct(Product product);
		//id����ϸ
		List<Product> findDetailById(int id);
		Product findproductById(int id);
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
	
	
		
}
