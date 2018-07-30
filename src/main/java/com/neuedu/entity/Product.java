package com.neuedu.entity;

import java.io.Serializable;

public class Product implements Serializable{
	
	public Product(int productid, String pname, String detail, double price, int stock, String image) {
		super();
		this.productid = productid;
		this.pname = pname;
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

	@Override
	public String toString() {
		return "Product{" +
				"productid=" + productid +
				", pname='" + pname + '\'' +
				", detail='" + detail + '\'' +
				", price=" + price +
				", stock=" + stock +
				", image='" + image + '\'' +
				", rule='" + rule + '\'' +
				'}';
	}

	private int productid;
	private String pname;
	private String detail;
	private double price;
	private int stock;
	private String image;
	private String rule;
	public Product( String pname, String detail, double price, int stock, String image) {
		super();
		this.pname = pname;
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
	

	public int getProductid() {
		return productid;
	}
	public void setId(int productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setName(String pname) {
		this.pname = pname;
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

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getRule() {
		return rule;
	}

	public Product(int productid, String pname, String detail, double price, String image,String rule) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.detail = detail;
		this.price = price;
		this.image=image;
		this.rule=rule;

	}
	public Product( String pname, String detail, double price,String image) {
		super();
		
		this.pname = pname;
		this.detail = detail;
		this.price = price;
		this.image=image;
	
	}

	public Product() {
		super();
	}
	

}
