package com.neuedu.entity;

import java.io.Serializable;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4514270705116413726L;
	private int id;
	private long cart_no;
	private int quantity=1;
	private Product product;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCart_no() {
		return cart_no;
	}
	public void setCart_no(long cart_no) {
		this.cart_no = cart_no;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart(int id, long cart_no, Product product ,int quantity) {
		super();
		this.id = id;
		this.cart_no = cart_no;
		this.product = product;
		this.quantity=quantity;
	}
	@Override
	public String toString() {
		return "���ﳵ�� [���ﳵid=" + id + ", ���ﳵ���=" + cart_no + ", ��Ʒ=" + product + "��������=  "+quantity+"]";
	}
	public Cart() {
		super();
	}
	

}
