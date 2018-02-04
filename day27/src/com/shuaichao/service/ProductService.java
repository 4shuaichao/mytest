package com.shuaichao.service;

import java.sql.SQLException;

import com.shuaichao.bean.Product;
import com.shuaichao.dao.ProductDao;
import com.shuaichao.exception.ProductNotExistException;
import com.shuaichao.util.DataSourceUtils;

public class ProductService {

	ProductDao pd = new ProductDao();

	// a) ��ѯ����
	public void inquiry() {
		try {
			pd.inquiry();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// b) ��Ų�ѯ
	public void inquiryID(int id) throws ProductNotExistException {

		try {
			pd.inquiryID(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	// c) ��Ӳ�Ʒ
	public void addProduct(Product p) {
		try {
			pd.addProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	// d) �޸Ĳ�Ʒ
	public void changeProduct(Product p) {
		try {
			pd.changeProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// e) ɾ��һ��
	public void deleteProduct(int[] ids) {
		try {
			DataSourceUtils.startTransaction();
			for (int id : ids) {
				pd.deleteProduct(id);
			}
			DataSourceUtils.commitAndClose();
		} catch (SQLException e) {
			DataSourceUtils.rollbackAndClose();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
