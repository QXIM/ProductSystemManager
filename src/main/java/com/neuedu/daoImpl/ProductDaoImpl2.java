package com.neuedu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.JDBC;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public class ProductDaoImpl2 implements ProductDao {
	
	

	
	
//������Ʒ
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		//����������
		//����������
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			
			int _id=product.getId();
			String name=product.getName();
			double price=product.getPrice();
			String image=product.getImage();
			int stock=product.getStock();
			String detail=product.getDetail();
			String sql="insert into product( pname,price,image,stock,detail)  values(?,?,?,?,?)";
			st= con.prepareStatement(sql);
			//'"+name+"','"+price+"','"+image+"','"+stock+"','"+detail+"'
			st.setString(1, name);
			st.setDouble(2, price);
			st.setString(3, image);
			st.setInt(4, stock);
			st.setString(5, detail);
			
			st.execute();		
			System.out.println("��ӳɹ�");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			String sql="delete	from product where productid= ?";
			st= con.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
		
		
		
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			int _id=product.getId();
			String name=product.getName();
			double price=product.getPrice();
			String image=product.getImage();
			int stock=product.getStock(); 
			String detail=product.getDetail();
			
			String sql="update	product set pname=? ,price=? ,image=? ,stock=? ,detail=?    where productid=?";
			st= con.prepareStatement(sql);
			st.setString(1,name);
			st.setDouble(2, price);
			st.setString(3, image);
			st.setInt(4, stock);
			st.setString(5, detail);
			st.setInt(6, _id);
			st.execute();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
		
		
		
		
	}
	//ͨ��id�鿴
	@Override
	public Product findproductById(int id) {
		// TODO Auto-generated method stub
		
		Product product=new Product();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from product where productid=?";
			st=con.prepareStatement(sql);
			st.setInt(1, id);
			
			re=st.executeQuery();
			if(re.first()){
				if(re.getInt("productid")==id) {
					
					
				product.setId(id);
				product.setName(re.getString("pname"));
				product.setDetail(re.getString("detail"));
				product.setPrice(re.getDouble("price"));
				product.setImage(re.getString("image"));	
				product.setStock(re.getInt("stock"));
					System.out.println("���ҵ�"+product);
				return product;
				}else {
					System.out.println("0000");
				}
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return product;
		
		
		
	}
	//�޸�
	public boolean updateProductStock(Product product) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			
			int _id=product.getId();
			
			int stock=product.getStock();
			
			
			String sql="update	product set stock=?   where productid=? ";
			st= con.prepareStatement(sql);
			st.setInt(1, stock);
			st.setInt(2, _id);
			
			
			st.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	
	
	
	
	}

	public List<Product> findDetailById(int id){
		return null;
	}
	public  List<Product> findAll(){
		
		List<Product> pros=new ArrayList<Product>();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select productid,pname,"
					+ "price,image,stock,detail "
					+ "from product" ;
			st=con.prepareStatement(sql);
			
			re=st.executeQuery();
			
			while(re.next()) {
				int productid=re.getInt("productid");
				String  pname=re.getString("pname");
				double price=re.getDouble("price");
				String image=re.getString("image");
				int stock=re.getInt("stock");
				String detail=re.getString("detail");
				
				Product pro=new Product();
				pro.setId(productid);
				pro.setName(pname);
				pro.setPrice(price);
				pro.setDetail(detail);
				pro.setStock(stock);
				pros.add(pro);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return pros;	
		

}	
	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Product> PageModel=new PageModel<Product>();
		
		Connection con=null; 
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			System.out.println("����dao");	
			con=JDBC.conn();
			
			String sqlcount="select count(productid) from product";
			st=con.prepareStatement(sqlcount);
			 
			re=st.executeQuery();
			System.out.println("2");	
			if(re.next()) {
				
			int totalcount= re.getInt(1);//�ܼ�¼
			//�������Ҷ
		int totalPage=(totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1);
		PageModel.setTotalPage(totalPage);
		System.out.println("3");
			}
			 
			
			String sql=" select productid,pname,"
					+ "price,image,stock,detail "
					+ "from product limit ?,? "   ;
			st=con.prepareStatement(sql);
			 st.setInt(1,(pageNo-1)*pageSize);
			 st.setInt(2,pageSize);
			re=st.executeQuery();
			List<Product> pros=new ArrayList<Product>();
			System.out.println("1");	
			while(re.next()) {
				
				int productid=re.getInt("productid");
				String  pname=re.getString("pname");
				double price=re.getDouble("price");
				String image=re.getString("image");
				int stock=re.getInt("stock");
				String detail=re.getString("detail");
				Product pro=new Product();
				pro.setId(productid);
				pro.setName(pname);
				pro.setPrice(price);
				pro.setDetail(detail);
				pro.setStock(stock);
				pros.add(pro);
				System.out.println("4");
					
			}
						
			
	
			PageModel.setDate(pros);
			PageModel.setCurrentPage(pageNo);
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return PageModel;	
		
		
		
		
		
		
		
	}

}
