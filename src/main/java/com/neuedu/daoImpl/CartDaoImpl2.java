package com.neuedu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.JDBC;
import com.neuedu.entity.Product;

public class CartDaoImpl2 implements CartDao {
	

	@Override
	public boolean addCart(Cart Cart) {
		// TODO Auto-generated method stub
		
		//������Ʒ
		
		
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
				
				Long num=Cart.getCart_no();
				int pid=Cart.getProduct().getProductid();
				int quantity=Cart.getQuantity();
				String sql2="insert into cart(num,product_id,quantity)  values(?,?,?)";				
				st= con.prepareStatement(sql2);
				//'"+_id+"','"+num+"','"+pid+"','"+quantity+"'
				st.setLong(1, num);
				st.setInt(2, pid);
				st.setInt(3, quantity);
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
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		
		List<Cart> carts=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from cart" ;
			st=con.prepareStatement(sql);
			re=st.executeQuery();
			
			while(re.next()) {
				//cartid,num,product_id,quantity
				int cartid=re.getInt("cartid");
				long  num=re.getLong("num");
				int product_id=re.getInt("product_id");
				int quantity=re.getInt("quantity");
				
				List<Product> pro=findDetailById(product_id);
				for(int i=0;i<pro.size();i++) {
					Product products=pro.get(i);
					
					Cart cart=new Cart();
					cart.setId(cartid);
					cart.setCart_no(num);
					cart.setQuantity(quantity);
					cart.setProduct(products);
					carts.add(cart);
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
	return carts;
		
		
		
	}
	//��Ʒ
	public List<Product> findDetailById(int product_id) {
		// TODO Auto-generated method stub
		
		List<Product> pros=new ArrayList<Product>();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from product where productid=?";
			st=con.prepareStatement(sql);
			st.setInt(1, product_id);
			
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
				pro.setImage(image);
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
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			
			String sql2="delete from cart where cartid=?"; 				
			
			st= con.prepareStatement(sql2);
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
	public boolean updateCartNum(int id, int quantity) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		Statement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			st= con.createStatement();
			
			String sql2="update  cart set quantity="+quantity+" where cartid="+id; 				
			st.execute(sql2);		
			
			
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
	public int idBySize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		Connection con=null;//
		Statement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			st= con.createStatement();
			
			String sql2="delete from cart "; 				
			st.execute(sql2);		
			
			
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
		
	}

	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		
		Cart cart=new Cart();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from cart where cartid=?";
			st=con.prepareStatement(sql);
			st.setInt(1, id);
			
			re=st.executeQuery();
			if(re.first()){
				if(re.getInt("cartid")==id) {
					
					
					cart.setId(id);
					cart.setQuantity(re.getInt("quantity"));
				
					System.out.println("���ҵ�"+cart);
				return cart;
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
	return cart;
		
		
	
	}
	

}
