<!-- p. 123 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<title>초기화 파라미터 읽어보기</title>
</head>
<body>
	초기화 파라미터 목록:
	<ul>
	<% 	// 여기 안에 적는 내용은 다 서블릿에서도 쓸 수 있는 내용입니다
		// getInitParametName 을 씀으로써 web.xml의 param-name이 불러와 짐.
		Enumeration<String> initParamEnum = application.getInitParameterNames();
		while (initParamEnum.hasMoreElements()) {
			String initParamName = initParamEnum.nextElement();
	%>
	
	<li><%= initParamName %> = <%= application.getInitParameter(initParamName) %></li>
	
	<%
		}
	%>
	</ul>

</body>
</html>