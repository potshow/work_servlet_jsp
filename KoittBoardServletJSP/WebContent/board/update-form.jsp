<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정 페이지</title>
</head>
<body>
	<h1>글 수정 페이지</h1>
	<a href="<c:url value='/BoardServlet?cmd=CMD_LIST' />">글 목록</a>

	<form action="<c:url value='/BoardServlet' />" method="post">
	
		<input type="hidden" name="cmd" value="CMD_UPDATE"> <input type="hidden" name="no" value='${ requestScope.board.no }'>
		
		<div>번호 : ${ requestScope.board.no }</div>
		
		<input type="hidden" name="cmd" value="CMD_UPDATE"> <label>제목:<input type="text" name="title" value='${ requestScope.board.title }'></label><br>
		
		<div>작성자 : ${ requestScope.board.writer }</div><br> 
		
		<label>내용 : </label>
		
		<textarea rows="3" cols="50" name="content">
			${ requestScope.board.content }
		</textarea><br> 
		
		<input type="submit" value="글 수정">
	</form>

</body>
</html>
