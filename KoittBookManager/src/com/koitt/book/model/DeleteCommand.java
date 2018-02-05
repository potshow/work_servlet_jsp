package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;

public class DeleteCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalAccessException {
		String page = "./book/delete.jsp";
		
		String _isbn = req.getParameter("isbn");
		
		if (_isbn == null || _isbn.trim().length() == 0) {
			throw new IllegalAccessException("ISBN 번호를 입력해주세요.");
		}
		
		Integer isbn = Integer.parseInt(_isbn);
		
		BookDao dao = new BookDao();
		
		dao.delete(isbn);
		
		return page;
	}

}
