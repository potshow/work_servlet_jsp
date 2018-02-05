<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>도서 등록 결과</title></head>
<body>
	<h1>도서 등록 결과</h1><br>
	<h2>정상적으로 도서 정보가 입력되었습니다.</h2><br>
	<a href="<c:url value='/BookServlet?cmd=CMD_LIST' />">글 목록으로 이동</a>
</body>
</html>