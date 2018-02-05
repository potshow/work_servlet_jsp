package com.koitt.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static DBUtil instance;
	
	private DBUtil() { }
	
	public static DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		} return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306";
		String dbName = "bookmgr";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url + "/" + dbName, "root", "koitt");
		
		return conn;
		
	}
	
	public void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public void close(Statement stmt) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
	}
	
	public void close(ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
	}

	public void rollback(Connection conn) throws SQLException {
		if(conn != null) {
			conn.rollback();
		}
	}
	
	
}
