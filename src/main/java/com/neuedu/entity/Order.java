package com.neuedu.entity;

import java.io.Serializable;

public class Order implements Serializable {
	
	
	
	
	private static final long serialVersionUID = 7046575901122010263L;
	private int id;
	private int	user_id;
	private int	shipping_id;
	private String payment_type;	
	private int	postage;
	private int	status;
	private long order_no;
	private long create_time;
	private double payment;

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", user_id=" + user_id +
				", shipping_id=" + shipping_id +
				", payment_type='" + payment_type + '\'' +
				", postage=" + postage +
				", status=" + status +
				", order_no=" + order_no +
				", create_time=" + create_time +
				", payment=" + payment +
				'}';
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}
	
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public int getPostage() {
		return postage;
	}
	public void setPostage(int postage) {
		this.postage = postage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public Order() {
		super();
	}
	public Order(int id, long order_no, long create_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.create_time = create_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}

}
