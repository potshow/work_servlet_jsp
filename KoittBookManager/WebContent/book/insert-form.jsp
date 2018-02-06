<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>도서 등록 페이지</title>
</head>
<body>
	<h1>책 정보를 입력해주세요.</h1>
	
	<a href="<c:url value='/BookServlet?cmd=CMD_LIST'/>">도서 목록</a>
	
	<form action="<c:url value='/BookServlet' />" method="post">
		<input type="hidden" name="cmd" value="CMD_INSERT">
		
		<label>제목 : <input type="text" name="title"></label><br>
		<label>저자 : <input type="text" name="author"></label><br>
		<label>출판사 : <input type="text" name="publisher"></label><br>
		<label>가격 : <input type="text" name="price"></label><br>
		<label>부가설명 : </label><textarea rows="3" cols="50" name="description"></textarea><br>
		<input type="submit" value="도서 등록">
	</form>

</body>
</html>