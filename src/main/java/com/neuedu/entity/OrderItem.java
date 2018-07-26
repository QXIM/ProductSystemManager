package com.neuedu.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -494723685089991504L;
	private int  orderItemid;
	private int  user_id;
	private long orderItem_no;
	private int  product_id;
	private String product_name;
	private String product_image;
	private double current_unit_price;  
	private long create_time;
	private long update_time;
	private int quantity;
	private double total_price;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public double getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(double current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	
	
	
	
	
	
	public OrderItem(int id, long orderItem_no, String product_name, double product_price, double total_price,
			int quantity) {
		super();
		this.orderItemid = id;
		this.orderItem_no = orderItem_no;
		this.product_name = product_name;
		
		this.total_price = total_price;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return orderItemid;
	}
	public void setId(int id) {
		this.orderItemid = id;
	}
	public long getOrderItem_no() {
		return orderItem_no;
	}
	public void setOrderItem_no(long orderItem_no) {
		this.orderItem_no = orderItem_no;
	}
	
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OrderItem() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "������ϸ [����id=" + orderItemid + ", �û�id=" + user_id + ", ������=" + orderItem_no
				+ ", ��Ʒid=" + product_id + ", ��Ʒ����=" + product_name + ", ��ƷͼƬ=" + product_image
				+ ", ʵ�ʸ�����=" + current_unit_price + ", ��������ʱ��=" + create_time + ", ����޸�ʱ��="
				+ update_time + ", ����=" + quantity + ", �ܼ�=" + total_price + "]";
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
	
	
	
}
