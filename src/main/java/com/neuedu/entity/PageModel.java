package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/*??????
 * 
 * ????
 * */

public class PageModel<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4090015360182961718L;
	//????????????
	private List<T> date;
	//????????
	private int totalPage;
	//??????
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

	@Override
	public String toString() {
		return "PageModel [date=" + date + ", totalPage=" + totalPage + ", currentPage=" + currentPage + "]";
	}

}
