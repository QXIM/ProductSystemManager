package com.neuedu.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.OrderItem;

public class Input {
	
	/*��������*/
	public static int inputInt(String input){
		Scanner scanner = new Scanner(System.in);
		System.out.print(input);
		return scanner.nextInt();
	
	}

	/*�����ַ���*/
	public static String input(String input){
		Scanner scanner = new Scanner(System.in);
		System.out.print(input);
		return scanner.nextLine();
	
	}
	public static double inputDouble(String input){
		Scanner scanner = new Scanner(System.in);
		System.out.print(input);
		return scanner.nextDouble();
	
	}
	
	public static OrderItem createItem(int id,long Order_no,Cart c){
		
		
		OrderItem orderItem =new  OrderItem();
			orderItem.setId(id);
			orderItem.setProduct_id(c.getProduct().getId());
			orderItem.setProduct_name(c.getProduct().getName());
			orderItem.setOrderItem_no(Order_no);
			orderItem.setCurrent_unit_price(c.getProduct().getPrice());
			orderItem.setQuantity(c.getQuantity());
			orderItem.setTotal_price(c.getProduct().getPrice()*c.getQuantity());
			return orderItem;
	}
	
	
	
	
	
	
	
	

}
