<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%
    String ctx = request.getContextPath(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
    
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>

	<%@ include file="/main/main_header.jsp" %>
	
	<table border=1 width=650 align=center>
		<caption>상세 페이지</caption>
		<tr>
			<td>제목 ${board_subject}</td>
		</tr>
		<tr>
			<td>내용 ${board_content}</td>
		</tr>
		<tr>
			<td><textarea  width=650 id="smartEditor" name="board_content" placeholder=""></textarea></td>
		</tr>
		<tr>
			<td><button id="">댓글달기</button></td>
		</tr>
		<tr>
			<td colspan=2 align=center><input type="button" value="수정"
				onClick="location.href='./LiveModifyAction.seed?board_num=${board.board_num}&page=${page}' ">

				<input type="button" value="삭제"
				onClick="location.href='./LiveDelete.seed?board_num=${board.board_num}&page=${page}' ">

				<input type="button" value="목록"
				onClick="location.href='./LiveListAction.seed?page=${page}' ">

			</td>
		</tr>
	</table>
	<script defer src="<%=request.getContextPath()%>/live/smarteditor.js"></script>
</body>
</html>
