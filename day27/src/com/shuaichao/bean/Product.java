package com.shuaichao.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Product {

	private int id;
	private String pname;
	private double price;
	private Date pdate;
	//hahahah
	//222222222

	public Product() {
	}

	public Product(int id, String pname, double price, Date pdate) {
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.pdate = pdate;
	}

	public Product(String pname, double price, Date pdate) {
		super();
		this.pname = pname;
		this.price = price;
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "Product [编号=" + id + ", \t品名=" + pname + ", \t价格=" + price + ", \t生产日期="
				+ (new SimpleDateFormat("yyyy-MM-dd").format(pdate)) + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPDate() {
		return pdate;
	}

	public void setPDate(Date pdate) {
		this.pdate = pdate;
	}

}
