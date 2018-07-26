package com.neuedu.entity;

import java.io.Serializable;

public class Product implements Serializable{
	
	public Product(int id, String name, String detail, double price, int stock, String image) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}
	/**
	 * 
	 */
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	private static final long serialVersionUID = -8794185251517382884L;
	private int id;
	private String name;
	private String detail;
	private double price;
	private int stock;
	private String image;
	public Product( String name, String detail, double price, int stock, String image) {
		super();
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(int id, String name, String detail, double price,String image) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image=image;
	
	}
	public Product( String name, String detail, double price,String image) {
		super();
		
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image=image;
	
	}
	@Override
	public String toString() {
		return "��Ʒ [��Ʒid=" + id + ", ��Ʒ����=" + name + ", ��Ʒ��ϸ=" + detail + ", ��Ʒ�۸�=" + price +  ", ��Ʒ���=" + stock +"]";
	}
	public Product() {
		super();
	}
	

}
