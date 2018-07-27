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
	private int productid;
	private String pname;
	private String detail;
	private double price;
	private int stock;
	private String image;
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
	public Product(int productid, String pname, String detail, double price,String image) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.detail = detail;
		this.price = price;
		this.image=image;
	
	}
	public Product( String pname, String detail, double price,String image) {
		super();
		
		this.pname = pname;
		this.detail = detail;
		this.price = price;
		this.image=image;
	
	}
	@Override
	public String toString() {
		return "商品 [商品id=" + productid + ", 商品名称=" + pname + ", 商品详细=" + detail + ", 商品价格=" + price +  ", 商品库存=" + stock +"]";
	}
	public Product() {
		super();
	}
	

}
