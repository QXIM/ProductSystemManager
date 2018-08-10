package com.neuedu.daoImpl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.data.ProductData;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
	ProductData productdate =new ProductData();
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productdate.products.add(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productdate.products;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		List<Product> p=productdate.products;
		for(int i=0;i<p.size();i++) {
			Product products=p.get(i);
			int _id=products.getProductid();
			if(_id==id) {
				
				p.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		List<Product> p=productdate.products;
		for(int i=0;i<p.size();i++) {
			Product products=p.get(i);
			int _id=products.getProductid();
			if(_id==product.getProductid()) {
				p.set(i, product);
				return true;
			}
		}
		return false;
	
	}

	@Override
	public List<Product> findDetailById(int id) {
		// TODO Auto-generated method stub
		List<Product> p=productdate.products;
		for(int i=0;i<p.size();i++) {
			Product products=p.get(i);
			int _id=products.getProductid();
			if(_id==id) { 
				return p;
				
			}
		}
		return null;
	}

	@Override
	public Product findproductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProductStock(Product product) {
		return false;
	}

}
