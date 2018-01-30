package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCookiesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html); charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>쿠키목록</h1><br>");
		
		// 클라이언트에 있는 쿠키의 배열을 가져온다.
		// 클라이언트가 요청을 한것이여
		Cookie[] cookies = req.getCookies();
		
		// 배열 안에 머가 들어있는지 확인하기 위해 for문 돌림
		// 쿠키가 있는지 확인, 있다면 for문을 이용해 cookies에 저장된 쿠키를 출력
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				out.print(cookies[i].getName());
				out.print(" = ");
									// decode를 이용해 encode 한 값을 읽을 수 있도록 바뀜바뀜.
				out.print(URLDecoder.decode(cookies[i].getValue(), "utf-8") + "<br>");
			}
		} else {
			out.println("쿠키가 존재하지 않습니다.");
		}
		
		out.flush();
		out.close();
	}

}
