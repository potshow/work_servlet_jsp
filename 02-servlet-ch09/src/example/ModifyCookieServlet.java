package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		// 클라이언트에 적용된 쿠키배열을 가져온다.
		Cookie[] cookies = req.getCookies();
		
		// 쿠키 존재하는지 체크
		if (cookies != null && cookies.length > 0) {
			// for문을 이용해 찾는 key가 있는지 확인하고 새로 쿠키를 입력한다.
			// 쿠키는 따로 수정하는 메서드가 없기 때문에 
			// 같은 key값을 적고 value 값을 다르게 적으면 알아서 덮어 씌어진다.
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					Cookie cookie = 
							new Cookie("name", URLEncoder.encode("JSP프로그래밍", "utf-8"));
					resp.addCookie(cookie);
					break;
				}
			}
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>name 쿠키의 값을 변경합니다.</h1>");
		
		out.flush();
		out.close();
	}
	
}
