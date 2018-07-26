package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/*��ҳģ��
 * 
 * ����
 * */

public class PageModel<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4090015360182961718L;
	//ÿһҳ�����ݼ���
	private List<T> date;
	//�ܹ�����ҳ
	private int totalPage;
	//��ǰҳ��
	private int currentPage;
	
	
	public PageModel() {
		super();
	}
	public PageModel(List<T> date, int totalPage, int currentPage) {
		super();
		this.date = date;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getDate() {
		return date;
	}
	public void setDate(List<T> date) {
		this.date = date;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	

}
