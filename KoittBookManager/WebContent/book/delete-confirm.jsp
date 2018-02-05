<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>삭제 확인</title>
</head>
<body>
	<h1>삭제 확인</h1>

	<h2>${ param.isbn }번 글을 삭제하시겠습니까?</h2>

	<form action="<c:url value='/BookServlet' />" method="post">
		<input type="hidden" name="cmd" value="CMD_DELETE">
		<input type="hidden" name="isbn" value="${ param.isbn }">
		<input type="submit" value="예">
	</form>
	<a href="<curl value='/BookServlet?cmd=CMD_LIST'/>">
	도서 목록으로 이동
	</a>
</body>
</html>