package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {

	/*
	 * 방법1 : Deployment Descriptor(web.xml) 파일을 이용하여 Servlet 연결
	 * ( 배포할 시의 장단점 )
	 * 장점 : .java 파일을 컴파일을 다시 하지않고 url 주소를 변경할 수 있다.
	 * 단점 : 방법2 보다 불편하다. (web.xml 파일도 작성해야 한다는 불편함) 
	 * 
	 * HTTP Method GET 요청을 받으면 호출되는 메서드
	 * HttpServletRequest : 클라이언트로부터 전달받은 요청
	 * HttpServletResponse : 서버가 클라이언트로 전달할 응답
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	// resp객체에 클라이언트로 보낼 문서형식과 인코딩 타입 설정
	// 클라이언트에 값을 보내고 싶을땐 response를 사용
	resp.setContentType("text/html; charset=utf-8");
	
	// resp 객체로부터 출력스트림을가져온다.
	PrintWriter out = resp.getWriter();
	
	// 출력스트림의 println 메서드를 이용하여 클라이언트로 보낼 내용을 작성
	out.println("<html>;");
	out.println("<head><title>현재시간</title></head>");
	out.println("<body>");
	out.println(new Date());
	out.println("입니다.");
	out.println("</body></html>");
	
	// 버퍼에 남아있는 내용을 깨끗이 보낸 후 출력스트림 닫기
	out.flush();
	out.close();
	}
}
