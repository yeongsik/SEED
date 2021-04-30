<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
</head>

<body>

<%@ include file="/main/main_header.jsp" %>

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
		<input type="text" id="board_subject" name="board_subject" value="${news.board_subject}">
	</td>
</tr>
<tr>
	<td>글내용</td>
	<td>
	<textarea rows="3" cols="5" id="board_content" name="board_content">
		${news.board_content }
	</textarea>
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