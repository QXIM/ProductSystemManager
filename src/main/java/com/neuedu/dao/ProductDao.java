package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

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
	
	//��ҳ�鿴����
	//pageno��ȡ�ڼ�ҳ
	//pagesize ÿҳ����������
	
	public PageModel<Product> findProductByPage(int pageNo, int pageSize);

	public boolean updateProductStock(Product product);
	
	
}
