package com.shuaichao.view;

import java.sql.Date;
import java.util.Scanner;

import com.shuaichao.bean.Product;
import com.shuaichao.exception.ProductNotExistException;
import com.shuaichao.service.ProductService;

public class ProductView {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("----��ӭ������Ʒ�ĺ�̨����ϵͳ----");

		while (true) {
			System.out.println("��ѡ��˵���	a) ��ѯ����	b) ��Ų�ѯ 	c) ��Ӳ�Ʒ 	d) �޸Ĳ�Ʒ	e) ɾ����Ʒ 	g) �˳�");
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
				System.out.println("�˳���Ʒϵͳ...");
				System.exit(0);
				break;

			default:
				System.out.println("�������");
				break;
			}

		}

	}

	// e) ɾ��һ��
	// ɾ�����
	private static void deleteProduct() {
		ProductService ps = new ProductService();
		System.out.println("������Ҫɾ������Ʒ�ı��(��ʽ��1,2,3...)��");
		String id = sc.next();
		String[] split = id.split(",");
		int[] ids = new int[split.length];
		for (int i = 0; i < ids.length; i++) {

			ids[i] = Integer.parseInt(split[i]);
		}

		System.out.println("�ٴ�ȷ���Ƿ�ɾ��(Y/N)");
		String quest = sc.next();
		if (!"Y".equalsIgnoreCase(quest)) {
			System.out.println("ȡ��ɾ��");
			System.out.println();
		}
		try {
			ps.deleteProduct(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ɾ���ɹ�");
		System.out.println();
	}

	// d) �޸Ĳ�Ʒ
	private static void changeProduct() {
		ProductService ps = new ProductService();

		System.out.println("��������Ҫ�޸ĵ���Ʒ��ţ�");
		int id = sc.nextInt();
		try {
			ps.inquiryID(id);
		} catch (ProductNotExistException e) {
			e.printStackTrace();
		}

		System.out.println("����������Ʒ���ƣ�");
		String pname = sc.next();
		System.out.println("����������Ʒ�۸�");
		double price = sc.nextDouble();
		System.out.println("����������Ʒ�������ڣ�");
		String date = sc.next();
		Date pdate = Date.valueOf(date);

		Product p = new Product(pname, price, pdate);

		try {
			ps.changeProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("�޸ĳɹ�");
		System.out.println();
	}

	// c) ��Ӳ�Ʒ
	private static void addProduct() {
		ProductService ps = new ProductService();

		System.out.println("��������Ʒ���ƣ�");
		String pname = sc.next();
		System.out.println("��������Ʒ�۸�");
		double price = sc.nextDouble();
		System.out.println("��������������(��ʽ�� 1970-01-01)��");
		String date = sc.next();
		Date pdate = Date.valueOf(date);

		Product p = new Product(pname, price, pdate);

		try {
			ps.addProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ӳɹ�");
		System.out.println();
	}

	// b) ��Ų�ѯ
	private static void inquiryID() {

		System.out.println("������Ҫ��ѯ����Ʒ��ţ�");
		int id = sc.nextInt();
		ProductService ps = new ProductService();

		try {
			ps.inquiryID(id);
		} catch (ProductNotExistException e) {
			e.printStackTrace();
		}

		System.out.println();

	}

	// a) ��ѯ����
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
