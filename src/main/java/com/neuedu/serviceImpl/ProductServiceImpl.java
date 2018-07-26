package com.neuedu.serviceImpl;

import java.util.List;

import com.neuedu.dao.ProductDao;

import com.neuedu.daoImpl.ProductDaoImpl2;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productdao=new ProductDaoImpl2();
	
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.addProduct(product);
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productdao.deleteProduct(id);
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.updateProduct(product);
	}

	

	@Override
	public List<Product> findDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findproductById(int id) {
		// TODO Auto-generated method stub
		return productdao.findproductById(id);
	}

	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productdao.findProductByPage(pageNo, pageSize);
	}

}
