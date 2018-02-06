package com.koitt.board.model.users;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.UsersDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Users;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class JoinCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {

		// 1. 포워딩 JSP페이지명
		String page = "./users/join-ok.jsp";

		// 2. 클라이언트로부터 전달받은 값을 변수에 저장
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String passwordConfirm = req.getParameter("password-confirm");
		String name = req.getParameter("name");

		// 만약 패스워드와 패스워드 확인 값이 다르면 쿼리문자열 사용해서 오류처리
		if (!password.equals(passwordConfirm)) {
			// 변수명 error : 변수값 password
			return "./users/join-form.jsp?error=password";
		}

		Users users = new Users();

		users.setEmail(email);
		users.setName(name);
		users.setPassword(password);


		UsersDao dao = new UsersDao();


		try { 
			dao.insert(users);
			
		} catch (MySQLIntegrityConstraintViolationException e) {
			
			return "./users/join-form.jsp?error=email";
		}
		return page;
	}

}