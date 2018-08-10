package com.neuedu.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.JDBC;
import com.neuedu.entity.Order;


public class OrderDaoImpl2 implements OrderDao {

	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub

		Connection con = null;//
		PreparedStatement st = null;
		//ʵ����������
		try {
			//��ȡ����
			con = JDBC.conn();
			//��ȡstatement����ִ��sql���

			int user_id = order.getUser_id();
			int shipping_id = order.getShipping_id();
			long order_no = order.getOrder_no();
			String payment_type = order.getPayment_type();
			int postage = order.getPostage();
			int status = order.getStatus();
			double payment = order.getPayment();
			long create_time = order.getCreate_time();


			String sql4 = "insert into orders( user_id,shipping_id,order_no,payment_type,postage,status,payment,create_time) "
					+ " values(?,?,?,?,?,?,?,now())";

			st = con.prepareStatement(sql4);
/**
 * "+user_id+","+shipping_id+","+order_no+",'
 * "+payment_type+"',"+postage+","+status+","+payment+",now() 
 * */

			st.setInt(1, user_id);
			st.setInt(2, shipping_id);
			st.setLong(3, order_no);
			st.setString(4, payment_type);
			st.setInt(5, postage);
			st.setInt(6, status);
			st.setDouble(7, payment);

			st.execute();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<Order> findAll() {
		// TODO Auto-generated method stub

		List<Order> orders = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet re = null;

		try {

			con = JDBC.conn();

			String sql = "select * from orders";
			st = con.prepareStatement(sql);
			re = st.executeQuery();

			while (re.next()) {
				int ordersid = re.getInt("ordersid");
				int user_id = re.getInt("user_id");
				int shipping_id = re.getInt("shipping_id");
				String payment_type = re.getString("payment_type");
				int postage = re.getInt("postage");
				int status = re.getInt("status");
				long order_no = re.getLong("order_no");
				double payment = re.getDouble("payment");
				long create_time = re.getLong("create_time");

				Order order = new Order();
				order.setOrdersid(ordersid);
				order.setUser_id(user_id);
				order.setShipping_id(shipping_id);
				order.setOrder_no(order_no);
				order.setPayment_type(payment_type);
				order.setPostage(postage);
				order.setStatus(status);
				order.setPayment(payment);
				order.setCreate_time(create_time);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				JDBC.close(con, st, re);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orders;
	}

	@Override
	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(long order_no,int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int idBySize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findOrderItemByOrderNo(long order_no) {
		return null;
	}
}



