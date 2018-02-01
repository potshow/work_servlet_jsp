<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("name", "최범균");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!-- 
		표현언어 EL(Expression Language)
		${ }
	 -->
	요청 URI: ${ pageContext.request.requestURI }<br>
	request의 name 속성 : ${ requestScope.name }<br>
	code 파라미터: ${ param.code }<br>
	
</body>
</html>