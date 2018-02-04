package com.shuaichao.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> local = new ThreadLocal<>();

	public static DataSource getDataSource() {
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = local.get();
		if (conn == null) {
			conn = ds.getConnection();
			local.set(conn);
		}
		return conn;
	}

	public static void startTransaction() throws SQLException {
		Connection conn = getConnection();
		conn.setAutoCommit(false);
	}

	public static void commitAndClose() {
		try {
			Connection conn = getConnection();
			local.remove();
			DbUtils.commitAndClose(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

	}

	public static void rollbackAndClose() {
		try {
			Connection conn = getConnection();
			local.remove();
			DbUtils.rollbackAndClose(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}