package com.koitt.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.book.util.DBUtil;
import com.koitt.book.vo.Book;

public class BookDao {

	public List<Book> selectAll() throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT * FROM book ORDER BY isbn DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			
			book.setIsbn(rs.getInt("isbn"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getInt("price"));
			book.setDescription(rs.getString("description"));
			
			list.add(book);
			
		}
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
	
	public void insert (Book book) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO book (title, author, publisher, price, description) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.setString(5, book.getDescription());
		
		pstmt.executeUpdate();
		
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		
	}
	
	public Book select(Integer isbn) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT * FROM book WHERE isbn = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  isbn);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		Book book = new Book();
		book.setIsbn(rs.getInt("isbn"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPublisher(rs.getString("publisher"));
		book.setPrice(rs.getInt("price"));
		book.setDescription(rs.getString("description"));
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return book;
	}
	
	public void delete(Integer isbn) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "DELETE FROM book WHERE isbn = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  isbn);
		
		pstmt.executeUpdate();
		
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
	}
	
}
