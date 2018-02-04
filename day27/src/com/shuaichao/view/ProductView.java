package com.shuaichao.view;

import java.sql.Date;
import java.util.Scanner;

import com.shuaichao.bean.Product;
import com.shuaichao.exception.ProductNotExistException;
import com.shuaichao.service.ProductService;

public class ProductView {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("----欢迎进入商品的后台管理系统----");

		while (true) {
			System.out.println("请选择菜单：	a) 查询所有	b) 编号查询 	c) 添加产品 	d) 修改产品	e) 删除商品 	g) 退出");
			String chose = sc.next().toLowerCase();

			switch (chose) {
			case "a":
				inquiry();
				break;
			case "b":
				inquiryID();
				break;
			case "c":
				addProduct();
				break;
			case "d":
				changeProduct();
				break;
			case "e":
				deleteProduct();
				break;
			case "g":
				System.out.println("退出商品系统...");
				System.exit(0);
				break;

			default:
				System.out.println("输入错误");
				break;
			}

		}

	}

	// e) 删除一件
	// 删除多件
	private static void deleteProduct() {
		ProductService ps = new ProductService();
		System.out.println("请输入要删除的商品的编号(格式：1,2,3...)：");
		String id = sc.next();
		String[] split = id.split(",");
		int[] ids = new int[split.length];
		for (int i = 0; i < ids.length; i++) {

			ids[i] = Integer.parseInt(split[i]);
		}

		System.out.println("再次确认是否删除(Y/N)");
		String quest = sc.next();
		if (!"Y".equalsIgnoreCase(quest)) {
			System.out.println("取消删除");
			System.out.println();
		}
		try {
			ps.deleteProduct(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("删除成功");
		System.out.println();
	}

	// d) 修改产品
	private static void changeProduct() {
		ProductService ps = new ProductService();

		System.out.println("请输入需要修改的商品编号：");
		int id = sc.nextInt();
		try {
			ps.inquiryID(id);
		} catch (ProductNotExistException e) {
			e.printStackTrace();
		}

		System.out.println("请输入新商品名称：");
		String pname = sc.next();
		System.out.println("请输入新商品价格：");
		double price = sc.nextDouble();
		System.out.println("请输入新商品生产日期：");
		String date = sc.next();
		Date pdate = Date.valueOf(date);

		Product p = new Product(pname, price, pdate);

		try {
			ps.changeProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("修改成功");
		System.out.println();
	}

	// c) 添加产品
	private static void addProduct() {
		ProductService ps = new ProductService();

		System.out.println("请输入商品名称：");
		String pname = sc.next();
		System.out.println("请输入商品价格：");
		double price = sc.nextDouble();
		System.out.println("请输入生产日期(格式： 1970-01-01)：");
		String date = sc.next();
		Date pdate = Date.valueOf(date);

		Product p = new Product(pname, price, pdate);

		try {
			ps.addProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("添加成功");
		System.out.println();
	}

	// b) 编号查询
	private static void inquiryID() {

		System.out.println("请输入要查询的商品编号：");
		int id = sc.nextInt();
		ProductService ps = new ProductService();

		try {
			ps.inquiryID(id);
		} catch (ProductNotExistException e) {
			e.printStackTrace();
		}

		System.out.println();

	}

	// a) 查询所有
	private static void inquiry() {

		ProductService ps = new ProductService();
		try {
			ps.inquiry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

}
