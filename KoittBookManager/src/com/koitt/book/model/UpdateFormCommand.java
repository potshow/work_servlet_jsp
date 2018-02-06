package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;

public class UpdateFormCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException {

		String page = "./book/update-form.jsp";


		String _isbn = req.getParameter("isbn");

		if (_isbn == null || _isbn.trim().length() == 0) {
			throw new IllegalArgumentException("isbn 번호가 필요합니다");
		}
		
		Integer isbn = Integer.parseInt(_isbn);

		BookDao dao = new BookDao();
		
		Book book = dao.select(isbn);
		
		if (book == null) {
			throw new NullPointerException("없거나 삭제된 도서정보 입니다.");
		}
		
		req.setAttribute("book",book);

		return page;
	}

}
