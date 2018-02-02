<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글 삭제 결과</title>
</head>
<body>
	<h1>글 삭제 결과</h1>
	<h2>삭제 성공</h2>
	<a href="<c:url value='/BoardServlet?cmd=CMD_LIST'/>">
	글 목록으로 이동
	</a>
</body>
</html>