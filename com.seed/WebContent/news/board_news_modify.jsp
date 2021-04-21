<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/NewsModify.seed">
<input type="hidden" name="board_num" value="${news.board_num }">
<input type="hidden" name="page" value="${page}">
<table border=1 align=center width=800>
<tr>
	<td colspan=2>
		<select id="board_category" name="board_category">
			<option>카테고리 지정해주세요</option>
			<option value="개발동향" <c:if test="${news.board_category =='개발동향' }">${'selected'}</c:if>>개발동향</option>
			<option value="취업뉴스" <c:if test="${news.board_category =='취업뉴스' }">${'selected'}</c:if>>취업뉴스</option>
		</select>
	</td>
	<td>
		작성자 : ${news.name}
		<input type="hidden" name="board_name" value="${news.name}">
	</td>
</tr>
<tr>
	<td>글제목</td>
	<td>
		<input type="text" id="board_subject" , name="board_subject" value="${news.board_subject}">
	</td>
</tr>
<tr>
	<td>글내용</td>
	<td>
		${news.board_content }
	</td>
</tr>
<tr>
	<td>
		<input type="submit" value="글작성">
		<input type="reset" value="취소">
	</td>
</table>
</form>
</body>
</html>