<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>도서정보 수정 결과</title></head>
<body>
	<h1>도서 수정 결과</h1><br>
	<h2>수정 성공</h2><br>
	<a href="<c:url value='/BookServlet?cmd=CMD_LIST' />">도서 목록으로 이동</a>
</body>
</html>