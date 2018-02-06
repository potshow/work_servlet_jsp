package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;

public class UpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		
		String page = "./book/update-ok.jsp";
		
		String _isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		
		
	
		if (_isbn == null || _isbn.trim().length() == 0) {
			throw new IllegalArgumentException("도서 번호가 필요합니다.");
		}
		
		Integer isbn = Integer.parseInt(_isbn);
		

		Book book = new Book();
		
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(Integer.parseInt(price));
		book.setDescription(description);
		BookDao dao = new BookDao();
		
		dao.update(book);
		
		return page;
	}

}
