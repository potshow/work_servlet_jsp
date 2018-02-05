package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;

public class InsertCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		String page = "./book/insert-ok.jsp";
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		
		Book book = new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(Integer.parseInt(price));
		book.setDescription(description);
		
		BookDao dao = new BookDao();
		
		dao.insert(book);
		
		return page;
		
	}

}
