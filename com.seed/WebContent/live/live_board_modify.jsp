<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
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
    
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx%>/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
</head>
<body>
	<%@ include file="/main/main_header.jsp" %>
	
	<form action="<%=request.getContextPath()%>./LiveModify.seed"
		method="post">
		<input type="hidden" id="board_num" name="board_num" value="${board.board_num }">
		<input type="hidden" id="page" name="page" value="${board.page }">
		
		<table border=1 style="width: 650px;">
			<tr align="center" valign="middle">
				<td colspan="6"><select name="board_category">
						<option>일상얘기</option>
						<option>직장얘기</option>
				</select>카테고리 선택</td>
			</tr>
			<tr>
				<td height="16">
					<div align="center">글 제목</div>
				</td>
				<td><input name="board_subject" id="board_subject" type="text"
					size="10" maxlength="10" value="" /></td>
			</tr>
			<tr>
				<td>
					<div align="center">비밀번호</div>
				</td>
				<td><input name="board_pass" id="board_pass" type="password"
					size="10" maxlength="10" value="" /></td>
			</tr>
			<tr>
				<td>
					<div align="center">내용</div>
				</td>
				<td><textarea name="smartEditor" id="smartEditor" cols="67"
						rows="15">${live.board_content }</textarea></td>
			</tr>

			<tr bgcolor="cccccc">
				<td colspan="3" style="height: 1px;"></td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><input type=submit value="글 수정"> <input
					type=reset value="취소"></td>
			</tr>
		</table>
		<script defer
			src="<%=request.getContextPath()%>../live/smarteditor.js"></script>
	</form>
</body>
</html>