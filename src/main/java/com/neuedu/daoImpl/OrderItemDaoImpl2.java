package com.neuedu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.JDBC;

import com.neuedu.entity.OrderItem;

public class OrderItemDaoImpl2 implements OrderItemDao {
	
	@Override
	public boolean addOrderItem(List<OrderItem> orderItem) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			for(int i=0;i<orderItem.size();i++) {
				OrderItem orderItems=orderItem.get(i);
				
			StringBuffer sbf=new StringBuffer();
			sbf.append("insert into orderItem(user_id, orderItem_no,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time) values");
			
				 	
					int  user_id=orderItems.getUser_id();
					long orderItem_no=orderItems.getOrderItem_no();
						 int  product_id=orderItems.getProduct_id();
						 String product_name=orderItems.getProduct_name();
						 String product_image=orderItems.getProduct_image();
						 double current_unit_price=orderItems.getCurrent_unit_price();
						 int quantity=orderItems.getQuantity();
						 double total_price=orderItems.getTotal_price();
						 long create_time=orderItems.getCreate_time();
		sbf.append("(")	;			 
		sbf.append(+user_id+",");					 
		sbf.append(+orderItem_no+",");
		sbf.append(+product_id+",");
		sbf.append("'"+product_name+"',");
		sbf.append("'"+product_image+"',");
		sbf.append(+current_unit_price+",");
		sbf.append(+quantity+",");
		sbf.append(+total_price+",");
		sbf.append("now()");
		
		sbf.append(")");	
		
		if(i!=orderItem.size()-1) {
			sbf.append(",");	
		}				 
						 
		st= con.prepareStatement(sbf.toString());				 				 
		System.out.println(sbf);
			st.execute();		
			
			}
			
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
	public List<OrderItem> findAll() {
		
		// TODO Auto-generated method stub
		
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from orderItem" ;
			st=con.prepareStatement(sql);
			re=st.executeQuery();
			
			while(re.next()) {
				
				
		int orderItemid=re.getInt("orderItemid");
		int user_id=re.getInt("user_id");
		long orderItem_no=re.getLong("orderItem_no");
				int product_id=re.getInt("product_id");
				String  product_name=re.getString("product_name");
				String  product_image=re.getString("product_image");
				double current_unit_price=re.getDouble("current_unit_price");
				long create_time=re.getLong("create_time");
				long update_time=re.getLong("update_time");
				int quantity=re.getInt("quantity");
				double total_price=re.getDouble("total_price");
				
				
				OrderItem orderItem=new OrderItem();
				
				orderItem.setId(orderItemid);
				orderItem.setUser_id(user_id);
				orderItem.setOrderItem_no(orderItem_no);
				orderItem.setProduct_id(product_id);
				orderItem.setProduct_name(product_name);
				orderItem.setProduct_image(product_image);
				orderItem.setCurrent_unit_price(current_unit_price);
				orderItem.setCreate_time(create_time);
				orderItem.setUpdate_time(update_time);
				orderItem.setQuantity(quantity);
				orderItem.setTotal_price(total_price);
				
			
				orderItems.add(orderItem);
			System.out.println(orderItem);
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
	return orderItems;
		
		
		
	}

	@Override
	public boolean deleteOrderItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int idBySize() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public List<OrderItem> findOrderItemByOrderNo(Long order_no) {
		return null;
	}

}
