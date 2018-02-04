package com.shuaichao.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shuaichao.bean.Product;
import com.shuaichao.exception.ProductNotExistException;
import com.shuaichao.util.DataSourceUtils;

public class ProductDao {
	//1111111111111

	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

	// a) ��ѯ����
	public void inquiry() {
		try {
			List<Product> query = runner.query("select *from product", new BeanListHandler<>(Product.class));
			for (Product product : query) {
				System.out.println(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// b) ��Ų�ѯ
	public void inquiryID(int id) throws ProductNotExistException {
		try {
			Product query = runner.query("select *from product where id=?", new BeanHandler<>(Product.class), id);
			if (query == null) {
				throw new ProductNotExistException("������󣬸���Ʒ������");
			}
			System.out.println(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// c) ��Ӳ�Ʒ
	public void addProduct(Product p) {
		try {
			runner.update("insert into product values (null,?,?,?)", p.getPname(), p.getPrice(), p.getPDate());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// d) �޸Ĳ�Ʒ
	public void changeProduct(Product p) {
		try {
			runner.update("insert into product values (null,?,?,?)", p.getPname(), p.getPrice(), p.getPDate());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// e) ɾ��һ��
	public void deleteProduct(int id) {
		try {
			runner.update("delete from product where id=?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
