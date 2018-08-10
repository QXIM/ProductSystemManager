package com.neuedu.serviceImpl;

import java.util.List;

import com.neuedu.MyBatis.MyBatisProductImpl;
import com.neuedu.dao.ProductDao;

import com.neuedu.daoImpl.ProductDaoImpl2;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
	@Qualifier("myBatisProductImpl")
	ProductDao productdao;

	public void setProductdao(ProductDao productdao) {
		this.productdao = productdao;
	}

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
